///*
// * @File : BeginningInventoryBalance.java	@Date : Mar 19, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//
//import java.util.*;
//import java.sql.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//import sunwell.permaisuri.core.entity.inventory.Item;
//
///**
// * Tidak diperbolehkan utk menyimpan ke database, stok awal barang yg
// * expiry_date dan gudang-nya duplikat (sudah tersimpan sebelumnya di DB).
// * Jadi pada database, field id_product + id_gudang + expiry_date bersifat
// * UNIQUE.
// * <BR><BR>
// * Data expiry-date dari objek kelas ini boleh di-set ke null.
// *
// * @author Irfin A
// * @version 1.0     19-Mar-2007 ; initial version.
// * @version 2.0     26-Oct-2008 ; perubahan primary key menjadi auto-increment,
// *                      penambahan informasi expiry date, penambahan method
// *                      getLastInsertedID().
// * @version 2.3     25-Dec-2008 ; implementasi interface ITraceableBusinessObject
// * @version 2.4     14-Jan-2009 ; new method queryByID()
// * @version 2.5     28-Okt-2012 ; method queryByID() sekarang me-retrieve secara lengkap semua objek yg dibutuhkan
// */
//@Entity
//@Table( name = "beginninginventorybalance" )
//public class BeginningInventoryBalance 
//{
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_bib" )
//    @SequenceGenerator (name = "beginninginventorybalance_id_bib_seq", sequenceName = "beginninginventorybalance_id_bib_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "beginninginventorybalance_id_bib_seq")
//    private int m_id_bib;
//
//    @ManyToOne
//    @JoinColumn( name = "id_product")
//    private Item m_item;
//    
//    @ManyToOne
//    @JoinColumn( name = "id_gudang")
//    private Gudang m_gudang;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )
//    private UserCredential m_bo_creator;
//    
//    @Column( name = "expiry_date" )
//    @Temporal(javax.persistence.TemporalType.DATE)    
//    private Calendar m_expiry_date = null;
//    
//    @Column( name = "bib_date" )
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Calendar m_bib_date;
//    
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.DATE)    
//    private Calendar m_bo_createdate;
//    
//    /** Qty dalam satuan/metrik utk inventory */
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Column( name = "unit_price" )
//    private double m_unit_price;
//
//    //private UserLogin m_user_create;
//  
//    public BeginningInventoryBalance ()
//    {
//    }
//
//    public int getID () { return m_id_bib; }
//
//    public void setID (int _id)
//    {
//        this.m_id_bib = _id;
//    }
//
//    public Calendar getExpiryDate () { return m_expiry_date; }
//
//    public void setExpiryDate (Calendar _exp_date)
//    {
//        this.m_expiry_date = _exp_date;
//    }
//
//    public Gudang getGudang () { return m_gudang; }
//
//    public void setGudang (Gudang _gdg)
//    {
//        this.m_gudang = _gdg;
//    }
//
//    public Calendar getDate () { return m_bib_date; }
//
//    public void setDate (Calendar m_tgl_bib)
//    {
//        this.m_bib_date = m_tgl_bib;
//    }
//
//    public double getQty () { return m_qty; }
//
//    public void setQty (double _qty)
//    {
//        this.m_qty = _qty;
//    }
//
//    public double getUnitPrice () { return m_unit_price; }
//
//    public void setUnitPrice (double m_unit_price)
//    {
//        this.m_unit_price = m_unit_price;
//    }
//
//    public Item getItem () { return m_item; }
//
//    public void setItem (Item m_item)
//    {
//        this.m_item = m_item;
//    }
//
//    public UserCredential getBusinessObjCreator ()
//    {
//        return m_bo_creator;
//    }
//
//    public void setBusinessObjCreator (UserCredential _emp)
//    {
//        m_bo_creator = _emp;
//    }
//
//    public Calendar getBusinessObjCreateDate () { return m_bo_createdate; }
//
//    public void setBusinessObjCreateDate (Calendar _createDate)
//    {
//        this.m_bo_createdate = _createDate;
//    }
//
//    /**
//     * ALWAYS return null
//     * @return null (always)
//     */
//    public UserCredential getBusinessObjUpdater () { return null; }
//
//    /**
//     * ALWAYS return null
//     * @return null (always)
//     */
//    public Calendar getBusinessObjUpdateDate () { return null; }
//}
