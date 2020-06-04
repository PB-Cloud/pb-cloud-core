///*
// * @File : BuktiBarangKeluar.java	@Date : Des 24, 2007, 12:07:04 AM
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
//
///**
// * Pencatatan ke Bukti Barang Keluar dilakukan untuk barang yg keluar melalui
// *  DO - Delivery Order (penjualan), atau keluar melalui transfer stok antar
// *  gudang, atau melalui retur pembelian.
// *
// * Implementasi ke database utk melakukan hal di atas, dilakukan dgn cara
// *  menyediakan foreign key yg menunjuk ke DeliveryOrder, foreign key yg menunjuk
// *  ke TransferStok, dan foreign key yg menunjuk ke PurchaseReturn. Pada suatu
// *  record hanya boleh satu dari ketiga foreign key ini yg nilainya tidak null
// *  (berarti yang duanya harus null). Selain kedua foreign key tsb, bisa juga
// *  disediakan sebuah flag yg membantu menunjukkan apakah BuktiBarangKeluar ini
// *  mengacu ke DO, transfer stok, atau retur, sehingga mempermudah proses seleksi.
// *
// * @version 2.0 - 17-Dec-2008 ; penambahan implementasi ITraceableBusinessObject
// *
// * @author Irfin A
// */
//@Entity
//@Table( name = "buktibarangkeluar" )
//public class BuktiBarangKeluar 
//{
//    public static final int REF_UNKNOWN = -1;
//    public static final int REF_DO = 0;
//    public static final int REF_WAREHOUSE_TRANSFER = 1;
//    public static final int REF_PURCHRETURN = 2;
//    public static final int REF_STOCKADJUSTMENT = 3;
//    public static final int REF_ITEM_CONVERSION = 4;
//    public static final int REF_STOCK_REPLACEMENT = 5;
//    public static final int REF_SALES = 6;
//
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "no_bukti" )
//    @SequenceGenerator (name = "buktibarangkeluar_no_bukti_seq", sequenceName = "buktibarangkeluar_no_bukti_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "buktibarangkeluar_no_bukti_seq")
//    private int m_no_bukti;
//    
//    @ManyToOne
//    @JoinColumn( name = "id_gudang")
//    private Gudang m_gudang;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )
//    private UserCredential m_boCreator;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_updater" )
//    private UserCredential m_boUpdater;
//    
//    @OneToMany( mappedBy = "m_bbk", cascade = CascadeType.ALL )
//    private List<ItemBBK> m_listIBBK ;
//    
//    @Transient
//    private ItemBBK[] m_arrIBBK;
//
//    /** menyimpan timestamp */
//    @Column( name = "tgl_keluar" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)    
//    private Calendar m_tgl_keluar;
//                                            
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)  
//    private Calendar m_bo_createdate;
//    
//    @Column( name = "bo_updatedate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)  
//    private Calendar m_bo_updatedate;
//    
//    @Column( name = "memo" )
//    private String m_memo;
//    
//    @Column( name = "source_ref_type" )
//    private int m_source_ref_type;
//    
//    @Column( name = "source_ref_id" )
//    private int m_source_ref_id;
//
//    
//    
//    /**
//     * Creates new instance of BuktiBarangKeluar
//     */
//    public BuktiBarangKeluar ()
//    {
//        m_source_ref_type = REF_UNKNOWN;
//
//        m_arrIBBK = null;
//        m_gudang = null;
//        m_memo = "";
//
//        m_boCreator = null;
//        m_boUpdater = null;
//        m_bo_createdate = null;
//        m_bo_updatedate = null;
//    }
//
//    public int getNoBukti () { return m_no_bukti; }
//
//    public void setNoBukti (int _noBukti)
//    {
//        this.m_no_bukti = _noBukti;
//    }
//
//    public Gudang getGudang () { return m_gudang; }
//
//    public void setGudang (Gudang m_gudang)
//    {
//        this.m_gudang = m_gudang;
//    }
//
//    public ItemBBK[] getItemBBK () 
//    { 
//        if(m_arrIBBK == null)
//        {
//            if(m_listIBBK != null)
//            {
//                m_arrIBBK = m_listIBBK.toArray(new ItemBBK[]{});
//            }
//        }
//        
//        return m_arrIBBK; 
//    }
//
//    public void setItemBBK (ItemBBK[] _arrIBBK)
//    {
//        this.m_arrIBBK = _arrIBBK;
//
//        if (m_arrIBBK == null)
//            return;
//
//        for (int i = 0; i < m_arrIBBK.length; i++)
//            m_arrIBBK[i].setBuktiBarangKeluar (this);
//        
//        m_listIBBK = Arrays.asList (m_arrIBBK) ;
//    }
//
//    public int getReferenceType () { return m_source_ref_type; }
//
//    public int getReferenceID () { return m_source_ref_id; }
//
//    /**
//     * @param _refType harus salah satu dari nilai {@link #REF_DO}, {@link #REF_WAREHOUSE_TRANSFER},
//     *  {@link #REF_PURCHRETURN}, {@link #REF_STOCKADJUSTMENT}, atau {@link #REF_ITEM_CONVERSION}.
//     */
//    public void setReference (int _refType, int _refID)
//    {
//        // PENGECEKAN DI BAWAH DI-COMMENT OUT SBB ERROR-PRONE UTK PENAMBAHAN
//        //  JENIS REFERENSI DI KEMUDIAN HARI. SERINGKALI PENAMBAHAN/PERUBAHAN REFERENSI
//        //  DILAKUKAN TAPI LUPA MENG-UPDATE KODE DI BAWAH INI.
////        if (_refType != REF_DO && _refType != REF_PURCHRETURN &&
////            _refType != REF_STOCKADJUSTMENT && _refType != REF_WAREHOUSE_TRANSFER)
////            _refType = REF_UNKNOWN;
//
//        this.m_source_ref_type  = _refType;
//        this.m_source_ref_id = _refID;
//    }
//
//    public Calendar getTglKeluar () { return m_tgl_keluar; }
//
//    public void setTglKeluar (Calendar _tgl)
//    {
//        this.m_tgl_keluar = _tgl;
//    }
//
//    public String getMemo () { return m_memo; }
//
//    public void setMemo (String _memo)
//    {
//        this.m_memo = (_memo != null) ? _memo : "";
//    }
//
//    public Calendar getBusinessObjCreateDate () { return m_bo_createdate; }
//
//    public void setBusinessObjCreateDate (Calendar m_user_createdate)
//    {
//        this.m_bo_createdate = m_user_createdate;
//    }
//
//    public Calendar getBusinessObjUpdateDate () { return m_bo_updatedate; }
//
//    public void setBusinessObjUpdateDate (Calendar m_user_modifydate)
//    {
//        this.m_bo_updatedate = m_user_modifydate;
//    }
//
//    public UserCredential getBusinessObjCreator ()
//    {
//        return m_boCreator;
//    }
//
//    public void setBusinessObjCreator (UserCredential _emp_create)
//    {
//        this.m_boCreator = _emp_create;
//    }
//
//    public UserCredential getBusinessObjUpdater ()
//    {
//       return m_boUpdater;
//    }
//
//    public void setBusinessObjUpdater (UserCredential _empModify)
//    {
//        this.m_boUpdater = _empModify;
//    }
//}
