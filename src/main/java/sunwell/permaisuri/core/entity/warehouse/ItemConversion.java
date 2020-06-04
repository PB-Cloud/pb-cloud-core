///*
// * ItemConversion.java
// *
// * Created on February 23, 2008, 7:37 PM
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//
//import java.sql.*;
//import java.util.*;
//import javax.persistence.EntityManager;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//import sunwell.permaisuri.core.entity.inventory.Item;
//
////TODO: Tambahkan informasi tgl expiry pada kelas ini.
////TODO: Tambahkan informasi source reference type dan ID ???
//
///**
// *
// * @author Irfin A
// */
//public class ItemConversion
//{
//    /** PRIMARY KEY ; auto-increment */
//    private int m_id_itemconv;
//    
//    private Item m_src_item;
//    private Item m_dest_item;
//    private Gudang m_warehouse;
//    private Calendar m_conversion_datetime;
//    
//    private double m_src_qty_inInvMetric;
//    private double m_dest_qty_inInvMetric;
//    private double m_unit_price;
//    private String m_reason;
//    private String m_memo;
//    
//    private UserCredential m_bo_creator;
//    private Calendar m_bo_createdate;
//    
//    public ItemConversion ()
//    {
//        m_src_item = null;
//        m_dest_item = null;
//        m_warehouse = null;
//        
//        m_reason = "";
//        m_memo = "";
//
//        m_bo_creator = null;
//        m_bo_createdate = null;
//    }
//    
//    public int getID () { return m_id_itemconv; }
//    
//    public void setID (int _idConv)
//    {
//        this.m_id_itemconv = _idConv;
//    }
//    
//    public Item getSourceItem ()
//    {
//        return m_src_item;
//    }
//
//    public void setSourceItem (Item m_src_item)
//    {
//        this.m_src_item = m_src_item;
//    }
//
//    public Item getDestItem ()
//    {
//        return m_dest_item;
//    }
//
//    public void setDestItem (Item m_dest_item)
//    {
//        this.m_dest_item = m_dest_item;
//    }
//
//    public Gudang getWarehouse ()
//    {
//        return m_warehouse;
//    }
//
//    public void setWarehouse (Gudang m_warehouse)
//    {
//        this.m_warehouse = m_warehouse;
//    }
//
//    public Calendar getConversionDatetime ()
//    {
//        return m_conversion_datetime;
//    }
//
//    public void setConversionDatetime (Calendar m_conversion_datetime)
//    {
//        this.m_conversion_datetime = m_conversion_datetime;
//    }
//
//    public double getSourceQty ()
//    {
//        return m_src_qty_inInvMetric;
//    }
//
//    public void setSourceQty (double m_src_qty_inInvMetric)
//    {
//        this.m_src_qty_inInvMetric = m_src_qty_inInvMetric;
//    }
//
//    public double getDestQty ()
//    {
//        return m_dest_qty_inInvMetric;
//    }
//
//    public void setDestQty (double m_dest_qty_inInvMetric)
//    {
//        this.m_dest_qty_inInvMetric = m_dest_qty_inInvMetric;
//    }
//
//    public double getUnitPrice ()
//    {
//        return m_unit_price;
//    }
//
//    public void setUnitPrice (double _unitPrice)
//    {
//        this.m_unit_price = _unitPrice;
//    }
//
//    public String getReason ()
//    {
//        return m_reason;
//    }
//
//    public void setReason (String _txt)
//    {
//        this.m_reason = (_txt != null) ? _txt : "";
//    }
//
//    public String getMemo ()
//    {
//        return m_memo;
//    }
//
//    public void setMemo (String _txt)
//    {
//        this.m_memo = (_txt != null) ? _txt : "";
//    }
//    
//    public UserCredential getBusinessObjCreator ()
//    {
//        return m_bo_creator;
//    }
//    
//    public void setBusinessObjCreator (UserCredential _emp)
//    {
//        this.m_bo_creator = _emp;
//    }
//
//    public Calendar getBusinessObjCreateDate () { return m_bo_createdate; }
//
//    public void setBusinessObjCreateDate (Calendar _createdate)
//    {
//        this.m_bo_createdate = _createdate;
//    }
//
//    /**
//     * Always return null.
//     * @return always NULL
//     */
//    public UserCredential getBusinessObjUpdater () { return null; }
//
//    /**
//     * Always return null.
//     *
//     * @return always NULL
//     */
//    public Calendar getBusinessObjUpdateDate () { return null; }
//
//}
