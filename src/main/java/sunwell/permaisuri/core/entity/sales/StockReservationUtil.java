///*
// * StockReservationUtil.java
// *
// * Created on October 17, 2008, 02:54 AM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import sunwell.xrp.warehouse.StockMgmtWrapper.RemovedStock;
//import sunwell.xrp.util.MainAppRuntime;
//import sunwell.xrp.sales.salesorder.SalesOrder;
//import sunwell.xrp.sales.shipment.DeliveryOrder;
//import sunwell.xrp.warehouse.*;
//import sunwell.xrp.inventory.Item;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//
///**
// * Stock-Reservation Use Case Controller
// *
// * @version 1.0 - October 17, 2008 ; initial version
// * @version 2.0 - February 22, 2011 ; rename class dari StockMgmtUCController ke
// *      StockReservationUtil, penyediaan fungsi2 utama untuk pengelolaan stok yg diakibatkan
// *      oleh aktivitas penjualan.
// * @version 2.2 - Jan 14, 2015 ; perubahan method signature deleteReservedStock.
// * @version 2.3 - Jul 29, 2015 ; method createStockReservation akan melempar exception jika
// *		pengurangan stok on-hand mengembalikan null (alias tidak berhasil).
// * @version 2.5 - Jul 31, 2015 ; diperbolehkan menghapus stok-teralokasi. Berarti method 
// *              checkRuleForReservedStockDeletion() selalu return true.
// * 
// * @author Irfin
// * @author Benny
// */
//public class StockReservationUtil
//{
//    private StockReservationUtil ()
//    {
//    }
//    
//    /**
//     * 
//     * @param _sr
//     * @throws java.sql.SQLException
//     */
//    public static void createStockReservation (StockReservation _sr) throws SQLException
//    {
//        try {
//            // Save record StockReservation
//            _sr.insertToDB ();
//            
//            ItemStockReservation[] arrISR = _sr.getReservedItems ();
//            Gudang rsrvdWH = _sr.getWarehouse ();
//
//            ArrayList<StockMgmtWrapper.RemovedStock> arrRemovedStock = new ArrayList<StockMgmtWrapper.RemovedStock> ();
//            StockMgmtWrapper.RemovedStock[] removedStock = null;
//
//            // Pindahkan stok on-hand ke stok reservasi
//            for (int i = 0; i < arrISR.length; i++) {
//                removedStock = StockMgmtWrapper.removeOnHandStockUsingFifoRule (arrISR[i].getItem (), arrISR[i].getQty (), rsrvdWH);
//                if (removedStock == null) {
//                    throw new SQLException ("Stok on-hand tidak mencukupi untuk barang: " + arrISR[i].getItem ().getName ());
//                }
//
//                arrRemovedStock.addAll (Arrays.asList (removedStock));
//                
//                for (RemovedStock removedStock1 : removedStock) {
//                    
//                
//                    System.out.println("ID" + _sr.getID () + 
//                                       " name: " + removedStock1.getItem().getID() +
//                                       " qty: " + removedStock1.getQty());
//                }
//            }
//
//            for (int k = 0; k < arrRemovedStock.size (); k ++) {
//                RemovedStock rsufr = arrRemovedStock.get (k);
//                ReservedStock.addStock (_sr.getID (), rsufr.getItem (), rsufr.getQty (), rsrvdWH, 
//                                        rsufr.getSourceRefType (), rsufr.getSourceRefId (), rsufr.getExpiryDate (), 
//                                        rsufr.getSerialNo (), rsufr.getBatchNo ());
//            }
//            
//           /* for (int k = 0; k < arrISR.length; k ++) {
//                ItemStockReservation isr = arrISR[k] ;
//                ReservedStock.addStock (_sr.getID (), isr.getItem (), isr.getQty (), rsrvdWH, isr.getSourceRefType (), rsufr.getSourceRefId ());
//            }*/
//        }
//        catch (SQLException w) {
//            w.printStackTrace();
//            try {
//                MainAppRuntime.getDBConnection ().getConnection ().rollback ();
//            }
//            catch (SQLException q) { }
//            throw w;
//        }
//    }
//    
//    /**
//     * Menghitung (kalkulasi) jumlah stok suatu item/barang yang telah di-reservasi 
//     * dan reservasi barang tsb bersifat valid (pada saat penghitungan dilakukan).
//     * <BR><BR>
//     * Pengertian reservasi-valid dalam konteks ini adalah suatu barang yang 
//     * direservasi dan barang tsb ada secara fisik (di ReservedStock) ATAU 
//     * barang tsb tidak ada secara fisik tetapi telah diterima pelanggan 
//     * (telah dikonfimasi surat jalannya).
//     * <BR><BR>
//     * Sedangkan pengertian reservasi non-valid adalah suatu barang yg direservasi 
//     * (secara fisik ada di ReservedStock), tetapi kemudian barang tsb dibatalkan
//     * reservasinya (secara fisik dipindahkan kembali ke StokAktual ; dihapus 
//     * record-nya dari ReservedStock).
//     * <BR><BR>
//     * Penggolongan istilah reservasi-valid dan reservasi non-valid dilakukan
//     * karena catatan (record) kegiatan reservasi (StockReservation) suatu barang
//     * harus tetap ada/eksis meskipun reservasinya dibatalkan.
//     * 
//     * @param _idSalesOrder
//     * @param _idProd
//     * @return
//     * @throws java.sql.SQLException
//     */
//    public static double calculatePrevReservation (int _idSalesOrder, int _idProd) throws SQLException
//    {
//        Statement stmt = null;
//        ResultSet rs = null;
//        String sql = null;
//        
//        sql = "SELECT CalculatePreviousReservation(" + _idSalesOrder + ", " + _idProd + ")";
//        try {
//            stmt = MainAppRuntime.getDBConnection ().getConnection ().createStatement (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery (sql);
//            if (! rs.next ())
//                return 0;
//            
//            return rs.getDouble (1);
//        }
//        catch (SQLException z) {
//            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
//            throw z;
//        }
//        finally {
//            if (stmt != null)
//                try { stmt.close (); } catch (SQLException v) { }
//        }
//    }
//    
//    /**
//     * Menghapus record ReservedStock dan mengembalikannya ke StokAktual.
//     * 
//     * @param _idRsrv ID StockReservation
//     * @param _idGudang
//     * @param _idProd ID Product/Item yg hendak dihapus
//     * @param _qty Jumlah/quantity yg hendak dihapus
//     * @return succeeded quantity removed from DB
//     * @throws java.sql.SQLException
//     */
//    public static double deleteReservedStock (ReservedStock _reservedStock, double _qty) throws SQLException
//    {
//        //throw new UnsupportedOperationException ("Under Construction");
//        int idSr = _reservedStock.getStockReservationID () ;
//        int sourceType = _reservedStock.getSourceRefType () ;
//        int sourceID = _reservedStock.getSourceRefId () ;
//        Gudang gudang = _reservedStock.getWarehouse () ;
//        String serialNo = _reservedStock.getSerialNo () ;
//        String batchNo = _reservedStock.getBatchNo () ;
//        Item product = _reservedStock.getItem () ;
//        Calendar expDate = _reservedStock.getExpiryDate () ;
//        
//        
//        double qtyRemoved = ReservedStock.removeStock (idSr, product, _qty, gudang, sourceType, sourceID, expDate, serialNo, batchNo ) ;
//        if (qtyRemoved == 0)
//            throw new SQLException ("Penghapusan stok gagal dilakukan");
//
//        OnHandStock.addStock (product, _qty,  expDate, batchNo, serialNo, gudang, sourceType, sourceID ) ;   
//        
//        /*UserRemovedReservedStockLog urrsl = new UserRemovedReservedStockLog ();
//        urrsl.setIdStockReservation(idSr);
//        urrsl.setItem(product);
//        urrsl.setQty(_qty);
//        urrsl.setBusinessObjCreator ( (UserCredential) MainAppRuntime.getCurrentActiveUser ());
//        urrsl.insertToDB ();*/
//        
//        return qtyRemoved ;
//
////            return qtyRemoved;
////          Statement stmt = null;
////          ResultSet rs = null;
////          String sql = null;
////          Gudang rsrvdWH = null;
////          Item item = null;
////            int idGudang = 0 ;
////        
////          sql += "SELECT FROM stockreservation WHERE id_stockrsrv = " + _idRsrv ;
////          if( rs.next() != null )
////              idGudang = rs.getInt(1) ;
////
////        rsrvdWH = new Gudang ();
////        rsrvdWH.setIdGudang (idGudang);
////
////        item = new Item ();
////        item.setID (_idProd);
////
////        try {
////            // cari sourceRefType dan sourceRefId tiap stok yg hendak di-remove
////
////            // Kurangi (remove) stok dari ReservedStock.
////            double qtyRemoved = ReservedStock.removeStock (_idRsrv, item, _qty, rsrvdWH);
////
////            // Tambahkan (add) stok ke StokAktual
////            OnHandStock.addStock (item, qtyRemoved, null, rsrvdWH, IOnHandStockSourceRefConstants.REF_UNKNOWN, -1);
////
////            // Catat kegiatan ini ke table log
////            UserRemovedReservedStockLog urrsl = new UserRemovedReservedStockLog ();
////            urrsl.setIdStockReservation(_idRsrv);
////            urrsl.setItem(item);
////            urrsl.setQty(qtyRemoved);
////            urrsl.setBusinessObjCreator (employmentRuntime.getCurrentEmployment ());
////            urrsl.insertToDB ();
////
////            return qtyRemoved;
////        }
////        catch (SQLException w) {
////            MainAppRuntime.getDBConnection ().getConnection ().rollback ();
////            throw w;
////        }
//    }
//    
//    /**
//     * 
//     * @param _so
//     * @param _failReason
//     * @return
//     * @throws java.sql.SQLException
//     */
//    public static boolean checkRuleForStockReservationCreation (SalesOrder _so, StringBuilder _failReason) throws SQLException
//    {
//        // Periksa apakah SO telah direservasi semua itemnya.
//        Statement stmt = null;
//        String sql = null;
//        ResultSet rs = null;
//        
//        sql = "SELECT GetReservationStatusForSO(" + _so.getID () + ")";
//        try {
//            stmt = MainAppRuntime.getDBConnection ().getConnection ().createStatement (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            rs = stmt.executeQuery (sql);
//            if (! rs.next ())
//                return true;
//            
//            int status = rs.getInt (1);
//            
//            if (status == 1) {        // fully reserved
//                _failReason.append ("All item from this sales order has been fully reserved.");
//                return false;
//            }
//            else
//                return true;
//        }
//        catch (SQLException w) {
//            w.printStackTrace ();
//            MainAppRuntime.getDBConnection().getConnection().rollback();
//            throw w;
//        }
//        finally {
//            if (stmt != null)
//                try { stmt.close (); } catch (SQLException z) { }
//        }
//    }
//    
//    /**
//     * Selalu return true.
//     * 
//     * @param _idStockRsrv
//     * @param _idProd
//     * @param _failReason
//     * @return
//     * @throws java.sql.SQLException
//     */
//    public static boolean checkRuleForReservedStockDeletion (int _idStockRsrv, int _idProd, StringBuilder _failReason) throws SQLException
//    {
//        return true;
////        // Periksa apakah item yg hendak dihapus ini telah dibuat DO-nya.
////        try {
////            if (DeliveryOrder.isExistsForReservedItem (_idStockRsrv, _idProd)) {
////                _failReason.append ("A Delivery Order has been issued for this item. Delete Process is prohibited.");
////                return false;
////            }
////            else
////                return true;
////        }
////        catch (SQLException z) {
////            throw z;
////        }
//    }
//    
//    /**
//     * <H2>Returns false no matter what.</H2>
//     * 
//     * @param _idSR
//     * @param _failReason
//     * @return
//     * @throws java.sql.SQLException
//     */
//    public static boolean checkRuleForStockReservationModification (int _idSR, StringBuilder _failReason) throws SQLException
//    {
//        return false;
//    }
//}