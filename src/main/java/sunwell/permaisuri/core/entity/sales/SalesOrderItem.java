/*
 * SOLines.java
 *
 * Created on September 22, 2007, 7:34 PM
 */
package sunwell.permaisuri.core.entity.sales;

import java.sql.*;

import java.util.Arrays;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.ItemShipmentInfo;
import sunwell.permaisuri.core.entity.inventory.Metrics;

/**
 *
 * @author Irfin A
 * @author Benny
 * 
 * @version 1.0 - Sep 22, 2007 ; initial version
 * @version 1.5 - Mar 13, 2010 ; perubahan interface dari PersistentObject ke
                  EntityObject
 * @version 2.0 - May 24, 2015 ; tambahan atribut m_metricUsed dan m_qtyInMetricUsed
 */
@Entity
@Table( name = "salesorderitem" )
@IdClass(SalesOrderItemPK.class)
public class SalesOrderItem 
{
    @NotNull(message="{error_no_so}")
    @Id
    @ManyToOne
    @JoinColumn( name ="parent")
    private SalesOrder parent;
    
    @NotNull(message="{error_no_item}")
    @Id
    @ManyToOne
    @JoinColumn( name = "item")
    private Item item ;
    
    @Column( name = "qty" )
    private double qty = 0.0;
    
    @Column( name = "disc" )
    private double discount = 0.0;
//    
//    @Column( name = "qty_in_sales_metric" )
//    private double qtyInMetricUsed = 0.0;
//    
//    @ManyToOne
//    @JoinColumn( name ="metricused" )
//    private Metrics metricUsed ;
    
//    @ManyToOne
//    @JoinColumn( name = "shipmentused")
//    private ItemShipmentInfo shipmentUsed ;
    
//    @OneToMany (mappedBy = "soItem", cascade = CascadeType.ALL)
//    private List<AppliedSOItemDiscounts> discounts ;
    
    @Column( name = "harga_jual" )
    private double hargaJual = 0.0;
    
//    @Column(name="reqnote")
//    private String reqNote;
    
    
    
//    /** Creates a new instance of SOItem */
//    public SOItem ()
//    {
//        salesOrder = null;
//        item = null;
//        shipmentUsed = null ;
//        metricUsed = null ;
//        qty = 0.0 ;
//        qtyInMetricUsed = 0.0 ;
//    }
//    
//    /** Creates a new instance of exist SOItem */
//    public SOItem (SalesOrder _so, Item _item)
//    {
//        salesOrder = _so;
//        item = _item;
//        shipmentUsed = null ;
//        qty = 0.0 ;
//        qtyInMetricUsed = 0.0 ;
//    }
    
//    public SalesOrder getSalesOrder () { return salesOrder; }
//
//    public void setItem (Item _item)
//    {
//        this.item = _item;
//    }
    
    public SalesOrderItem() {
    	
    }
    
    public SalesOrderItem(SalesOrder _so, Item _item, double _qty) {
    	parent = _so;
    	item = _item;
    	qty = _qty;
    }
    
    public SalesOrder getParent () { return parent; }

    public void setSalesOrder (SalesOrder _parent)
    {
        this.parent = _parent;
    }
        
    public Item getItem () { return item; }

    public void setItem (Item _item)
    {
        this.item = _item;
    }

    public double getQty () { return qty; }

    /**
     * Penggunaan method ini akan meng-override nilai qty yang sebelumnya diset
     * melalui {@link #setQtyInSalesMetric(double, sunwell.xrp.inventory.Metrics)}.
     * 
     * @param m_qty 
     */
    public void setQty (double _qty)
    {
        this.qty = _qty;
//        qtyInMetricUsed = 0.0;
//        metricUsed = null;
    }
    
    // dikomen sementara karena operasi MetricsConversion membutuhkan akses ke databse
//    public void setQtyInSalesMetric (double _qty, Metrics _metricUsed) throws SQLException
//    {
//        m_qtyInMetricUsed = _qty;
//        m_metricUsed = _metricUsed;
//        
//        double factor = 0;
//        if (_qty > 0 && _metricUsed != null ) {
//            MetricsConversion mc = MetricsConversion.getConversion (m_item.getMetricInv (), _metricUsed );
//            factor = mc.getFactor ();
//        }
//        
//        m_qty = m_qtyInMetricUsed * factor;
//    }
        
//    public double getQtyInMetricUsed () { return qtyInMetricUsed; }
//    
//    public void setMetricUsed (Metrics _metric)
//    {
//        metricUsed = _metric;
//    }
//    
//    public Metrics getMetricUsed ()
//    {
//        return metricUsed;
//    }
//    

//    public void setQtyInSalesMetric (double _qty)
//    {
//        this.m_qtyInMetricUsed = _qty;
//    }

    public double getHargaJual () { return hargaJual; }

    public void setHargaJual (double m_harga_jual)
    {
        this.hargaJual = m_harga_jual;
    }
    
//    public int getDiscountCount ()
//    {
//        if (discounts != null)
//            return discounts.size();
//        else
//            return 0;
//    }
//
//    public List<AppliedSOItemDiscounts> getDiscounts () 
//    { 
//        return discounts; 
//    }
//
//    public void setItemDiscs (List<AppliedSOItemDiscounts> _discounts)
//    {
//        discounts = _discounts;
//     }
//    
//    public ItemShipmentInfo getShipmentUsed () { return shipmentUsed ; }
//
//    public void setShipmentUsed (ItemShipmentInfo _shipment)
//    {
//        this.shipmentUsed = _shipment;
//    }
    
//    public void resetAttributes ()
//    {
//        salesOrder = null;
//        item = null;
//        metricUsed = null ;
//    }

	public double getDiscount ()
	{
		return discount;
	}

	public void setDiscount (double _discount)
	{
		discount = _discount;
	}

//	public String getReqNote ()
//	{
//		return reqNote;
//	}
//
//	public void setReqNote (String _reqNote)
//	{
//		reqNote = _reqNote;
//	}   
}
