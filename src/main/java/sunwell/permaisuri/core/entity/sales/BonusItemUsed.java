///*
// * @File : BonusItemUsed.java	Created on May 23, 2007, 2:38 PM
// *
// * Copyright 2010 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.sql.*;
//import java.util.List;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.Metrics;
///**
// *
// * @author Irfin A
// * 
// * @version 1.0 - May 23, 2007 ; initial version
// * @version 2.0 - April 27, 2009 ; revisi rancangan kelas. Kelas ini tidak lagi
// *                  memiliki asosiasi ke BonusItem, tapi langsung ke Item.
// * @version 2.2 - March 08, 2010 ; perubahan interface dari PersistentObject ke EntityObject
// */
//@Entity
//@Table( name = "bonusitemused")
//@IdClass(BonusItemUsedPK.class)
//public class BonusItemUsed 
//{
//	@NotNull(message="{error_no_invoice}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_si" )
//    private EtnaSalesInvoice salesInvoice = null;
//    
//	@NotNull(message="{error_no_item}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item item = null;
//    
//    @Column( name = "qty" )
//    private double qty;
//    
//    @ManyToOne
//    @JoinColumn( name = "metric_used" )
//    private Metrics metricUsed ;
//    
//    @Column( name = "qty_in_sales_metric" )
//    private double qtyInMetricUsed ;
//    
//    @Column( name = "memo" )
//    private String memo;
//    
//
//    /** Creates a new instance of BonusItemUsed */
//    public BonusItemUsed ()
//    {
//        salesInvoice = null;
//        memo = "";
//        metricUsed = null ;
//        qty = 0.0 ;
//        qtyInMetricUsed = 0.0 ;
//    }
//
//    public String getMemo () { return memo; }
//
//    public void setMemo (String _txt)
//    {
//        this.memo = (_txt != null) ? _txt : "";
//    }
//
//    //!!!!!
//    public EtnaSalesInvoice getSalesInvoice() {
//        return salesInvoice;
//    }
//
//    //!!!! 
//    public void setSalesInvoice(EtnaSalesInvoice m_esi) {
//        this.salesInvoice = m_esi;
//    }
//
//    public double getQty() {
//        return qty;
//    }
//
//    /**
//     * Set nilai quantity berdasarkan satuan/metrik inventory.
//     */
//    public void setQty (double _qty)
//    {
//        this.qty = _qty;
//        qtyInMetricUsed = 0.0;
//        metricUsed = null;
//    }
//        
//    public double getQtyInMetricUsed () { return qtyInMetricUsed; }
//    
//    public Metrics getMetricUsed ()
//    {
//        return metricUsed;
//    }
//
//}
