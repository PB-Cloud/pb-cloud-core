///*
// * SQItem.java
// *
// * Created on January 17, 2014, 7:34 PM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.sql.*;
//import java.util.Arrays;
//import java.util.List;
//import javax.persistence.*;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.ItemShipmentInfo;
//import sunwell.permaisuri.core.entity.inventory.Metrics;
//
///**
// *
// * @author Benny
// */
//@Entity
//@Table( name = "sqitem" )
//@IdClass(SQItemPK.class)
//public class SQItem 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_sq")
//    private SalesQuotation m_sq;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product")
//    private Item m_item ;
//    
//    @ManyToOne
//    @JoinColumn( name = "metricused" )
//    private Metrics m_metricUsed ;
//    
//    @ManyToOne
//    @JoinColumn( name = "shipmentused")
//    private ItemShipmentInfo m_shipmentUsed ;
//    
//    @OneToMany( mappedBy = "m_sqItem", cascade = CascadeType.ALL )
//    private List<AppliedSQItemDiscounts> m_listitemDiscs ;
//    
//    @Transient
//    private AppliedSQItemDiscounts[] m_arrItemDiscs;
//    
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Column( name = "harga_jual" )
//    private double m_harga_jual;
//    
//    
//    
//    
//    /** Creates a new instance of SOItem */
//    public SQItem ()
//    {
//        m_sq = null;
//        m_item = null;
//        m_arrItemDiscs = null;
//        m_shipmentUsed = null ;
//        m_metricUsed = null ;
//    }
//    
//    /** Creates a new instance of exist SOItem */
//    public SQItem (SalesQuotation _sq, Item _item)
//    {
//        m_sq = _sq;
//        m_item = _item;
//        m_arrItemDiscs = null;
//        m_shipmentUsed = null ;
//    }
//       
//    
//    public Item getItem () { return m_item; }
//
//    public void setItem (Item _item)
//    {
//        this.m_item = _item;
//    }
//
//    public double getQty () { return m_qty; }
//
//    public void setQty (double m_qty)
//    {
//        this.m_qty = m_qty;
//    }
//
//    public double getHargaJual () { return m_harga_jual; }
//
//    public void setHargaJual (double m_harga_jual)
//    {
//        this.m_harga_jual = m_harga_jual;
//    }
//
//    public SalesQuotation getSalesQuotation () { return m_sq; }
//
//    public void setSalesQuotation (SalesQuotation m_sq)
//    {
//        this.m_sq = m_sq;
//    }
//    
//    public int getDiscountCount ()
//    {
//        if(m_arrItemDiscs == null)
//        {
//            if(m_listitemDiscs != null)
//            {
//                m_arrItemDiscs = m_listitemDiscs.toArray(new AppliedSQItemDiscounts[]{});
//            }
//        }
//        
//        if (m_arrItemDiscs != null)
//            return m_arrItemDiscs.length;
//        else
//            return 0;
//    }
//
//    public AppliedSQItemDiscounts[] getItemDiscs () 
//    { 
//        if(m_arrItemDiscs == null)
//        {
//            if(m_listitemDiscs != null)
//            {
//                m_arrItemDiscs = m_listitemDiscs.toArray(new AppliedSQItemDiscounts[]{});
//            }
//        }
//        return m_arrItemDiscs; 
//    }
//
//    public void setItemDiscs (AppliedSQItemDiscounts[] _arrItemDiscs)
//    {
//        this.m_arrItemDiscs = _arrItemDiscs;
//        
//        if (m_arrItemDiscs != null) {
//            for (int i = 0; i < m_arrItemDiscs.length; i++)
//                m_arrItemDiscs[i].setSQItem (this);
//        
//            m_listitemDiscs = Arrays.asList (m_arrItemDiscs) ;
//        }
//    }
//    
//    public ItemShipmentInfo getShipmentUsed () { return m_shipmentUsed ; }
//
//    public void setShipmentUsed (ItemShipmentInfo _shipment)
//    {
//        this.m_shipmentUsed = _shipment;
//    }
//    
//    public Metrics getMetric () { return m_metricUsed; }
//
//    public void setItem (Metrics _metric)
//    {
//        this.m_metricUsed = _metric;
//    }
//    
//    public void resetAttributes ()
//    {
//        m_sq = null;
//        m_item = null;
//        m_arrItemDiscs = null;
//        m_metricUsed = null ;
//    }
//}
