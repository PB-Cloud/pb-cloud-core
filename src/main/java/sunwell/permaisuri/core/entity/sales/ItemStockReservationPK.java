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
//public class ItemStockReservationPK implements Serializable
//{
//    int stockReservation ;
//    int item ;
//    
//    public int getItem ()
//    {
//        return item;
//    }
//
//    public void setItem (int _itemid)
//    {
//        this.item = _itemid;
//    }
//
//    public int getStockReservation ()
//    {
//        return stockReservation;
//    }
//
//    public void setStockReservation (int _si )
//    {
//        this.stockReservation = _si;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
////        hash += stockReservation != null ? stockReservation.hashCode() : 0;
////        hash += item != null ? item.hashCode() : 0 ;
//        hash += stockReservation ;
//        hash += item;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ItemStockReservationPK)) {
//            return false;
//        }
//        ItemStockReservationPK other = (ItemStockReservationPK) object;        
//        
////        if (this.stockReservation != other.stockReservation)
////            return false;
////        if (this.item != other.item)
////            return false;
//        
////        if ((this.stockReservation == null && other.stockReservation != null) || 
////            (this.stockReservation != null && !this.stockReservation.equals(other.stockReservation))) {
////            return false;
////        }
////        
////        if ((this.item == null && other.item != null) || 
////            (this.item != null && !this.item.equals(other.item))) {
////            return false;
////        }
//        
//        if(stockReservation != other.stockReservation)
//        	return false;
//        
//        if(item != other.item)
//        	return false;
//        
//        return true;
//    }
//}