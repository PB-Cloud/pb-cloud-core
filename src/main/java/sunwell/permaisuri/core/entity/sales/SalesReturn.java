///*
// * @File : SalesReturn.java	Created on September 5, 2007, 2:29 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.util.*;
//import java.sql.*;
//import static java.util.Collections.list;
//import javax.persistence.EntityManager;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//import sunwell.permaisuri.core.entity.warehouse.Gudang;
//
//import javax.persistence.*;
///**
// *
// * @author Irfin A
// * @version 1.0 - September 5, 2007 ; initial work
// * @version 1.2 - March 4, 2009 ; penambahan method baru queryForSalesInvoice(int)
// * @version 1.5 - May 23, 2009 ; meniru MS Office Accounting Express 2008, setiap retur
// *                  pasti ditambahkan ke customer credit note. Jadi atribut
// *                  m_applyToCustCreditNote di-non-aktifkan.
// * @version 1.7 - Mar 11, 2010 ; perubahan implementasi interface dari PersistentObject
// *                  ke EntityObject.
// */
//@Entity
//@Table (name = "salesreturn")
//public class SalesReturn 
//{
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_sr" )
//    @SequenceGenerator (name = "salesreturn_id_sr_seq", sequenceName = "salesreturn_id_sr_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "salesreturn_id_sr_seq")
//    private int systemId;
//    
////    @NotNull(message="{error_no_invoice}")
////    @ManyToOne
////    @JoinColumn( name = "id_si")
////    private SalesInvoiceOriginal salesInvoice;
//    
//    @NotNull(message="{error_no_warehouse}")
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang destinationWarehouse;
//    
//    @ManyToOne
//    @JoinColumn( name = "bo_creator" )    
//    private UserCredential sysCreator;
//    
////    @OneToMany( mappedBy = "salesReturn", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
////    private  List<AppliedSalesRetDiscount> discounts ;
//    
//    @OneToMany( mappedBy = "salesReturn", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
//    private List<ItemSalesReturn> items ;
//    
//    @OneToMany( mappedBy = "salesReturn", cascade = CascadeType.ALL, fetch=FetchType.EAGER )
//    private List<BonusItemSalesReturn> bonusItems ;
//    
//    @Column( name = "return_date" )
//    @Temporal(javax.persistence.TemporalType.DATE)    
//    private Calendar returnDate = Calendar.getInstance();
//    
//    @Column( name = "bo_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)  
//    private Calendar createDate;
//    
////    private boolean m_applyToCustCreditNote = false;      // not-active per @version 1.5
//    @Column( name = "memo" )
//    private String memo = "";
//    
//    @Column( name = "vat" )
//    private double vat = 0.0;
//    
//    @Column( name = "vat_inclusive" )
//    private boolean vatInclusive = false;
//    
//    
//    /** Creates a new instance of SalesReturn */
//    public SalesReturn ()
//    {
//        this (-1);
//    }
//
//    public SalesReturn (int _id)
//    {
//
//        systemId = _id;
////        salesInvoice = null;
//        destinationWarehouse = null;
////        m_applyToCustCreditNote = false;      // not-active per @version 1.5
//        memo = "";
//    }
//    
//    public int getSystemId () { return systemId; }
//
//    public void setSystemId (int _id)
//    {
//        this.systemId = _id;
//    }
//
//    public Calendar getReturnDate () { return returnDate; }
//
//    public void setReturnDate (Calendar m_return_date)
//    {
//        this.returnDate = m_return_date;
//    }
//    
////    public void setSalesInvoice (SalesInvoiceOriginal _si)
////    {
////        this.salesInvoice = _si;
////    }
//
//    public Gudang getDestinationWarehouse () { return destinationWarehouse; }
//
//    public void setDestinationWarehouse (Gudang _gudang)
//    {
//        this.destinationWarehouse = _gudang;
//    }
//    
//    public List<ItemSalesReturn> getReturnedItems () 
//    { 
//        return items;
//    }
//    
//    public int getReturnedItemCount ()
//    {
//        return (items != null) ? items.size() : 0;
//    }
//    
//    public void setReturnedItems (List<ItemSalesReturn> _items)
//    {
//        items = _items;
//    }
//    
//    public List<BonusItemSalesReturn> getReturnedBonusItems () 
//    { 
//        return bonusItems;
//        
//    }
//    
//    public int getReturnedBonusItemCount ()
//    {
//        return bonusItems != null ? bonusItems.size () : 0 ;
//    }
//    
//    public void setReturnedBonusItems (List<BonusItemSalesReturn> _items)
//    {
//        bonusItems = _items;
//    }
//    
//    public String getMemo () { return memo; }
//    
//    public void setMemo (String _txt)
//    {
//        this.memo = (_txt != null) ? _txt : "";
//    }
//    
////    public List<AppliedSalesRetDiscount> getDiscounts () 
////    { 
////        return discounts; 
////    }
////    
////    public int getDiscountCount ()
////    {
////        return (discounts != null) ? discounts.size() : 0;
////    }
////    
////    public void setDiscounts (List<AppliedSalesRetDiscount> _discs)
////    {
////        discounts = _discs;
////    }
//    
//    public double getVAT () { return vat; }
//    
//    public void setVAT (double _vat)
//    {
//        this.vat = _vat;
//    }
//    
//    public boolean isVATInclusive () { return vatInclusive; }
//    
//    public void setVATInclusive (boolean _isInclusive)
//    {
//        this.vatInclusive = _isInclusive;
//    }
//
//    public UserCredential getSysCreator ()
//    {
//        return sysCreator;
//    }
//
//    public void setSysCreator (UserCredential _e)
//    {
//        sysCreator = _e;
//    }
//    
//    public Calendar getSysCreateDate() { return createDate; }
//    
//    public UserCredential getSysUpdater()
//    {
//        throw new UnsupportedOperationException("Not supported.");
//    }
//
//    public Calendar getSysUpdateDate()
//    {
//        throw new UnsupportedOperationException("Not supported.");
//    }
//  
//    public void resetAttributes()
//    {
//        systemId = -1;
////        salesInvoice = null;
//        destinationWarehouse = null;
//        bonusItems = null ;
////        discounts = null ;
//        items = null ;
//        memo = "";
//    }
//
//    
//    public Object getGeneratedUniqueData ()
//    {
//        return String.valueOf (systemId);
//    }
//
//}
