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
//public class ItemSalesReturnPK implements Serializable
//{
//    int salesReturn ;
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
//    public int getSalesReturn ()
//    {
//        return salesReturn;
//    }
//
//    public void setSalesReturn (int _poid)
//    {
//        this.salesReturn = _poid;
//    }
//    
//    
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
////        hash += salesReturn != null ? salesReturn.hashCode() : 0;
////        hash += item != null ? item.hashCode() : 0;
//        hash += salesReturn ;
//        hash += item;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ItemSalesReturnPK)) {
//            return false;
//        }
//        ItemSalesReturnPK other = (ItemSalesReturnPK) object;
////        if (this.salesReturn != other.salesReturn)
////            return false;
////        if (this.item != other.item)
////            return false;
//        
////        if ((this.salesReturn == null && other.salesReturn != null) || 
////            (this.salesReturn != null && !this.salesReturn.equals(other.salesReturn))) {
////            return false;
////        }
////        
////        if ((this.item == null && other.item != null) || 
////            (this.item != null && !this.item.equals(other.item))) {
////            return false;
////        }
//        
//        if(salesReturn != other.salesReturn)
//        	return false;
//        
//        if(item != other.item)
//        	return false;
//       
//        return true;
//    }
//}