///*
// * @File : ItemBBK.java	@Date : Des 12, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//import java.sql.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//
///**
// * Atribut m_expiry_date dalam table database disimpan dalam tipe varchar(10)
// * bukan date, sebab atribut ini menjadi bagian dari primary key sehingga 
// * tidak boleh null, meskipun secara programming nilainya adalah null. 
// * Untuk itu, jika tgl expire di progr adalah null, maka di database 
// * disimpan sebagai string kosong.
// * 
// * @author Irfin A
// *
// * @version 1.0 - Dec 12, 2007 ; initial version
// * @version 1.5 - Sep 2, 2010 ; tambahan atribut m_expiry_date.
// * @version 1.6 - Mar 2, 2011 ; tambahan atribut m_source_ref_type dan m_source_ref_id.
// * @version 1.7 - Dec 19, 2014 ; tambahan atribut m_batchNo.
// * @version 1.8 - Dec 29, 2015 ; tambahan method toString().
// */
//@Entity
//@Table( name = "itembbk" )
//@IdClass( ItemBBKPK.class )
//public class ItemBBK 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "no_bukti" )
//    private BuktiBarangKeluar m_bbk;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item m_item;
//    
//    /** Quantity menurut satuan/metrik inventory */
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Column( name = "serialno_s100" )
//    private String m_serialno_s100;
//    
//    @Column( name = "batch_no" )
//    private String m_batchNo;
//    
//    @Column( name = "str_expiry_date" )
//    private String m_str_exp_date ;
//    
//    @Transient
//    private Calendar m_expiry_date;
//    
//    @Column( name = "source_ref_type" )
//    private int m_source_ref_type;
//    
//    @Column( name = "source_ref_id" )
//    private int m_source_ref_id;
//    
//    /**
//     * @roseuid 46140A1A034B
//     */
//    public ItemBBK ()
//    {
//        m_serialno_s100 = "";
//        m_expiry_date = null;
//        m_source_ref_type = -1;
//        m_batchNo = "";
//    }
//    
//    public Calendar getExpiryDate () { return m_expiry_date; }
//    
//    public void setExpiryDate (Calendar _cal)
//    {
//        this.m_expiry_date = _cal;
//        m_str_exp_date = _cal.toString();
//    }
//
//    public int getSourceRefType () { return m_source_ref_type; }
//
//    public void setSourceRefType (int _reftype)
//    {
//        m_source_ref_type = _reftype;
//    }
//
//    public int getSourceRefId () { return m_source_ref_id; }
//
//    public void setSourceRefId (int _refid)
//    {
//        m_source_ref_id = _refid;
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
//    public void setBatchNo (String _s)
//    {
//        m_batchNo = _s;
//    }
//
//    public BuktiBarangKeluar getBuktiBarangKeluar () { return m_bbk; }
//
//    public void setBuktiBarangKeluar (BuktiBarangKeluar _bbk)
//    {
//        this.m_bbk = _bbk;
//    }
//
//    public Item getItem () { return m_item; }
//
//    public void setItem (Item _item)
//    {
//        this.m_item = _item;
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
//        str.append ("BatchNo: ").append (m_batchNo).append (" ");
//        str.append ("RefType: ").append (m_source_ref_type).append (" ");
//        str.append ("RefID: ").append (m_source_ref_id).append (" ");
//        
//        return str.toString ();
//    }
//}
