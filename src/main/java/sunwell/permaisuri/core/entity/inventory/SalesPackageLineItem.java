///*
// * SalesPackageLineItem.java
// *
// * Created on Aug 21, 2014, 12:41:46 PM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.sql.PreparedStatement;
//
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
//import javax.persistence.Transient;
//
///**
// *
// * @author irfin
// */
//@IdClass(SalesPackageItemPK.class)
//@Entity
//@Table(name="salespackagelineitem")
//public class SalesPackageLineItem 
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
//    @Id
//    @Column( name = "serialno_s100" )
//    private String m_serialno_s100;
//    
//    @Id
//    @Column( name = "no_urut" )
//    private int m_no_urut;
//    
//    @JoinColumn(name="metric")
//    @ManyToOne
//    private Metrics m_metric;
//    
//    @Column(name="qty")
//    private double m_qty;
//    
//    @Column(name="memo")
//    private String m_memo;
//    
//    @Transient
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
//    public Product getItem ()
//    {
//        return m_product;
//    }
//
//    public void setItem (Product _item)
//    {
//        this.m_product = _item;
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
//    public Metrics getMetric ()
//    {
//        return m_metric;
//    }
//
//    public void setMetric (Metrics _metric)
//    {
//        this.m_metric = _metric;
//    }
//    
//   
//    
//    @Override
//    public boolean equals (Object _obj)
//    {
//        if (_obj instanceof SalesPackageLineItem)
//        {
//            SalesPackageLineItem that = (SalesPackageLineItem) _obj;
//            if (this.getItem ().getSystemId () == that.getItem ().getSystemId () &&
//                this.getOwner ().equals (that.getOwner ()))
//                return true;
//            else
//                return false;
//        }
//        else
//            return false;
//    }
//}
