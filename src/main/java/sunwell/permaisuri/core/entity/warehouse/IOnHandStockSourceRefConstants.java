/*
 * IOnHandStockSourceRefConstants.java
 *
 * Created on September 19, 2008, 11:24 PM
 */
package sunwell.permaisuri.core.entity.warehouse;

/**
 * Interface yg berisi deklarasi konstanta tipe sumber referensi stok barang di
 * gudang.
 * 
 * @author Irfin A
 * @version 1.0 - Sep 19, 2008 ; initial version
 * @version 1.5 - Mar 1, 2011 ; field dipangkas menjadi hanya 3 yaitu UNKNOWN,
 *                  BEG_BALANCE, dan INCOMING_ITEM (brg masuk)
 */
public interface IOnHandStockSourceRefConstants
{
    /** Reference of Unknown */
    public static final int REF_UNKNOWN = -1;
    /** Reference of Beginning Balance */
    public static final int REF_BEG_BALANCE = 0;
    /** Reference Barang Masuk */
    public static final int REF_INCOMING_ITEM = 1;

//    /** Reference of Purchase Order */
//    public static final int REF_PURCHASE_ORDER = 1;
//    /** Reference of Stock Adjustment */
//    public static final int REF_STOCK_ADJUSTMENT = 2;
//    /** Reference of Item Conversion */
//    public static final int REF_ITEM_CONVERSION = 3;
//    /** Reference of Stock Transfer */
//    public static final int REF_STOCK_TRANSFER = 4;
//    /** Reference of Sales Return */
//    public static final int REF_SALES_RETURN = 5;
}
