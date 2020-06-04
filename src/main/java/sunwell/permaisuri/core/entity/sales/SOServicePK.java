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
//public class SOServicePK implements Serializable
//{
//    int salesOrder ;
//    int service ;
//    
//    public Integer getService ()
//    {
//        return service;
//    }
//
//    public void setService (int _service)
//    {
//        this.service = _service;
//    }
//
//    public int getSalesOrder ()
//    {
//        return salesOrder;
//    }
//
//    public void setSalesOrder (int _so)
//    {
//        this.salesOrder = _so;
//    }
//    
//    
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
////        hash += salesOrder != null ? salesOrder.hashCode() : 0;
////        hash += service != null ? service.hashCode() : 0;
//        hash += salesOrder ;
//        hash += service ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SOServicePK)) {
//            return false;
//        }
//        
//        SOServicePK other = (SOServicePK) object;
//        
////        if (this.salesOrder != other.salesOrder)
////            return false;
////        if (this.service != other.service)
////            return false;
//        
////        if ((this.salesOrder == null && other.salesOrder != null) || 
////            (this.salesOrder != null && !this.salesOrder.equals(other.salesOrder))) {
////            return false;
////        }
////        
////        if ((this.service == null && other.service != null) || 
////            (this.service != null && !this.service.equals(other.service))) {
////            return false;
////        }
//        
//        if(salesOrder != other.salesOrder)
//        	return false;
//        
//        if(service != other.service)
//        	return false;
//       
//        return true;
//    }
//}