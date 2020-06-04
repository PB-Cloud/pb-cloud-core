///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// * ItemPOPK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//
//package sunwell.permaisuri.core.entity.sales;
//
//import java.io.Serializable;
//
///**
// *
// * @author Benny
// */
//
//public class ItemDOPK implements Serializable
//{
//    int deliveryOrder ;
//    int item ;
//    
//    public Integer getItem ()
//    {
//        return item;
//    }
//
//    public void setItem (int _itemid)
//    {
//        this.item = _itemid;
//    }
//
//    public int getDeliveryOrder ()
//    {
//        return deliveryOrder;
//    }
//
//    public void setDeliveryOrder (int _si )
//    {
//        this.deliveryOrder = _si;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
////        hash += deliveryOrder != null ? deliveryOrder.hashCode() : 0;
////        hash += item != null ? item.hashCode() : 0 ;
//        hash += deliveryOrder ;
//        hash += item ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ItemDOPK)) {
//            return false;
//        }
//        ItemDOPK other = (ItemDOPK) object;
//        
////        if (this.deliveryOrder != other.deliveryOrder)
////            return false;
////        if (this.item != other.item)
////            return false;
//        
////        if ((this.deliveryOrder == null && other.deliveryOrder != null) || 
////            (this.deliveryOrder != null && !this.deliveryOrder.equals(other.deliveryOrder))) {
////            return false;
////        }
////        
////        if ((this.item == null && other.item != null) || 
////            (this.item != null && !this.item.equals(other.item))) {
////            return false;
////        }
//        
//        if(deliveryOrder != other.deliveryOrder)
//        	return false;
//        
//        if(item != other.item)
//        	return false;
//        
//        
//        return true;
//    }
//}