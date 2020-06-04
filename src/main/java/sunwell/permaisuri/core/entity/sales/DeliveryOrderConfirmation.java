///*
// * DeliveryOrderConfirmation.java
// *
// * Created on December 29, 2007, 01:51 AM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.util.*;
//import java.sql.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//
//
///**
// * Menyimpan konfirmasi pengiriman barang D.O. Satu D.O. hanya boleh memiliki 
// * 1 buah konfirmasi.
// * @author Irfin
// * 
// * @version 1.0 - Dec 29, 2007 ; initial version
// * @version 1.5 - Mar 18, 2010 ; perubahan interface dari PersistentObject ke
// *                  EntityObject, dan implementasi interface ITraceableBusinessObject.
// */
//@Entity
//@Table( name = "deliveryorderconfirmation" )
//public class DeliveryOrderConfirmation 
//{
//    /** Flag yg menandakan belum ada pengiriman barang yg dikonfirmasi */
//    public static final int STATUS_NOT_CONFIRMED = 0;
//    /** Flag yg menandakan sebagian pengiriman barang sudah dikonfirmasi */
//    public static final int STATUS_PARTIALLY_CONFIRMED = 1;
//    /** Flag yg menandakan seluruh barang telah dikonfirmasi pengirimannya */
//    public static final int STATUS_FULLY_CONFIRMED = 2;
//
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_doc" )
//    @SequenceGenerator (name = "deliveryorderconfirmation_id_doc_seq", sequenceName = "deliveryorderconfirmation_id_doc_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "deliveryorderconfirmation_id_doc_seq")
//    private int m_id_doc;
//
//    @ManyToOne
//    @JoinColumn( name = "id_do" )
//    private DeliveryOrder m_confirmedDO;
//    
//    @ManyToOne
//    @JoinColumn( name = "uid_user_create" )
//    private UserCredential m_bo_creator = null;
//    
//    @ManyToOne
//    @JoinColumn( name = "uid_user_modify" )
//    private UserCredential m_bo_updater = null;
//    
//    @OneToMany( mappedBy = "m_doc", cascade = CascadeType.ALL )
//    private List< ItemDOConfirmation> m_listConfirmedItem ;
//    
//    @Transient
//    private ItemDOConfirmation[] m_arrConfirmedItem;
//    
//    @Column( name = "user_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)    
//    private Calendar m_bo_createdate;
//    
//    @Column( name = "user_modifydate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_bo_updatedate;
//    
//    @Column( name = "rcvd_datetime" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)      
//    private Calendar m_rcvd_datetime;
//    
//    @Column( name = "rcvd_by" )
//    private String m_rcvd_by;
//    
//    @Column( name = "driver" )
//    private String m_driver;
//    
//    @Column( name = "memo" )
//    private String m_memo;
//        
//    
//    public DeliveryOrderConfirmation ()
//    {
//        this (-1);
//    }
//
//    public DeliveryOrderConfirmation (int _idDOC)
//    {
//        m_id_doc = _idDOC;
//        m_confirmedDO = null;
//        m_arrConfirmedItem = null;
//        m_driver = "";
//        m_memo = "";
//        m_rcvd_by = "";
//    }
//
//    /**
//     * Menciptakan Konfirmasi DO berdasarkan DO <code>_confirmedDO</code>. Item/barang
//     * yg dikonfirmasi adalah semua barang pada _confirmedDO, kecuali jika pengguna
//     * kelas ini kemudian memanggil method <code>setConfirmedItem</code>
//     *
//     * @param _confirmedDO
//     */
//    public DeliveryOrderConfirmation (DeliveryOrder _confirmedDO)
//    {
//        this (-1);
//        m_confirmedDO = _confirmedDO;
//
//        List<ItemDO> listDO = _confirmedDO.getItems ();
//        m_arrConfirmedItem = new ItemDOConfirmation [_confirmedDO.getItemCount ()];
//
//        for (int i = 0; i < m_arrConfirmedItem.length; i++) {
//            m_arrConfirmedItem[i] = new ItemDOConfirmation ();
//            m_arrConfirmedItem[i].setItem (listDO.get(i).getItem ());
//            m_arrConfirmedItem[i].setQtyConfirmed (listDO.get(i).getQty ());
//        }
//        this.setConfirmedItem (m_arrConfirmedItem);
//    }
//    
//    public int getID () { return m_id_doc; }
//
//    public void setID (int m_id_doc)
//    {
//        this.m_id_doc = m_id_doc;
//    }
//    
//    
//    public void setConfirmedDeliveryOrder (DeliveryOrder _do)
//    {
//        this.m_confirmedDO = _do;
//    }
//    
//    public ItemDOConfirmation[] getConfirmedItems () { return m_arrConfirmedItem; }
//
//    public void setConfirmedItem (ItemDOConfirmation[] _arrIDOC)
//    {
//        m_arrConfirmedItem = _arrIDOC;
//
//        if (m_arrConfirmedItem != null)
//        {
//            for (int i = 0; i < m_arrConfirmedItem.length; i++) {
//                m_arrConfirmedItem[i].setDelivOrderConfirmation (this);
//            }
//            m_listConfirmedItem = Arrays.asList (m_arrConfirmedItem) ;
//        }
//        
//    }
//
//    public Calendar getReceivedDatetime () { return m_rcvd_datetime; }
//
//    public void setReceivedDatetime (Calendar m_rcvd_datetime)
//    {
//        this.m_rcvd_datetime = m_rcvd_datetime;
//    }
//
//    public String getReceivedBy () { return m_rcvd_by; }
//
//    public void setReceivedBy (String _receivedBy)
//    {
//        this.m_rcvd_by = (_receivedBy != null) ? _receivedBy : "";
//    }
//
//    public String getDriver () { return m_driver; }
//
//    public void setDriver (String _driver)
//    {
//        this.m_driver = (_driver != null) ? _driver : "";
//    }
//
//    public String getMemo () { return m_memo; }
//
//    public void setMemo (String _memo)
//    {
//        this.m_memo = (_memo != null) ? _memo : "";
//    }
//
//        public UserCredential getBusinessObjCreator ()
//    {
//
//        return m_bo_creator;
//    }
//
//    public void setBusinessObjCreator (UserCredential _user_create)
//    {
//        m_bo_creator = _user_create;
//    }
//    
//    /**
//     * Melakukan query ke DB utk mendapatkan objek User yg memodifikasi Purchase ini.
//     */
//    public UserCredential getBusinessObjUpdater ()
//    { 
//        return m_bo_updater;
//    }
//
//    public void setBusinessObjUpdater (UserCredential m_userModify)
//    {
//        m_bo_updater = m_userModify;
//    }
//
//    public Calendar getBusinessObjCreateDate () { return m_bo_createdate; }
//
//    public void setBusinessObjCreateDate (Calendar _user_createdate)
//    {
//        this.m_bo_createdate = _user_createdate;
//    }
//
//    public Calendar getBusinessObjUpdateDate () { return m_bo_updatedate; }
//    
//    public void setBusinessObjUpdateDate (Calendar m_user_modifydate)
//    {
//        m_bo_updatedate = m_user_modifydate;
//    }
//
//    public void resetAttributes ()
//    {
//        m_id_doc = -1;
//        m_confirmedDO = null;
//        m_arrConfirmedItem = null;
//        m_driver = "";
//        m_memo = "";
//        m_rcvd_by = "";
//    }
//
//}
