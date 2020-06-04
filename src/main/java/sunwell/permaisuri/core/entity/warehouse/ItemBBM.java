///*
// * @File : ItemBBM.java	@Date : Des 12, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//import java.util.Calendar;
//import java.sql.*;
//import java.text.DateFormat;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.Transient;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.ItemShipmentInfo;
//
///**
// *
// * @author Irfin A
// * @author Benny
// * 
// * @version 1.0 - Dec 12, 2007 ; initial version.
// * @version 1.2 - Jun 29, 2016 ; tambahan method toString().
// */
//@Entity
//@Table(name="itembbm")
//@IdClass(ItemBBMPK.class)
//public class ItemBBM 
//{
//    @Id
//    @ManyToOne()
//    @JoinColumn(name="id_bbm")
//    private BuktiBarangMasuk m_bbm;
//    
//    @Id
//    @ManyToOne()
//    @JoinColumn(name="id_product")
//    private Item m_item;
//    
//    @Column(name = "batch_ni")
//    private String m_batchNo ;
//    
//    /** Quantity menurut satuan/metrik untuk inventory */
//    @Column(name="qty")
//    private double m_qty;
//    
//     @Column( name = "str_expiry_date" )
//    private String m_str_exp_date ;
//    
//    @Transient
//    private Calendar m_expiry_date;
//    
//    @Column(name="serialno_s100")
//    private String m_serialno_s100;
//    
//    @ManyToOne
//    @JoinColumn(name = "shipment_used")
//    private ItemShipmentInfo m_shipmentUsed;
//
//    public ItemBBM ()
//    {
//        m_serialno_s100 = "";
//        m_batchNo = "";
//        m_expiry_date = null;
//    }
//
//    public Calendar getExpiryDate () { return m_expiry_date; }
//
//    public void setExpiryDate (Calendar _expDate)
//    {
//        this.m_expiry_date = _expDate;
//        m_str_exp_date = _expDate.toString();
//    }
//
//    public double getQty () { return m_qty; }
//
//    public void setQty (double _qty)
//    {
//        this.m_qty = _qty;
//    }
//
//    public String getSerialNo () { return m_serialno_s100; }
//
//    public void setSerialNo (String _serialno_s100)
//    {
//        if (_serialno_s100 == null)
//            this.m_serialno_s100 = "";
//        else
//            this.m_serialno_s100 = _serialno_s100;
//    }
//    
//    public String getBatchNo () { return m_batchNo; }
//
//    public void setBatchNo (String _batchNo)
//    {
//        if (_batchNo == null)
//            this.m_batchNo = "";
//        else
//            this.m_batchNo = _batchNo;
//    }
//
//    public BuktiBarangMasuk getBuktiBarangMasuk () { return m_bbm; }
//
//    public void setBuktiBarangMasuk (BuktiBarangMasuk _bbm)
//    {
//        this.m_bbm = _bbm;
//    }
//
//    public Item getItem () { return m_item; }
//
//    public void setItem (Item _item)
//    {
//        this.m_item = _item;
//    }
//    
//    public ItemShipmentInfo getShipmentUsed () { return m_shipmentUsed; }
//
//    public void setShipmentUsed (ItemShipmentInfo _s)
//    {
//        m_shipmentUsed = _s;
//    }
//    
//    @Override
//    public String toString ()
//    {
//        DateFormat dateFormat = DateFormat.getDateInstance (DateFormat.MEDIUM);
//        StringBuilder str = new StringBuilder ();
//        
//        str.append ("ID Product: ").append (m_item.getSystemId ()).append (" ");
//        str.append ("Kode: ").append (m_item.getKode ()).append (" ");
//        str.append ("Qty: ").append (m_qty).append (" ");
//        str.append ("Expire: ");
//        if (m_expiry_date != null)
//            str.append (dateFormat.format (m_expiry_date.getTime ())).append (" ");
//        else
//            str.append ("NULL").append (" ");
//        str.append ("S/N: ").append (m_serialno_s100).append (" ");
//        str.append ("BatchNo: ").append (m_batchNo);
//        
//        return str.toString ();
//    }
//}
