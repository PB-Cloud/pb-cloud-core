///*
// * SalesPerson.java
// *
// * Created on May 8, 2015, 13:39
// */
//package sunwell.permaisuri.core.entity.hr;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
///**
// *
// * @author Daisy
// */
//@Entity
//@Table(name = "salesperson")
//@NamedQueries({
//    @NamedQuery(name = "SalesPerson.findAll", query = "SELECT s FROM SalesPerson s"),
//    @NamedQuery(name = "SalesPerson.findBySystemid", query = "SELECT s FROM SalesPerson s WHERE s.systemId = :systemid"),
//    @NamedQuery(name = "SalesPerson.findBySalesArea", query = "SELECT s FROM SalesPerson s WHERE s.salesArea = :salesArea")
//})
//public class SalesPerson extends Employee implements Serializable
//{
//    private static final long serialVersionUID = 1L;
//    
//    @Column(name = "sales_area")
//    private String salesArea;
//    
//    public SalesPerson() 
//    {
//    }
//    
//    public SalesPerson(long _id) 
//    {
//    	super(_id);
//    }
//
//    public SalesPerson(Long systemid) 
//    {
//        super(systemid);
//    }
//    
//    public String getSalesArea() 
//    {
//        return salesArea;
//    }
//
//    public void setSalesArea(String salesArea) 
//    {
//        this.salesArea = salesArea;
//    }
//    
////    @Override
////    public int hashCode ()
////    {
////        return getSystemId() != null ? getSystemId().hashCode() : 0;
////    }
////
////    @Override
////    public boolean equals(Object object) 
////    {
////    	if(object == null)
////    		return false;
////        // TODO: Warning - this method won't work in the case the id fields are not set
////        if (!(object instanceof SalesPerson)) {
////            return false;
////        }
////        SalesPerson other = (SalesPerson) object;
////        if ((this.getSystemId() == null && other.getSystemId() != null) || (this.getSystemId() != null && !this.getSystemId().equals(other.getSystemId()))) {
////            return false;
////        }
////        return true;
////    }
//
//    @Override
//    public String toString() 
//    {
//        return getSystemId() + "" ;
//    }
//    
//}
