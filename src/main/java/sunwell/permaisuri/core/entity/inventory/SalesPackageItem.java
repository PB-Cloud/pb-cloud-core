///*
// * @File : SalesItem.java	Created on March 17, 2007, 4:27 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY & CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.sql.*;
//
//import javax.persistence.*;
//
//
///**
// *
// * @version 1.0 - March 17, 2007 ; initial version
// * @version 2.0 - March 8, 2010 ; perubahan interface ke EntityObject, dihapusnya
// *                  secara permanen atribut `m_disc`.
// * @version 2.5 - May 2, 2010 ; penambahan atribut 'no_urut'.
// *
// * @author Benny
// * @author Daisy
// */
//@Entity
//@Table( name = "salespackageitem" )
//@IdClass( SalesPackageItemPK.class )
//public class SalesPackageItem 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_sp" )
//    private SalesPackage m_salesPackage;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Product m_product;
//    
//    @ManyToOne
//    @JoinColumn( name = "shipmentused" )
//    private ItemShipmentInfo m_shipmentUsed = null;
//    
//    @Id
//    @Column( name = "serialno_s100" )
//    private String m_serialno_s100;
//    
//    @Id
//    @Column( name = "no_urut" )
//    private int m_no_urut;
//    
//    /** Qty. dalam satuan/metrik inventory */
//    @Column( name = "qty" )
//    private double m_qty;
//        
//    @Column( name = "harga_jual" )
//    private double m_harga_jual;
//    
//
//    private boolean m_isPopulatedFromDB = false;
//
//    public static PreparedStatement m_psBatchInsert = null;
//    /** Objek Statement yg digunakan utk efisiensi proses penyimpanan ke DB. */
//    private static PreparedStatement m_prepStmt = null;
//
//    /** Creates a new instance of SalesItem */
//    public SalesPackageItem ()
//    {
//        m_salesPackage = null;
//        m_serialno_s100 = "";
//        m_no_urut = 0;
//        m_shipmentUsed = null ;
//    }
//
//    @Override
//    protected void finalize ()
//    {
//        if (m_prepStmt != null) {
//            try {
//                m_prepStmt.close ();
//            }
//            catch (SQLException e) { }
//            m_prepStmt = null;
//        }
//    }
//
//    public SalesPackage getSalesPackage ()
//    {
//        return m_salesPackage;
//    }
//
//    public void setSalesPackage (SalesPackage _salesPackage)
//    {
//        this.m_salesPackage = _salesPackage;
//    }
//
//    /**
//     * Set nilai qty. dalam satuan/metrik utk inventory
//     */
//    public void setQty (double _qty_in_MetricInv)
//    {
//        this.m_qty = _qty_in_MetricInv;
//    }
//
//    /**
//     * Mengembalikan nilai qty dalam satuan/metrik utk inventory
//     */
//    public double getQty ()
//    {
//        return m_qty;
//    }
//
//    public String getSerialNo ()
//    {
//        return m_serialno_s100;
//    }
//
//    public void setSerialNo (String _sn_s100)
//    {
//        this.m_serialno_s100 = (_sn_s100 != null) ? _sn_s100 : "";
//    }
//
//    /**
//     * Utk keperluan internal database
//     * @return
//     */
//    public int getNoUrut () { return m_no_urut; }
//
//    /**
//     * Utk keperluan internal database
//     * @param _noUrut
//     */
//    public void setNoUrut (int _noUrut)
//    {
//        m_no_urut = _noUrut;
//    }
//
//    public double getHargaJual ()
//    {
//        return m_harga_jual;
//    }
//
//    public void setHargaJual (double m_harga_jual)
//    {
//        this.m_harga_jual = m_harga_jual;
//    }
//
//    public Product getProduct ()
//    {
//        return m_product;
//    }
//
//    public void setProduct (Product _product)
//    {
//        this.m_product = _product;
//    }
//    
//    public ItemShipmentInfo getShipmentUsed ()
//    {
//        return m_shipmentUsed;
//    }
//
//    public void setShipmentUsed (ItemShipmentInfo _shipment)
//    {
//        this.m_shipmentUsed = _shipment;
//    }
//    
//    /**
//     *
//     * @param obj
//     * @return
//     */
//    @Override
//    public boolean equals (Object obj)
//    {
//        if(obj instanceof SalesPackageItem)
//        {
//            SalesPackageItem i = (SalesPackageItem)obj;
//            return (i.m_product.getSystemId () == m_product.getSystemId ()) && (m_serialno_s100.equals (i.m_serialno_s100) )
//                    && (i.m_salesPackage.getSystemId () == m_salesPackage.getSystemId ()) && (i.m_no_urut == m_no_urut);
//        }
//        return false;
//    }
//}
