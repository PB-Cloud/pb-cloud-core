///*
// * @File : StockAdjustment.java	@Date : Des 12, 2007, 12:07:04 AM
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
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//
///**
// *
// * @author Irfin A
// * @version 1.0 - Des 12, 2007 ; initial version
// * @version 1.2 - Aug 1, 2014 ; rename atribut m_bo_creator & m_bo_createdate
// *                      menjadi m_sys_creator & m_sys_createDate, dan penyesuaian
// *                      nama method accessor dan mutator-nya.
// */
//@Entity
//@Table(name="stockadjustment")
//@Inheritance (strategy = InheritanceType.JOINED)
//public class StockAdjustment                           
//{
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_stockadjust" )
//    @SequenceGenerator (name = "stockadjustment_id_stockadjust_seq", sequenceName = "stockadjustment_id_stockadjust_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "stockadjustment_id_stockadjust_seq")
//    private int m_id_stockadjust;
//    
//    @ManyToOne
//    @JoinColumn( name = "sys_creator" )
//    private UserCredential m_sys_creator;
//    
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang m_gudang;
//    
//    /** Menyimpan timestamp dilakukannya penyesuaian. */
//    @Column( name = "adjustment_datetime" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_adjustment_datetime;
//    
//    @Column( name = "sys_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    private Calendar m_sys_createDate;
//    
//    @Column( name = "memo" )
//    private String m_memo;
//    
//    @OneToMany( mappedBy = "m_stockAdj", cascade = CascadeType.ALL)
//    private List<AdjustedItem> m_listAdjustedItem ;
//    
//    @Transient
//    private AdjustedItem[] m_arrAdjustedItems;
//    
//    
//    public StockAdjustment ()
//    {
//        m_arrAdjustedItems = null;
//    }
//    
//    public int getID () { return m_id_stockadjust; }
//
//    public void setID (int m_id_stockadjust)
//    {
//        this.m_id_stockadjust = m_id_stockadjust;
//    }
//
//    public Calendar getDatetime () { return m_adjustment_datetime; }
//
//    public void setDatetime (Calendar m_adjustment_datetime)
//    {
//        this.m_adjustment_datetime = m_adjustment_datetime;
//    }
//
//    public String getMemo () { return m_memo; }
//
//    public void setMemo (String m_memo)
//    {
//        this.m_memo = m_memo;
//    }
//    
//    public int getAdjustedItemCount ()
//    {
//        return (m_arrAdjustedItems != null) ? m_arrAdjustedItems.length : 0;
//    }
//
//    public AdjustedItem[] getAdjustedItems () 
//    { 
//        if(m_arrAdjustedItems == null)
//        {
//            if(m_listAdjustedItem != null)
//            {
//                m_arrAdjustedItems = m_listAdjustedItem.toArray(new AdjustedItem[]{});
//            }
//        }
//        
//        return m_arrAdjustedItems; 
//    }
//
//    public void setAdjustedItems (AdjustedItem[] _arrAdjItems)
//    {
//        this.m_arrAdjustedItems = _arrAdjItems;
//        
//        if (this.m_arrAdjustedItems != null) {
//            for (int i = 0; i < m_arrAdjustedItems.length; i++)
//                m_arrAdjustedItems[i].setAdjustment (this);
//            
//            m_listAdjustedItem = Arrays.asList (_arrAdjItems) ;
//        }
//    }
//
//    public Gudang getGudang () { return m_gudang; }
//
//    public void setGudang (Gudang m_gudang)
//    {
//        this.m_gudang = m_gudang;
//    }
//
//    public UserCredential getSysCreator ()
//    {
//        return m_sys_creator;
//    }
//
//    public void setSysCreator (UserCredential _emp)
//    {
//        this.m_sys_creator = _emp;
//    }
//    
//    public Calendar getSysCreateDate () { return m_sys_createDate; }
//
//    public void setSysCreateDate (Calendar _createdate)
//    {
//        this.m_sys_createDate = _createdate;
//    }
//}
