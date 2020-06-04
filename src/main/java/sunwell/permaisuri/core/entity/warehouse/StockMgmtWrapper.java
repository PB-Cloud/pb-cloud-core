///*
// * StockMgmtWrapper.java
// *
// * Created on March 1, 2011, 10:30 AM
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//import java.math.BigDecimal;
//
//import java.sql.*;
//import java.util.Calendar;
//import java.util.LinkedList;
//import java.util.List;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//
///**
// *
// * @version 1.0 - March 1, 2011 ; Initial version
// * @version 1.5 - 2015 ; Tambahan informasi batch-no, serial-no, refType, dan refId
// * @version 1.6 - March 3, 2015 ; Enum RemovalRule, method removeStockAndCreateLog().
// * @version 1.7 - July 29, 2015 ; Perubahan behavior utk method removeOnHandStockUsingFifoRule dan 
// *                  removeOnHandStockUsingExpDateRule agar mengembalikan null jika hasil stored-procedure adl NULL.
// *
// * @author Irfin A
// */
//public class StockMgmtWrapper
//{
//    public static enum EnumRemovalRule {FIFO, EXP_DATE};
//    
//    private StockMgmtWrapper ()
//    {
//    }
//
//    public static class RemovedStock {
//        private Item item;
//        private Gudang gudang;
//        private double qty;
//        private Calendar expDate;
//        private String batchNo ;
//        private String serialNo ;
//        private int sourceType;
//        private Integer sourceId;
//
//        public void setItem (Item _i) { item = _i; }
//        public Item getItem () { return item; }
//        
//        public void setGudang (Gudang _g) { gudang = _g; }
//        public Gudang getGudang () { return gudang; }
//        
//        public void setQty (double _d) { qty = _d; }
//        public double getQty () { return qty; }
//        
//        public void setExpiryDate (Calendar _c) { expDate = _c; }
//        public Calendar getExpiryDate() { return expDate; }
//        
//        public void setBatchNo (String _s) { batchNo = _s; }
//        public String getBatchNo() { return batchNo ; } 
//        
//        public void setSerialNo (String _s) { serialNo = _s; }
//        public String getSerialNo() { return serialNo ; }
//        
//        public void setSourceRefType (int _i) { sourceType = _i; }
//        public int getSourceRefType () { return sourceType; }
//        
//        public void setSourceRefId (Integer _i) { sourceId = (_i != null) ? _i : 0; }
//        public int getSourceRefId() { return sourceId != null ? sourceId.intValue() : 0; }
//    }
//
//    /**
//     * Melakukan pengurangan stok on-hand dengan aturan FIFO.
//     *
//     * @param _item
//     * @param _qty
//     * @param _pickedWH
//     * @return
//     * @throws SQLException
//     */
//    public static RemovedStock[] removeOnHandStockUsingFifoRule (Item _item, double _qty, Gudang _pickedWH) throws SQLException
//    {
//        RemovedStock[] retval;
//        PreparedStatement ps;
//        StringBuilder sql = new StringBuilder ();
//        System.out.println ("Item: " + _item.getID ());
//        System.out.println ("Qty: " + _qty);
//        System.out.println ("Gudang: " + _pickedWH.getIdGudang ());
//
//        sql.append ("SELECT id_product, id_gudang, qty, expiry_date, serialno_s100, batch_no, source_ref_type, source_ref_id ");
//        sql.append ("FROM RemoveOnHandStockUsingFifoRule(?, ?, ?)");
//
//        try {
//            ps = MainAppRuntime.getDBConnection ().getConnection ().prepareStatement (sql.toString (), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ps.setInt (1, _item.getID ());
//            ps.setDouble (2, _qty);
//            ps.setInt (3, _pickedWH.getIdGudang ());
//
//            ResultSet rs = ps.executeQuery ();
//            if (! rs.next ())
//                return null;
//
//            rs.last ();
//            retval = new RemovedStock [rs.getRow ()];
//
//            rs.beforeFirst ();
//            int idx = 0;
//            while (rs.next ()) {
//                retval[idx] = new RemovedStock ();
//                retval[idx].item = new Item (rs.getInt (1));
//                retval[idx].gudang = new Gudang ();
//                retval[idx].gudang.setIdGudang (rs.getInt (2));
//                retval[idx].qty = rs.getDouble (3);
//
//                java.sql.Date sqldate = rs.getDate (4);
//                if (sqldate != null) {
//                    retval[idx].expDate = Calendar.getInstance ();
//                    retval[idx].expDate.setTime (sqldate);
//                }
//                else
//                    retval[idx].expDate = null;
//
//                retval[idx].serialNo = rs.getString (5);
//                retval[idx].batchNo = rs.getString (6);
//                retval[idx].sourceType = rs.getInt (7);
//                retval[idx].sourceId = rs.getInt (8);
//
//                ++idx;
//            }
//
//            return retval;
//        }
//        catch (SQLException e) {
//            try {
//                MainAppRuntime.getDBConnection ().getConnection ().rollback ();
//            }
//            catch (Exception t) {}
//            throw e;
//        }
//    }
//    
//    
//
//    /**
//     * <pre>
//     * Mengurangi stok on-hand berdasarkan aturan Expire Date. Stok yg dikurangi
//     * akan dikembalikan informasinya ke pemanggil fungsi ini, dlm bentuk array
//     * OnHandStock.
//     *
//     * Contoh implementasi di Orbita, prosedur ini mengurangi stok dengan prioritas:
//     * 1. stok yang expiry date-nya paling dekat dgn tanggal sekarang
//     * 2. stok yang expiry date-nya tidak ada
//     * Jika permintaan stok tidak bisa dipenuhi, maka null dikembalikan.
//     *
//     * Ilustrasi:
//     * Stok XYZ hendak diambil (dikurangi) sebanyak 30 buah dari gudang A.
//     * Kondisi aktual stok XYZ di gudang A adl sbb (diurutkan bdasarkan exp.date DESCENDING):
//     *  15 buah dengan exp.date 2008-09-01
//     *   6 buah dengan exp.date 2008-09-10
//     *  20 buah dengan exp.date 2008-10-17
//     *   5 buah dengan exp.date NULL
//     *
//     * Maka proses yg terjadi adl:
//     *  stok 15 buah dgn exp.date 2008-09-01 diambil semua.
//     *  stok 6 buah dgn exp.date 2008-09-10 diambil semua.
//     *  stok 20 buah dgn exp.date 2008-10-17 diambil 9 buah.
//     *  Semua stok yg diambil di atas akan dikembalikan ke pemanggil fungsi dlm bentuk
//     *  array OnHandStock sebanyak 3 elemen.
//     *
//     * Sehingga di akhir proses, posisi ketersediaan stok XYZ di gudang A menjadi:
//     *  11 buah dengan exp.date 2008-10-17.
//     *   5 buah dengan exp.date NULL
//     * </pre>
//     *
//     * @param _item
//     * @param _qty
//     * @param _pickedWH
//     * @return array of OnHandStock objects which represent removed stocks.
//     * @throws Exception
//     */
//    public static RemovedStock[] removeOnHandStockUsingExpDateRule (Item _item, double _qty, Gudang _pickedWH) throws SQLException
//    {
//        RemovedStock[] retval = null;
//        PreparedStatement ps = null;
//        StringBuilder sql = new StringBuilder ();
//
//        sql.append ("SELECT id_product, id_gudang, qty, expiry_date, serialno_s100, batch_no, source_ref_type, source_ref_id ");
//        sql.append ("FROM RemoveOnHandStockUsingExpDateRule (?, ?, ?)");
//
//        try {
//            ps = MainAppRuntime.getDBConnection ().getConnection ().prepareStatement (sql.toString (), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ps.setInt (1, _item.getID ());
//            ps.setDouble (2, _qty);
//            ps.setInt (3, _pickedWH.getIdGudang ());
//
//            ResultSet rs = ps.executeQuery ();
//            if (! rs.next ())
//                return null;
//
//            rs.last ();
//            retval = new RemovedStock[rs.getRow ()];
//
//            rs.beforeFirst ();
//            int idx = 0;
//            while (rs.next ()) {
//                retval[idx] = new RemovedStock ();
//                retval[idx].item = new Item (rs.getInt (1));
//                retval[idx].gudang = new Gudang ();
//                retval[idx].gudang.setIdGudang (rs.getInt (2));
//                retval[idx].qty = rs.getDouble (3);
//
//                java.sql.Date sqldate = rs.getDate (4);
//                if (sqldate != null) {
//                    retval[idx].expDate = Calendar.getInstance ();
//                    retval[idx].expDate.setTime (sqldate);
//                }
//                else
//                    retval[idx].expDate = null;
//
//                retval[idx].serialNo = rs.getString (5);
//                retval[idx].batchNo = rs.getString (6);
//                retval[idx].sourceType = rs.getInt (7);
//                retval[idx].sourceId = rs.getInt (8);
//
//                idx++;
//            }
//
//            return retval;
//        }
//        catch (SQLException e) {
//            try {
//                MainAppRuntime.getDBConnection ().getConnection ().rollback ();
//            }
//            catch (Exception t) {}
//            throw e;
//        }
//    }
//    
//    /**
//     * Mengurangi stok on-hand sekaligus 'mencatat' BuktiBarangKeluar untuk stok
//     * yang dikurangi tersebut.
//     * 
//     * @param _item Item/Barang yang akan dikurangi stoknya.
//     * @param _qty banyaknya stok
//     * @param _pickedWH gudang pengambilan stok
//     * @param _pickedDate tanggal pengambilan
//     * @param _removalRule bernilai salah satu dari enum {@link EnumRemovalRule#EXP_DATE} 
//     *      atau {@link EnumRemovalRule#FIFO}
//     * @param _refType reference type yg akan digunakan oleh BuktiBarangKeluar
//     * @param _refId reference ID yg akan digunakan oleh BuktiBarangKeluar
//     * @param _memo memo utk BuktiBarangKeluar. Jika null maka string memo akan diisikan
//     *          nilai default yg disiapkan oleh method ini.
//     * @return List RemovedStock atau null jika pengurangan tidak berhasil.
//     * @throws SQLException 
//     * @since 1.5
//     */
//    public static List<RemovedStock> removeStockAndCreateLog (Item _item, double _qty, Gudang _pickedWH, 
//                                        Calendar _pickedDate, EnumRemovalRule _removalRule, 
//                                        int _refType, int _refId, String _memo) throws SQLException
//    {
//        LinkedList<RemovedStock> result = new LinkedList ();
//        RemovedStock[] arrRS = null;
//        
//        if (_removalRule == EnumRemovalRule.FIFO) {
//            arrRS = removeOnHandStockUsingFifoRule (_item, _qty, _pickedWH);
//            if (arrRS != null)
//                for (RemovedStock rs : arrRS)
//                    result.add (rs);
//        }
//        else if (_removalRule == EnumRemovalRule.EXP_DATE) {
//            arrRS = removeOnHandStockUsingExpDateRule (_item, _qty, _pickedWH);
//            if (arrRS != null)
//                for (RemovedStock rs : arrRS)
//                    result.add (rs);
//        }
//        
//        if (result.size () == 0)
//            return null;
//        
//        // Ciptakan Bukti Barang Keluar
//        BuktiBarangKeluar bbk = new BuktiBarangKeluar ();
//        bbk.setBusinessObjCreator ((UserCredential) MainAppRuntime.getCurrentActiveUser ());
//        bbk.setGudang (_pickedWH);
//        bbk.setReference (_refType, _refId);
//        bbk.setTglKeluar (_pickedDate);
//        if (_memo != null)
//            bbk.setMemo (_memo);
//        else
//            bbk.setMemo ("Auto generated for removeStockAndCreateLog() function");
//        
//        ItemBBK[] arrItemBBK = new ItemBBK [arrRS.length];
//        for (int i = 0; i < arrItemBBK.length; i++) {
//            arrItemBBK[i] = new ItemBBK ();
//            arrItemBBK[i].setBatchNo (arrRS[i].batchNo);
//            arrItemBBK[i].setExpiryDate (arrRS[i].expDate);
//            arrItemBBK[i].setItem (_item);
//            arrItemBBK[i].setQty (arrRS[i].qty);
//            arrItemBBK[i].setSerialNo (arrRS[i].serialNo);
//            arrItemBBK[i].setSourceRefId (arrRS[i].sourceId);
//            arrItemBBK[i].setSourceRefType (arrRS[i].sourceType);            
//        }
//        bbk.setItemBBK (arrItemBBK);
//        
//        bbk.saveAsNewToDB ();
//        
//        return result;
//    }
//    
//    /**
//     * Penyangga informasi item dan quantity-nya.
//     */
//    public static class ItemAndQtyPlaceHolder 
//    {
//        public Item item;
//        public double qtyInInvMetric;
//        
//        public ItemAndQtyPlaceHolder (Item _i, double _qty)
//        {
//            item = _i;
//            qtyInInvMetric = _qty;
//        }
//    }
//    
//    /**
//     * 
//     * @param _listItemInfo
//     * @param _pickedWH
//     * @param _pickedDate
//     * @param _removalRule
//     * @param _refType
//     * @param _refId
//     * @param _memo
//     * @return
//     * @throws SQLException 
//     */
//    public static List<RemovedStock> removeStockAndCreateLog (List<ItemAndQtyPlaceHolder> _listItemInfo, Gudang _pickedWH, 
//                                        Calendar _pickedDate, EnumRemovalRule _removalRule, 
//                                        int _refType, int _refId, String _memo) throws SQLException
//    {
//        LinkedList<RemovedStock> result = new LinkedList<> ();
//        RemovedStock[] tempRS;
//        
//        if (_removalRule == EnumRemovalRule.FIFO) {
//            for (ItemAndQtyPlaceHolder itemInfo : _listItemInfo) {
//                tempRS = removeOnHandStockUsingFifoRule (itemInfo.item, itemInfo.qtyInInvMetric, _pickedWH);
//                if (tempRS != null)
//                    for (RemovedStock rs : tempRS)
//                        result.add (rs);
//            }
//        }
//        else if (_removalRule == EnumRemovalRule.EXP_DATE) {
//            for (ItemAndQtyPlaceHolder itemInfo : _listItemInfo) {
//                tempRS = removeOnHandStockUsingExpDateRule (itemInfo.item, itemInfo.qtyInInvMetric, _pickedWH);
//                if (tempRS != null)
//                    for (RemovedStock rs : tempRS)
//                        result.add (rs);
//            }
//        }
//        
//        if (result.size () == 0)
//            return null;
//        
//        // Ciptakan Bukti Barang Keluar
//        BuktiBarangKeluar bbk = new BuktiBarangKeluar ();
//        bbk.setBusinessObjCreator ((UserCredential) MainAppRuntime.getCurrentActiveUser ());
//        bbk.setGudang (_pickedWH);
//        bbk.setReference (_refType, _refId);
//        bbk.setTglKeluar (_pickedDate);
//        if (_memo != null)
//            bbk.setMemo (_memo);
//        else
//            bbk.setMemo ("Auto generated for removeStockAndCreateLog() function");
//        
//        ItemBBK[] arrItemBBK = new ItemBBK [result.size ()];
//        for (int i = 0; i < arrItemBBK.length; i++) {
//            RemovedStock rs = result.get (i);
//            
//            arrItemBBK[i] = new ItemBBK ();
//            arrItemBBK[i].setBatchNo (rs.batchNo);
//            arrItemBBK[i].setExpiryDate (rs.expDate);
//            arrItemBBK[i].setItem (rs.item);
//            arrItemBBK[i].setQty (rs.qty);
//            arrItemBBK[i].setSerialNo (rs.serialNo);
//            arrItemBBK[i].setSourceRefId (rs.sourceId);
//            arrItemBBK[i].setSourceRefType (rs.sourceType);            
//        }
//        bbk.setItemBBK (arrItemBBK);
//        
//        bbk.saveAsNewToDB ();
//        
//        return result;
//    }
//}
