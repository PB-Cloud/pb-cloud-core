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
//@Table( name = "itemsalesreturn")
//@IdClass(ItemSalesReturnPK.class)
//public class ItemSalesReturn 
//{
//	@NotNull(message="{error_no_sales_return}")
//    @Id
//    @ManyToOne()
//    @JoinColumn( name = "id_sr" )
//    private SalesReturn salesReturn ;
//    
//	@NotNull(message="{error_no_item}")
//    @Id
//    @ManyToOne()
//    @JoinColumn( name = "id_product" )    
//    private Item item = null;
//    
//    @ManyToOne
//    @JoinColumn( name = "metricused" )
//    private Metrics metricUsed ;
//    
//    @Column( name = "qty" )
//    private double qty;
//    
//    @Column( name = "qty_in_sales_metric" )
//    private double qtyInMetricUsed;
//    
//    @Column( name = "serial_no_s100")
//    private String serialNoS100;
//    
//    @Column( name = "harga_retur" )
//    private double hargaRetur;
//
//    /** Creates a new instance of ItemSalesReturn */
//    public ItemSalesReturn()
//    {
//        qty = 0.0;
//        serialNoS100 = "";
//        hargaRetur = 0.0;
//    }
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
//    public void setQty (double m_qty)
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
//        return serialNoS100;
//    }
//
//    public void setSerialNo(String _serialno_s100) {
//        this.serialNoS100 = _serialno_s100;
//    }
//
//    public double getHargaRetur() {
//        return hargaRetur;
//    }
//
//    public void setHargaRetur(double _harga_retur) {
//        this.hargaRetur = _harga_retur;
//    }
//
//    public void resetAttributes()
//    {
//        qty = 0.0;
//        serialNoS100 = "";
//        hargaRetur = 0.0;
//        metricUsed = null ;
//        qtyInMetricUsed = 0.0 ;
//    }    
//}
