///*
// * @File : SalesService.java	@Date : May 3, 2010, 5:00:31 PM
// * 
// * Copyright 2010 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.io.Serializable;
//
//
//import java.sql.*;
//import java.util.Objects;
//import javax.persistence.*;
//
//
///**
// *
// * @author Benny
//  */
//@Entity
//@Table( name = "salespackageservice" )
//@IdClass( SalesPackageServicePK.class )
//public class SalesPackageService 
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
//    @Column( name = "qty" )
//    private double m_qty;
//    
// 
//    @Column( name = "harga_jual" )
//    private double m_harga_jual;
//
//    /** objek PreparedStatement utk efisiensi proses insert ke DB */
//    public static PreparedStatement m_psBatchInsert = null;
//    private boolean m_populatedFromDB = false;
//
//    public SalesPackageService ()
//    {
//        m_salesPackage = null;
//        m_no_urut = 0;
//        m_service = null;
//        m_harga_jual = 0 ;
//        
//        m_populatedFromDB = false;
//    }
//
//    protected void finalize ()
//    {
//        if (m_psBatchInsert != null) {
//            try {
//                m_psBatchInsert.close ();
//            }
//            catch (SQLException t) {}
//            m_psBatchInsert = null;
//        }
//    }
//
//    public SalesPackage getSalesPackage () { return m_salesPackage; }
//
//    public void setSalesPackage (SalesPackage _pack)
//    {
//        m_salesPackage = _pack;
//    }
//
//    public Service getService () { return m_service; }
//
//    public void setService (Service _svc)
//    {
//        m_service = _svc;
//    }
//
//    public double getQty () { return m_qty; };
//
//    public void setQty (double _qty)
//    {
//        m_qty = _qty;
//    }
//
//    public int getNoUrut () { return m_no_urut; }
//
//    public void setNoUrut (int _urut)
//    {
//        m_no_urut = _urut;
//    }
//
//    public double getHargaJual () { return m_harga_jual; }
//
//    public void setHargaJual (double _harga)
//    {
//        m_harga_jual = _harga;
//    }
//
//
//    @Override
//    public int hashCode ()
//    {
//        int hash = 7;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object obj)
//    {
//        if (obj == null)
//            return false;
//        if (getClass () != obj.getClass ())
//            return false;
//        
//        final SalesPackageService other = (SalesPackageService) obj;
//        if (!this.m_salesPackage.equals (other.m_salesPackage))
//            return false;
//        if (this.m_service.getSystemId () != other.getService ().getSystemId ())
//            return false;
//        if (this.m_no_urut != other.m_no_urut)
//            return false;
//        
//        return true;
//    }
//}
