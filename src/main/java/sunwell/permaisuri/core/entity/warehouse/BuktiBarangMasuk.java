///*
// * @File : BuktiBarangMasuk.java	@Date : Des 24, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//import java.util.*;
//import java.sql.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//
///**
// * Sama dengan Bukti Penerimaan Barang (BPB). Pencatatan ke Bukti Barang Masuk
// *  dilakukan untuk barang yg masuk melalui PO (pembelian), barang yg masuk
// *  melalui transfer stok antar gudang, dan melalui retur penjualan.
// *
// * Implementasi ke database utk melakukan hal di atas, dilakukan dgn cara
// *  menyediakan foreign keys yg menunjuk ke PurchaseOrder, TransferStok, dan
// *  SalesReturn. Pada satu record hanya boleh salah satu dari ketiga foreign key
// *  ini yg nilainya tidak null (berarti yang dua lainnya harus null).
// *  Selain kedua foreign key tsb, bisa juga disediakan sebuah flag yg membantu
// *  menunjukkan apakah BPB ini mengacu ke PO, transfer stok, atau retur penjualan
// *  sehingga mempermudah proses seleksi.
// *
// * @version 2.0 - 16-Dec-2008 ; penambahan implementasi ITraceableBusinessObject
// *
// * @author Irfin A
// */
//@Entity
//@Table( name = "buktibarangmasuk" )
//public class BuktiBarangMasuk 
//{
//    public static final int REF_UNKNOWN = -1;
//    public static final int REF_PO = 0;
//    public static final int REF_WAREHOUSE_TRANSFER = 1;
//    public static final int REF_SALESRETURN = 2;
//    public static final int REF_STOCKADJUSTMENT = 3;
//    public static final int REF_ITEM_CONVERSION = 4;
//    public static final int REF_STOCK_REPLACEMENT = 5;
//    public static final int REF_SALES_VOID = 6;
//
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_bbm" )
//    @SequenceGenerator (name = "buktibarangmasuk_id_bbm_seq", sequenceName = "buktibarangmasuk_id_bbm_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "buktibarangmasuk_id_bbm_seq")
//    private int m_id_bbm;
//    
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang m_gudang;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )
//    private UserCredential m_businessObjCreator;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_updater" )
//    private UserCredential m_businessObjUpdater;
//    
//    @OneToMany( mappedBy = "m_bbm", cascade = CascadeType.ALL)
//    private List<ItemBBM> m_listBBM ;
//    
//    @Transient
//    private ItemBBM[] m_arrIBBM;
//    
//    @Column( name = "memo" )
//    private String m_memo;
//
//    /** menyimpan timestamp. */
//    @Column( name = "tgl_keluar" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_tgl_masuk;
//    
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP) 
//    private Calendar m_businessObj_createdate;
//    
//    @Column( name = "bo_updatedate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP) 
//    private Calendar m_businessObj_updatedate;
//
//    /** Nomor Delivery Order Slip */
//    @Column( name = "no_do_slip" )
//    private String m_no_do_slip;
//    
//    /** Harus menunjuk ke salah satu dari REF_PO dan REF_WAREHOUSE_TRANSFER */
//    @Column( name = "source_ref_type" )
//    private int m_source_ref_type;
//    
//    @Column( name = "source_ref_id" )
//    private int m_source_ref_id;
//    //private Object m_source_ref_object;
//
//    public BuktiBarangMasuk ()
//    {
//        m_source_ref_type = REF_UNKNOWN;
////        m_source_ref_object = null;
//
//        m_no_do_slip = "";
//        m_arrIBBM = null;
//        m_gudang = null;
//        m_memo = "";
//
//        m_businessObjCreator = null;
//        m_businessObjUpdater = null;
//        m_businessObj_createdate = null;
//        m_businessObj_updatedate = null;
//    }
//
//    public int getID () { return m_id_bbm; }
//
//    public void setID (int m_id_bbm)
//    {
//        this.m_id_bbm = m_id_bbm;
//    }
//
//    public Gudang getGudang () { return m_gudang; }
//
//    public void setGudang (Gudang _g)
//    {
//        this.m_gudang = _g;
//    }
//
//    public ItemBBM[] getItemBBM () 
//    { 
//        if(m_arrIBBM == null)
//        {
//            if(m_listBBM != null)
//            {
//                m_arrIBBM = m_listBBM.toArray(new ItemBBM[]{});
//            }
//        }
//        
//        return m_arrIBBM; 
//    }
//
//    public void setItemBBM (ItemBBM[] _arrIBBM)
//    {
//        this.m_arrIBBM = _arrIBBM;
//
//        if (m_arrIBBM == null)
//            return;
//
//        for (int i = 0; i < m_arrIBBM.length; i++)
//            m_arrIBBM[i].setBuktiBarangMasuk (this);
//        
//        m_listBBM = Arrays.asList (m_arrIBBM) ;
//    }
//
//    public int getReferenceID () { return m_source_ref_id; }
//
//    public int getReferenceType () { return m_source_ref_type; }
//
//    /**
//     * @param _refType harus salah satu dari nilai {@link #REF_PO}, {@link #REF_WAREHOUSE_TRANSFER},
//     *  {@link #REF_SALESRETURN}, {@link #REF_STOCKADJUSTMENT}, atau {@link #REF_ITEM_CONVERSION}.
//     */
//    public void setReference (int _refType, int _refID)
//    {
//        // PENGECEKAN DI BAWAH DI-COMMENT OUT SBB ERROR-PRONE UTK PENAMBAHAN
//        //  JENIS REFERENSI DI KEMUDIAN HARI. SERINGKALI PENAMBAHAN/PERUBAHAN REFERENSI
//        //  DILAKUKAN TAPI LUPA MENG-UPDATE KODE DI BAWAH INI.
////        if (_refType != REF_PO && _refType != REF_SALESRETURN &&
////            _refType != REF_STOCKADJUSTMENT && _refType != REF_WAREHOUSE_TRANSFER)
////            _refType = REF_UNKNOWN;
//
//        this.m_source_ref_type  = _refType;
//        this.m_source_ref_id = _refID;
//    }
//
//    public Calendar getTglMasuk () { return m_tgl_masuk; }
//
//    public void setTglMasuk (Calendar m_tgl_masuk)
//    {
//        this.m_tgl_masuk = m_tgl_masuk;
//    }
//
//    public String getNoDOslip () { return m_no_do_slip; }
//
//    public void setNoDOslip (String m_no_do_slip)
//    {
//        this.m_no_do_slip = m_no_do_slip;
//    }
//
//    public String getMemo () { return m_memo; }
//
//    public void setMemo (String _memo)
//    {
//        this.m_memo = _memo;
//    }
//
//    public Calendar getBusinessObjCreateDate () { return m_businessObj_createdate; }
//
//    public void setBusinessObjCreateDate (Calendar m_user_createdate)
//    {
//        this.m_businessObj_createdate = m_user_createdate;
//    }
//
//    public Calendar getBusinessObjUpdateDate () { return m_businessObj_updatedate; }
//
//    public void setBusinessObjUpdateDate (Calendar m_user_modifydate)
//    {
//        this.m_businessObj_updatedate = m_user_modifydate;
//    }
//
//    public UserCredential getBusinessObjCreator ()
//    {
//        return m_businessObjCreator;
//    }
//
//    public void setBusinessObjCreator (UserCredential _emp)
//    {
//        this.m_businessObjCreator = _emp;
//    }
//
//    public UserCredential getBusinessObjUpdater ()
//    {
//        return m_businessObjUpdater;
//    }
//
//    public void setBusinessObjUpdater (UserCredential _emp)
//    {
//        this.m_businessObjUpdater = _emp;
//    }
//}
