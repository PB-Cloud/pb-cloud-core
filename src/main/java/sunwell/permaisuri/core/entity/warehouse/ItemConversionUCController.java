///*
// * ItemConversionUCController.java
// *
// * Created on February 29, 2008, 6:23 PM
// */
//package sunwell.xrp.warehouse;
//
//import java.sql.*;
//import sunwell.xrp.warehouse.StockMgmtWrapper.RemovedStock;
//
///**
// * <H2>
// * IMPLEMENTASI KELAS INI BELUM FINAL SEMENJAK PERUBAHAN StokAktual KE OnHandStock
// * </H2>
// *
// * @author Irfin A
// */
//public class ItemConversionUCController
//{
//    private ItemConversionUCController ()
//    {
//    }
//    
//    
//    /**
//     * Proses:<BR>
//     * 1. Save record ItemConversion<BR>
//     * 2. Kurangi stok aktual utk item yang dikonversi
//     * 3. Save item yg dikonversi di BuktiBarangKeluar<BR>
//     * 4. Save item hasil konversi di BuktiBarangMasuk<BR>
//     * 5. Perbesar stok aktual utk item hasil konversi<BR>
//     * 
//     * @param _ic
//     * @throws java.sql.SQLException
//     */
//    public static void createItemConversion (ItemConversion _ic) throws SQLException
//    {
//        // #1.
//        _ic.saveAsNewToDB ();
//        int idConversion = _ic.getID ();
//
//        // #2
//        // OnHandStock.removeStockUsingExpDateRule (_ic.getSourceItem (), _ic.getSourceQty (), _ic.getWarehouse ());
//        RemovedStock[] removedStock = StockMgmtWrapper.removeOnHandStockUsingFifoRule (_ic.getSourceItem (), _ic.getSourceQty (), _ic.getWarehouse ());
//        
//        // #3.
//        BuktiBarangKeluar bbk = new BuktiBarangKeluar ();
//        bbk.setReference (BuktiBarangKeluar.REF_ITEM_CONVERSION, idConversion);
//        bbk.setGudang (_ic.getWarehouse ());
//        bbk.setTglKeluar (_ic.getConversionDatetime ());
//        bbk.setBusinessObjCreator (_ic.getBusinessObjCreator ());
//
//        ItemBBK[] itembbk = new ItemBBK [removedStock.length];
//        for (int i = 0; i < itembbk.length; i++) {
//            itembbk[i] = new ItemBBK ();
//            itembbk[i].setItem (_ic.getSourceItem ());
//            itembbk[i].setQty (removedStock[i].getQty ());
//            itembbk[i].setExpiryDate (removedStock[i].getExpiryDate ());
//            itembbk[i].setSourceRefType (removedStock[i].getSourceRefType ());
//            itembbk[i].setSourceRefId (removedStock[i].getSourceRefType ());
//        }
//        bbk.setItemBBK (itembbk);
//
//        bbk.saveAsNewToDB ();
//        
//        // #4.
//        BuktiBarangMasuk bbm = new BuktiBarangMasuk ();
//        bbm.setReference (BuktiBarangMasuk.REF_ITEM_CONVERSION, idConversion);
//        bbm.setGudang (_ic.getWarehouse ());
//        bbm.setTglMasuk (_ic.getConversionDatetime ());
//        bbm.setBusinessObjCreator (_ic.getBusinessObjCreator ());
//        
//        ItemBBM[] itembbm = new ItemBBM [1];
//        itembbm[0] = new ItemBBM ();
//        itembbm[0].setItem (_ic.getDestItem ());
//        itembbm[0].setQty (_ic.getDestQty ());
//        bbm.setItemBBM (itembbm);
//        
//        bbm.saveAsNewToDB ();
//        
//        // #5.
////        StokAktual.getInstance ().addStock (_ic.getDestItem (), "", _ic.getDestQty (), _ic.getWarehouse ());
//        OnHandStock.addStock (_ic.getDestItem (), _ic.getDestQty (), null, "", "",
//                              _ic.getWarehouse (), IOnHandStockSourceRefConstants.REF_INCOMING_ITEM, bbm.getID ());
//    }
//
//}
