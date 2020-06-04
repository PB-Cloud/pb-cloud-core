///*
// * ItemDO.java
// *
// * Created on November 13, 2007, 1:48 PM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.sql.*;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//import sunwell.permaisuri.core.entity.inventory.ItemShipmentInfo;
///**
// *
// * @author Irfin A
// * 
// */
//@Entity
//@Table( name = "itemdo" )
//@IdClass(ItemDOPK.class)
//public class ItemDO 
//{
//	@NotNull(message="{error_no_do}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_do" )
//    private DeliveryOrder deliveryOrder;
//    
//	@NotNull(message="{error_no_item}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )    
//    private Item item;
//    
//    @ManyToOne
//    @JoinColumn( name = "shipmentused" )
//    private ItemShipmentInfo shipmentUsed ;
//    
//    @Column( name = "qty" )
//    private double qty = 0.0;
//    
//    @Column( name = "serialno_s100" )
//    private String serialNoS100;
//    
//    
//    
//    public ItemDO ()
//    {
//        deliveryOrder = null;
//        item = null;
//        qty = 0.0;
//        serialNoS100 = "";
//        shipmentUsed = null ;
//    }
//    
//  
//    
//    public DeliveryOrder getDeliveryOrder () { return deliveryOrder; }
//
//    public void setDeliveryOrder (DeliveryOrder m_delivOrder)
//    {
//        this.deliveryOrder = m_delivOrder;
//    }
//
//    public Item getItem () { return item; }
//
//    public void setItem (Item m_item)
//    {
//        this.item = m_item;
//    }
//
//    public double getQty () { return qty; }
//
//    public void setQty (double _qty)
//    {
//        this.qty = _qty;
//    }
//
//    public String getSerialNo () { return serialNoS100; }
//
//    public void setSerialNo (String _serialno)
//    {
//        this.serialNoS100 = (_serialno != null) ? _serialno : "";
//    }
//    
//    public ItemShipmentInfo getShipmentUsed () { return this.shipmentUsed; }
//    
//    public void setShipmentUsed (ItemShipmentInfo _shipment)
//    {
//        this.shipmentUsed = _shipment;
//    }
//
//    public void resetAttributes ()
//    {
//        deliveryOrder = null;
//        item = null;
//        qty = 0.0;
//        serialNoS100 = "";
//        shipmentUsed = null ;
//    }
//
//  
//    public Object getGeneratedUniqueData ()
//    {
//        throw new UnsupportedOperationException ("Not supported yet.");
//    }
//}
