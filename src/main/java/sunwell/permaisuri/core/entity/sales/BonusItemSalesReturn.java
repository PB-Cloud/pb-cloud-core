///*
// * @File : ItemSalesReturn.java	Created on October 23, 2007, 6:59 PM
// *
// * Copyright 2010 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.sql.*;
//import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.Metrics;
//import sunwell.permaisuri.core.entity.inventory.MetricsConversion;
//
///**
// *
// * @author root
// */
//@Entity
//@Table( name = "bonusitemsalesreturn")
//@IdClass(ItemSalesReturnPK.class)
//public class BonusItemSalesReturn 
//{
//	@NotNull(message="{error_no_sales_return}")
//    @Id
//    @ManyToOne()
//    @JoinColumn( name = "id_sr" )
//    private SalesReturn salesReturn = null;
//    
//	@NotNull(message="{error_no_item}")
//    @Id
//    @ManyToOne()
//    @JoinColumn( name = "id_product" )    
//    private Item item = null;
//    
//    @Column( name = "qty" )
//    private double qty;
//    
//    @ManyToOne
//    @JoinColumn( name = "metricused" )
//    private Metrics metricUsed ;
//    
//    @Column( name = "qty_in_sales_metric" )
//    private double qtyInMetricUsed;
//    
//    @Column( name = "serial_no_s100")
//    private String m_serialno_s100;
//    
//
//    /** Creates a new instance of ItemSalesReturn */
//    public BonusItemSalesReturn()
//    {
//        qty = 0.0;
//        m_serialno_s100 = "";
//    }
//
//    
//
//    public SalesReturn getSalesReturn() {
//        return salesReturn;
//    }
//
//    public void setSalesReturn(SalesReturn _salesRet) {
//        this.salesReturn = _salesRet;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item _item) {
//        this.item = _item;
//    }
//
//    public double getQty() {
//        return qty;
//    }
//
//     public void setQty (double m_qty)
//    {
//        this.qty = m_qty;
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
//    public String getSerialNo() {
//        return m_serialno_s100;
//    }
//
//    public void setSerialNo(String m_serialno_s100) {
//        this.m_serialno_s100 = m_serialno_s100;
//    }
//
//    public void resetAttributes()
//    {
//        qty = 0.0;
//        m_serialno_s100 = "";
//        metricUsed = null ;
//        qtyInMetricUsed = 0.0 ;
//    }    
//}
