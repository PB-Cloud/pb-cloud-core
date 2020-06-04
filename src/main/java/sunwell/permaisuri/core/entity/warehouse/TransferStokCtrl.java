///*
// * TransferStokCtrl.java
// *
// * Created on Aug 3, 2015, 7:21:46 PM
// */
//package sunwell.xrp.warehouse;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import sunwell.xrp.creds.UserCredential;
//import sunwell.xrp.util.MainAppRuntime;
//
///**
// *
// * @author irfin
// */
//public class TransferStokCtrl implements IStockTransferCtrl
//{
//    @Override
//    public void createStockTransfer (TransferStok _ts) throws SQLException
//    {
//        _ts.saveAsNewToDB();
//    }
//
//    @Override
//    public boolean checkRuleForTransferStokCreation (int _idSI, StringBuilder _failReason) throws SQLException
//    {
//        return true;
//    }
//    
//    /**
//     * 
//     * @param _ts terdefinisi lengkap termasuk tanggal approval dan UserCredential 
//     *      yg melakukan aproval.
//     * @return
//     * @throws SQLException 
//     */
//    public boolean createStockTransferApproval (TransferStok _ts) throws SQLException 
//    {        
//        /**
//         * Algoritma:
//         * 1. Kurangi stok on-hand gudang asal utk tiap barang yg ditransfer
//         * 2. Ciptakan BuktiBarangKeluar utk stok barang yg dikurangi di #1
//         * 3. Ciptakan BuktiBarangMasuk utk stok barang yg akan ditambahkan ke gudang tujuan
//         * 4. Tambahkan ke stok on-hand gudang tujuan utk tiap ItemBBK hasil #3
//         */
//        Gudang gudangOrigin = _ts.getGudangOrigin ();
//        Gudang gudangDest = _ts.getGudangDest ();
//        LinkedList<ItemBBK> arrIBBK = new LinkedList<>(); // [transferStok.getItemTransferCount ()];
//        ItemTransferStok its;
//
//        // #1. Kurangi stok dari gudang asalnya.
//        // PERHATIKAN: perulangan (looping) dilakukan sebanyak jenis item yg ditransfer.
//        for (int i = 0; i < _ts.getItemTransferCount(); i++) {
//            its = _ts.getItemAt(i);
//            StockMgmtWrapper.RemovedStock[] pickedStock = StockMgmtWrapper.removeOnHandStockUsingFifoRule (its.getItem(), its.getQty(), gudangOrigin);
//            if (pickedStock == null) {
//                throw new SQLException ("Pengurangan stok on-hand gagal dilakukan. Periksa ketersediaan stok untuk barang: " + its.getItem ().getName ()); 
//            }
//
//            for (StockMgmtWrapper.RemovedStock pickedStock1 : pickedStock) {
//                System.out.println("QTY: " + pickedStock1.getQty());
//            }
//           
//            for (int n = 0; n < pickedStock.length; n++) {
//                ItemBBK ibbk = new ItemBBK ();
//                ibbk.setItem (its.getItem ());
//                ibbk.setQty (pickedStock[n].getQty ());
//                ibbk.setExpiryDate (pickedStock[n].getExpiryDate ());
//                ibbk.setSourceRefType (pickedStock[n].getSourceRefType ());
//                ibbk.setSourceRefId (pickedStock[n].getSourceRefId ());
//                ibbk.setBatchNo (pickedStock[n].getBatchNo ());
//                ibbk.setSerialNo (pickedStock[n].getSerialNo ());
//
//                arrIBBK.add(ibbk);
//            }
//        }
//        
//        // #2. Lakukan pencatatan BuktiBarangKeluar
//        BuktiBarangKeluar bbk = new BuktiBarangKeluar ();
//        bbk.setReference (BuktiBarangKeluar.REF_WAREHOUSE_TRANSFER, _ts.getID ());
//        bbk.setItemBBK (arrIBBK.toArray (new ItemBBK[]{}));
//        bbk.setTglKeluar (_ts.getTglTransfer ());
//        bbk.setGudang (_ts.getGudangOrigin ());
//        bbk.setMemo ("Transfer Stok ke gudang " + gudangDest.getName ());
//        bbk.setBusinessObjCreator ((UserCredential) MainAppRuntime.getCurrentActiveUser ());
//
//        bbk.saveAsNewToDB ();
//
//        // #3. Catat dahulu di BuktiBarangMasuk.
//        BuktiBarangMasuk bbm = new BuktiBarangMasuk ();
//        bbm.setReference (BuktiBarangMasuk.REF_WAREHOUSE_TRANSFER, _ts.getID ());
//        bbm.setTglMasuk (_ts.getTglTransfer ());
//        bbm.setGudang (_ts.getGudangDest ());
//        bbm.setMemo ("Transfer Stok dari gudang " + gudangOrigin.getName ());
//        bbm.setBusinessObjCreator ((UserCredential) MainAppRuntime.getCurrentActiveUser ());
//
//        ItemBBM[] arrIBBM = new ItemBBM[_ts.getItemTransferCount ()];
//        for (int i = 0; i < arrIBBM.length; i++) {
//            its = _ts.getItemAt (i);
//
//            arrIBBM[i] = new ItemBBM ();
//            arrIBBM[i].setItem (its.getItem ());
//            arrIBBM[i].setExpiryDate (its.getExpiryDate ());
//            arrIBBM[i].setQty (its.getQty ());
//        }
//        bbm.setItemBBM (arrIBBM);
//        bbm.saveAsNewToDB ();
//
//        // #4. Tambahkan ke stok on-hand gudang tujuan. Stok on-hand ditambahkan
//        //  mengacu pada ItemBBK, bukan ItemBBM, karena ItemBBK menyimpan lebih lengkap
//        //  informasi BatchNo dan SerialNo. Adapun total qty yg ditambahkan ke on-hand
//        //  akan sama antara ItemBBM dan ItemBBK.
//        for (Iterator<ItemBBK> it = arrIBBK.iterator (); it.hasNext ();) {
//            ItemBBK ibbk = it.next ();
//            
//            OnHandStock.addStock(ibbk.getItem(),
//                    ibbk.getQty(),
//                    ibbk.getExpiryDate (),
//                    ibbk.getBatchNo (),
//                    ibbk.getSerialNo (),
//                    gudangDest,
//                    IOnHandStockSourceRefConstants.REF_INCOMING_ITEM,
//                    bbm.getID());
//        }
//        return true;
//    }
//    
//}
