///*
// * SalesPackageLine.java
// *
// * Created on Aug 21, 2014, 12:41:46 PM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.io.Serializable;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
///**
// *
// * @author Benny
// */
//@IdClass(SalesPackageServicePK.class)
//@Entity
//@Table(name="salespackagelineservice")
//public class SalesPackageLineService 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_sp" )
//    private SalesPackage m_salesPackage;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_svc" )
//    private Service m_service;
//    
//    @Id
//    @Column( name = "no_urut" )
//    private int m_no_urut;
//    
//    @Column(name="qty")
//    private double m_qty;
//    
//    @Column(name="memo")
//    private String m_memo;
//    private boolean m_isPopulated;
//
//    public SalesPackage getOwner ()
//    {
//        return m_salesPackage;
//    }
//
//    public void setOwner (SalesPackage _owner)
//    {
//        this.m_salesPackage = _owner;
//    }
//
//    public Service getService ()
//    {
//        return m_service;
//    }
//
//    public void setService (Service _service)
//    {
//        this.m_service = _service;
//    }
//    
//    public int getNoUrut () { return m_no_urut; }
//
//    public void setNoUrut (int _urut)
//    {
//        m_no_urut = _urut;
//    }
//
//    public double getQty ()
//    {
//        return m_qty;
//    }
//
//    public void setQty (double _qty)
//    {
//        this.m_qty = _qty;
//    }
//
//    public String getMemo ()
//    {
//        return m_memo;
//    }
//
//    public void setMemo (String _memo)
//    {
//        this.m_memo = _memo;
//    }
//    
//    
//    @Override
//    public boolean equals (Object _obj)
//    {
//        return false ;
////        try{
////            if(_obj instanceof SalesPackageServicePK)
////            {
////                SalesPackageServicePK other = (SalesPackageServicePK) _obj;
//////                if(other.getService () == m_salesPackage.getID () && other.getService () == m_service.getID ())
////                    return true;
////                else
////                    return false;
////            }
////            else if(_obj instanceof  SalesPackageLineService)
////            {
////                SalesPackageLineService other = (SalesPackageLineService) _obj;
////                if(other.getOwner ().getID () == m_salesPackage.getID () && other.getService ().getID () == m_service.getID ())
////                    return true;
////                else
////                    return false;
////            }
////        }
////        catch(NullPointerException ex)
////        {
////            return false;
////        }
////        
////        return false;
//    }
//    
//    
//}
