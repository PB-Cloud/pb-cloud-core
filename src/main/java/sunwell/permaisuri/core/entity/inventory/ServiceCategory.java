///*
// * @File : ctrl_medicalAllergyCRUD.java	@Date : Jan 07, 2010, 04:15:03 PM
// *
// * Copyright 2009 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.sql.*;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Transient;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.cred.UserGroup;
//
///**
// *
// * @author Irfin 
// */
//@Entity
//@Table(name="servicecategory")
////@NamedQueries({
////    @NamedQuery(name="ServiceCategory.findAll", query="SELECT c FROM ServiceCategory c ORDER BY c.m_name"),
////    @NamedQuery(name="ServiceCategory.findName", query="SELECT c FROM ServiceCategory c WHERE c.m_name = :name")
////})
//public class ServiceCategory 
//{
//    /** Primary key ; auto-increment */
//    @Id
//    @SequenceGenerator (name = "servicecategory_systemid_seq", sequenceName = "servicecategory_systemid_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "servicecategory_systemid_seq" )
//    @Basic(optional = false)
//    @Column(name = "systemid")
//    private int systemId = -1;
//    
//    @NotNull(message="{error_no_name}")
//    @Column(name="name")
//    private String name = null;
//    
//    @Column(name="description")
//    private String description = null;
//
//    public ServiceCategory ()
//    {
//    }
//
//    public ServiceCategory (int _systemid)
//    {
//        systemId = _systemid;
//    }
//
//    public void setSystemId (int _id)
//    {
//        systemId = _id;
//    }
//
//    public int getSystemId () { return systemId; }
//
//    public void setName (String _s)
//    {
//        name = _s;
//    }
//
//    public String getName () { return name; }
//
//    public void setDescription (String _s)
//    {
//        description = (_s != null) ? _s : "";
//    }
//
//    public String getDescription () { return description; }
//    
//    @Override
//    public int hashCode ()
//    {
////        return systemId != null ? systemId.hashCode () : 0;
//    	return systemId;
//    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//    	if(obj == null)
//    		return false;
//        if (!(obj instanceof ServiceCategory)) {
//            return false;
//        }
//        
//        ServiceCategory other = (ServiceCategory) obj;
////        if ((this.systemId == null && other.systemId != null) || 
////            (this.systemId != null && !this.systemId.equals(other.systemId))) {
////            return false;
////        }
////        return true;
//        return systemId == other.systemId;
//    }
//    
//    
//    @Override
//    public String toString() 
//    {
//        return name;
//    }
//}
