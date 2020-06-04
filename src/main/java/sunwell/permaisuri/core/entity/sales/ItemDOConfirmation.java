///*
// * ItemDOConfirmation.java
// *
// * Created on December 3, 2008, 3:45 PM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.sql.*;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
///**
// *
// * @author Irfin A
// * @version 1.0 - Dec 3, 2008 ; initial version
// * @version 1.3 - Mar 21, 2010 ; perubahan interface dari PersistentObject ke
// *                  EntityObject.
// */
//@Entity
//@Table( name = "itemdoconfirmation" )
//@IdClass(ItemDOConfirmationPK.class)
//public class ItemDOConfirmation 
//{
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_do" )
//    private DeliveryOrderConfirmation m_doc = null;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item m_item = null;
//    
//    @Column( name = "qty_confirmed" )
//    private double m_qty_confirmed = 0;
//
//    public ItemDOConfirmation ()
//    {
//    }
//
//    protected void setDelivOrderConfirmation (DeliveryOrderConfirmation _parent)
//    {
//        m_doc = _parent;
//    }
//
//    public DeliveryOrderConfirmation getDeliveryOrderConfirmation ()
//    {
//        return m_doc;
//    }
//
//    public void setItem (Item _item)
//    {
//        m_item = _item;
//    }
//
//    public Item getItem () { return m_item; }
//
//    public void setQtyConfirmed (double _qty)
//    {
//        m_qty_confirmed = _qty;
//    }
//
//    public double getQtyConfirmed () { return m_qty_confirmed; }
//
//    public void resetAttributes ()
//    {
//        m_doc = null;
//        m_item = null;
//        m_qty_confirmed = 0;
//    }    
//}
