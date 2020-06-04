///*
// * @File : ctrl_medicalAllergyCRUD.java	@Date : Jan 07, 2010, 04:15:03 PM
// *
// * Copyright 2009 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.sql.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
///**
// *
// * @author Irfin A
// * 
// * @version ... 2017-03-20 : add override method toString()
// */
//@Entity
//@Table(name = "service")
//public class Service extends Product
//{
//	@Column(name = "service_code")
//	private String serviceCode = null;
//
//	@Column(name = "instruction")
//	private String instruction = null;
//
//	@JoinColumn(name = "category_id", referencedColumnName = "systemid")
//	@ManyToOne
//	private ServiceCategory category = null;
//
//	public Service ()
//	{
//		setDtype("Service");
//	}
//
//	public Service (int _id)
//	{
//		super(_id);
//		setDtype("Service");
//	}
//
//	public String getServiceCode ()
//	{
//		return serviceCode;
//	}
//
//	public void setServiceCode (String _code)
//	{
//		serviceCode = _code;
//	}
//
//	public String getInstruction ()
//	{
//		return instruction;
//	}
//
//	public void setInstruction (String _notes)
//	{
//		instruction = (_notes != null) ? _notes : "";
//	}
//
//	public ServiceCategory getCategory ()
//	{
//		return category;
//	}
//
//	public void setCategory (ServiceCategory _sc)
//	{
//		category = _sc;
//	}
//
////	public int hashCode ()
////	{
//////		return getSystemId() != null ? getSystemId().hashCode() : 0;
////		return systemId;
////	}
////
////	@Override
////	public boolean equals (Object obj)
////	{
////		if (obj == null)
////			return false;
////		if (!(obj instanceof Service)) {
////			return false;
////		}
////
////		Service other = (Service) obj;
////		if ((this.getSystemId() == null && other.getSystemId() != null)
////				|| (this.getSystemId() != null && !this.getSystemId().equals(other.getSystemId()))) {
////			return false;
////		}
////		return true;
////	}
//
//	@Override
//	public String toString ()
//	{
//		return getName() + " [" + this.serviceCode + "] ";
//	}
//}
