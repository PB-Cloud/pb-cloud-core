//package sunwell.permaisuri.core.entity.customer;
//
//
///*
// * CustomerGroup.java
// *
// * created 22 April 2014
// */
//
//import java.io.Serializable;
//
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Query;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
///**
// *
// * @author Daisy
// */
//@Entity
//@Table(name = "customergroup")
//@NamedQueries({
//    @NamedQuery(name="CustomerGroup.findBySystemId", query="SELECT cg FROM CustomerGroup cg WHERE cg.systemId = :sysid"),
//    @NamedQuery(name="CustomerGroup.findByName", query="SELECT cg FROM CustomerGroup cg WHERE cg.name = :name"),
//    @NamedQuery(name="CustomerGroup.findAll", query="SELECT cg FROM CustomerGroup cg ORDER BY cg.name")
//})
//public class CustomerGroup implements Serializable
//{
//    @Id
//    @SequenceGenerator (name = "customergroup_systemid_seq", sequenceName = "customergroup_systemid_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "customergroup_systemid_seq" )
//    @Column (name = "systemid")
//    private long systemId;    
//
//    @NotNull(message="{error_no_name}")
//    @Column (name = "name", unique = true)
//    private String name;
//    
//    @Column (name="addprice")
//    private double addPrice;
//
//    @Column (name = "memo")
//    private String memo;
//
//    public CustomerGroup ()
//    {
//    }
//
//    public CustomerGroup (long _id)
//    {
//        systemId = _id;
//    }
//
//    public long getSystemId ()
//    {
//        return systemId;
//    }
//
//    public void setSystemId (long _systemid)
//    {
//        this.systemId = _systemid;
//    }
//
//    public String getName ()
//    {
//        return name;
//    }
//
//    public void setName (String _groupname)
//    {
//        this.name = _groupname;
//    }
//    
//    public double getAddPrice ()
//    {
//        return addPrice;
//    }
//
//    public void setAddPrice (double _add)
//    {
//        this.addPrice = _add;
//    }
//
//    public String getMemo ()
//    {
//        return memo;
//    }
//
//    public void setMemo (String _memo)
//    {
//        this.memo = _memo;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
////        return getSystemId() != null ? getSystemId().hashCode() : 0;
//    	return (int)systemId;
//    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (obj == null)
//            return false;
//        if (!(obj instanceof CustomerGroup))
//            return false;
//        if (obj == this)
//            return true;
//            
//        Customer other = (Customer) obj;
////        if ((this.getSystemId() == null && other.getSystemId() != null) || 
////            (this.getSystemId() != null && !this.getSystemId().equals(other.getSystemId()))) {
////            return false;
////        }
////        return true;
//        return (systemId == other.getSystemId());
//    }
//
//    @Override
//    public String toString ()
//    {
//        return this.name;
//    }
//}
