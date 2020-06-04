///*
// * @File : CustBeginningBalance.java	Created on December 30, 2007, 04:34 PM
// *
// * Copyright 2010 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.sql.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.customer.Customer;
///**
// * Di database, meski ada primary key `id_cbb`, tetapi pasangan nilai `id_cust`
// *  dan `no_faktur_s100` harus unik.
// * 
// * Nilai amount pada beginning balance ini harus sudah termasuk PPN (VAT inclusive)
// *
// * @author Irfin
// */
//@Entity
//@Table( name = "custbeginningbalance" )
//public class CustBeginningBalance extends StdSalesInvoice
//{
//    @Column( name = "no_faktur_s100" )
//    private String m_no_faktur_s100 = "";
//    
//    @Column( name = "amount" )
//    private double amount = 0.0;
//
//    /**
//     * Create new instance of CustBeginningBalance
//     * 
//     * @param _cust
//     */
//    public CustBeginningBalance (Customer _cust)
//    {
//        super.setReference (ISalesInvoiceConstants.REF_TYPE_BEGINNING_BALANCE, -1);
//        this.setSystemId (-1);
//
//        setCustomer(_cust);
//        setMemo("");
//
//        m_no_faktur_s100 = "";
//        amount = 0.0;
//    }
//    
//    public CustBeginningBalance ()
//    {
//        super.setReference (ISalesInvoiceConstants.REF_TYPE_BEGINNING_BALANCE, -1);
//        this.setSystemId (-1);
//
//       
//        m_no_faktur_s100 = "";
//        amount = 0.0;
//    }
//
//    public CustBeginningBalance (int _id)
//    {
//        super.setReference (ISalesInvoiceConstants.REF_TYPE_BEGINNING_BALANCE, -1);
//        this.setSystemId (_id);
//
//        m_no_faktur_s100 = "";
//        amount = 0.0;
//    }
//
//    /**
//     * Copy Constructor utk mengambil nilai dari StdSalesInvoice
//     * 
//     * @param _parent
//     */
//    private CustBeginningBalance(StdSalesInvoice _parent)
//    {
//        super.setReference (ISalesInvoiceConstants.REF_TYPE_BEGINNING_BALANCE, -1);
//
////        setAppliedDiscounts (_parent.getAppliedDiscounts ());
//        setBonusItems (_parent.getBonusItems ());
//        setCustomer (_parent.getCustomer ());
//        setDueDate (_parent.getDueDate ());
//        setSystemId (_parent.getSystemId ());
//        setIssueDateTime (_parent.getIssueDateTime ());
//        setMemo (_parent.getMemo ());
//        setMiscCharges (_parent.getMiscCharges ());
//        setMiscChargesMemo (_parent.getMiscChargesMemo ());
//        setNoInvoice (_parent.getNoInvoice ());
//        setPaid (_parent.isPaid ());
//        setPaymentType (_parent.getPaymentType ());
//        setSalesItems (_parent.getSalesItems ());
//        setVAT (_parent.getVAT ());
//        setVATInclusive (_parent.isVATInclusive ());
//        setBusinessObjCreator (_parent.getBusinessObjCreator ());
//        setBusinessObjCreateDate (_parent.getBusinessObjCreateDate ());
//        setBusinessObjUpdater (_parent.getBusinessObjUpdater ());
//        setBusinessObjUpdateDate (_parent.getBusinessObjUpdateDate ());
//
//        m_no_faktur_s100 = "";
//        amount = 0.0;
//    }
//
//    @Override
//    public void setReference (int _refType, int _refID) {
//        // do nothing, agar user tdk bisa mengubah tipe referensi.
//    }
//
//    public String getNoFaktur() {
//        return m_no_faktur_s100;
//    }
//
//    /**
//     * Nomor Faktur tidak boleh lebih dari 100 karakter.
//     * 
//     * @param _noFaktur_s100
//     */
//    public void setNoFaktur (String _noFaktur_s100)
//    {
//        m_no_faktur_s100 = (_noFaktur_s100 != null)
//                ? (_noFaktur_s100.length() > 100 ? _noFaktur_s100.substring(0, 99) : _noFaktur_s100)
//                : "";
//
//        this.setNoInvoice(m_no_faktur_s100);
//    }
//
//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double m_amount) {
//        this.amount = m_amount;
//    }
//
//   
//    public void resetAttributes ()
//    {
//        super.resetAttributes ();
//
//        amount = 0.0;
//        m_no_faktur_s100 = "";
//    }
//
//   
//}
