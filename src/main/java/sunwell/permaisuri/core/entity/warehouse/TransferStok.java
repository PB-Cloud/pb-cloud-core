///*
// * @File : TransferStok.java	@Date : Apr 5, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//
//import java.sql.*;
//import java.util.*;
//import javax.persistence.*;
//import javax.persistence.EntityManager;
//import javax.persistence.Table;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//
///**
// * Menyimpan transfer stok antar gudang.
// *
// * @author Irfin A
// * @author Daisy
// */
//@Entity
//@Table(name="transferstok")
//public class TransferStok 
//{
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_transfer" )
//    @SequenceGenerator (name = "transferstok_id_transfer_seq", sequenceName = "transferstok_id_transfer_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "transferstok_id_transfer_seq")
//    private int m_id_transfer;
//    
//    /** Gudang asal (origin) */
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang m_gudangOrig;
//    
//    /** Gudang tujuan (destination) */
//    @ManyToOne
//    @JoinColumn( name = "id_gudang_dest" )
//    private Gudang m_gudangDest;
//    
//    @Column (name="transport")
//    private String m_transport;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )
//    private UserCredential m_bo_creator;
//    
//    @OneToMany( mappedBy = "m_transferStok" )
//    private List<ItemTransferStok> m_listITS ;
//    
//    @Transient
//    private ItemTransferStok[] m_arrITS;
//    
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_bo_createdate;
//    
//    @Column( name = "tgl_transfer" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_tgl_transfer;
//    
//    @Column( name = "reason" )
//    private String m_reason;
//    
//    @JoinColumn(name = "approval_responsible")
//    @ManyToOne
//    private UserCredential m_approvalResponsible;
//    
//    @Column( name = "approval_date" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_approvalDate;
//    
//    /**
//     * @roseuid 45C7F94701B4
//     */
//    public TransferStok ()
//    {
//        m_reason = "";
//    }
//    
//    public int getID () { return m_id_transfer; }
//
//    public void setID (int m_id_transfer)
//    {
//        this.m_id_transfer = m_id_transfer;
//    }
//
//    public Calendar getTglTransfer () { return m_tgl_transfer; }
//
//    public void setTglTransfer (Calendar m_tgl_transfer)
//    {
//        this.m_tgl_transfer = m_tgl_transfer;
//    }
//
//    public String getReason () { return m_reason; }
//
//    public void setReason (String m_reason)
//    {
//        this.m_reason = m_reason;
//    }
//
//    public ItemTransferStok[] getItemTransfer () 
//    { 
//        if(m_arrITS == null)
//        {
//            if(m_listITS != null)
//            {
//                m_arrITS = m_listITS.toArray(new ItemTransferStok[]{});
//            }
//        }
//        
//        return m_arrITS; 
//    }
//
//    public void setItemTransfer (ItemTransferStok[] _arrITS)
//    {
//        this.m_arrITS = _arrITS;
//        
//        if (m_arrITS == null)
//            return;
//        
//        for (int i = 0; i < m_arrITS.length; i++)
//            m_arrITS[i].setTransferStok (this);
//        
//        m_listITS = Arrays.asList (_arrITS) ;
//    }
//    
//    public int getItemTransferCount ()
//    {
//        if(m_arrITS == null)
//        {
//            if(m_listITS != null)
//            {
//                m_arrITS = m_listITS.toArray(new ItemTransferStok[]{});
//            }
//        }
//        
//        if (m_arrITS == null)
//            return 0;
//        else
//            return m_arrITS.length;
//    }
//    
//    /**
//     * First position is 0, continued with 1, 2, and so on.
//     */
//    public ItemTransferStok getItemAt (int _position)
//    {
//        if (m_arrITS == null)
//            return null;
//        else if (_position < 0 || _position > m_arrITS.length)
//            return null;
//        else
//            return m_arrITS [_position];
//    }
//
//    public Gudang getGudangOrigin () { return m_gudangOrig; }
//
//    public void setGudangOrigin (Gudang m_gudangOrig)
//    {
//        this.m_gudangOrig = m_gudangOrig;
//    }
//
//    public Gudang getGudangDest () { return m_gudangDest; }
//
//    public void setGudangDest (Gudang m_gudangDest)
//    {
//        this.m_gudangDest = m_gudangDest;
//    }
//    
//    public String getTransport ()
//    {
//        return m_transport;
//    }
//    
//    public void setTransport (String _s)
//    {
//        m_transport = _s;
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
//    public void setBusinessObjCreateDate (Calendar _c)
//    {
//        this.m_bo_createdate = _c;
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
//
//    public Calendar getApprovalDate() 
//    {
//        return m_approvalDate;
//    }
//
//    public void setApprovalDate(Calendar m_approvalDate)
//    {
//        this.m_approvalDate = m_approvalDate;
//    }
//
//    public UserCredential getApprovalResponsible() 
//    {
//        return m_approvalResponsible;
//    }
//
//    public void setApprovalResponsible(UserCredential m_approvalResponsible)
//    {
//        this.m_approvalResponsible = m_approvalResponsible;
//    }
//    
//    public boolean isApproved()
//    {
//        return m_approvalDate != null && m_approvalResponsible != null;
//    }  
//}
