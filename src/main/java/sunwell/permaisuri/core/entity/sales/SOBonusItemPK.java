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
//public class SOBonusItemPK implements Serializable
//{
//    int salesOrder ;
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
//    public int getSalesOrder ()
//    {
//        return salesOrder;
//    }
//
//    public void setSO (int _so)
//    {
//        this.salesOrder = _so;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
////        hash += salesOrder != null ? salesOrder.hashCode() : 0;
////        hash += item != null ? item.hashCode() : 0;
//        hash += salesOrder ;
//        hash += item ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SOBonusItemPK)) {
//            return false;
//        }
//        SOBonusItemPK other = (SOBonusItemPK) object;
////        if (this.salesOrder != other.salesOrder)
////            return false;
////        if (this.item != other.item)
////            return false;
//        
////        if ((this.salesOrder == null && other.salesOrder != null) || 
////            (this.salesOrder != null && !this.salesOrder.equals(other.salesOrder))) {
////            return false;
////        }
////        
////        if ((this.item == null && other.item != null) || 
////            (this.item != null && !this.item.equals(other.item))) {
////            return false;
////        }
//        
//        if(salesOrder != other.salesOrder)
//        	return false;
//        
//        if(item != other.item)
//        	return false;
//        
//        return true;
//    }
//}