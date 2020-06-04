///*
// * @File : CustCreditNote.java	Created on August 03, 2008, 4:25 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.sql.*;
//import java.util.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.customer.Customer;
///**
// * 
// * @author Irfin
// */
//@Entity
//@Table( name = "custcreditnote")
//public class CustCreditNote
//{
//	@Id
//	@Column(name="id_cust")
//	private Integer id  ;
//	
////    @Id
//    @OneToOne
//    @MapsId
//    @JoinColumn( name = "id_cust" )
//    private Customer m_cust;
//    
//    @Column( name = "lastdate" )
//    @Temporal(javax.persistence.TemporalType.DATE)    
//    private Calendar m_lastdate; 
//    
//    @Column( name = "amount" )
//    private double m_amount;
//    
//    @Column( name = "currency" )
//    private int m_currency;
//    
//    @Column( name = "memo" )
//    private String m_memo;
//
//    /** Creates a new instance of CustCreditNote */
//    public CustCreditNote() 
//    {
//        m_memo = "";
//        m_currency = 0;
//    }
//
//    public Customer getCustomer () { return m_cust; }
//
//    public void setCustomer (Customer m_cust)
//    {
//        this.m_cust = m_cust;
//    }
//
//    public double getAmount () { return m_amount; }
//
//    public void setAmount (double m_amount)
//    {
//        this.m_amount = m_amount;
//    }
//
//    public Calendar getLastDate () { return m_lastdate; }
//
//    public void setLastDate (Calendar m_lastdate)
//    {
//        this.m_lastdate = m_lastdate;
//    }
//
//    public int getCurrency () { return m_currency; }
//
//    public void setCurrency (int m_currency)
//    {
//        this.m_currency = m_currency;
//    }
//
//    public String getMemo () { return m_memo; }
//
//    public void setMemo (String _txt)
//    {
//        this.m_memo = (_txt != null) ? _txt : "";
//    }
//  
//}
