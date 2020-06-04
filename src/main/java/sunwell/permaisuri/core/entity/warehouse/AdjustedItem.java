///*
// * @File : AdjustedItem.java	@Date : Sep 25, 2007, 12:07:04 AM
// *
// * Copyright 2007 Latifolia Technologies, PT. All Rights Reserved.
// * LATIFOLIA PROPRIETARY/CONFIDENTIAL.
// */
//package sunwell.permaisuri.core.entity.warehouse;
//
//
//import java.sql.*;
//import java.util.Calendar;
//import javax.persistence.*;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
///**
// *
// * @author Irfin A
// * @version 1.0 - Sep 25, 2007 ; initial version
// * @version 1.2 - Mar 23, 2011 ; penambahan field `balance`.
// */
//@Entity
//@Table( name = "adjusteditem" )
//@IdClass( AdjustedItemPK.class )
//public class AdjustedItem 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_stockadjust")
//    private StockAdjustment m_stockAdj;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product")
//    private Item m_item;
//    
//    /** jml quantity penyesuaian dalam satuan inventory. */
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Column( name = "serialno_s100" )
//    private String m_serialno_s100;
//    
//    @Column( name = "batch_no" )
//    private String m_batchNo ;
//    
//    @Column( name = "str_expiry_date" )
//    private String m_str_expiry_date ; 
//    
//    @Transient
//    private Calendar m_expiry_date;
//    
//    /** Unit price yg digunakan pada penyesuaian ini */
//    @Column( name = "unit_price" )
//    private double m_unit_price = 0;
//    
//    @Column( name = "balance" )
//    private double m_balance;
//    
//    
//    public AdjustedItem ()
//    {
//        m_stockAdj = null;
//        m_item = null;
//        m_serialno_s100 = "";
//        m_batchNo = "" ;
//        m_unit_price = 0;
//        m_expiry_date = null;
//    }
//
//    public Calendar getExpiryDate () { return m_expiry_date; }
//
//    /**
//     *
//     * @param _expDate can be set to null.
//     */
//    public void setExpiryDate (Calendar _expDate)
//    {
//        this.m_expiry_date = _expDate;
//        if(_expDate != null)
//            m_str_expiry_date = _expDate.toString();
//        else 
//            m_str_expiry_date = "";
//    }
//    
//    public double getQty () { return m_qty; }
//
//    /** 
//     * Set unit price yg digunakan utk item ini 
//     * @param m_qty
//     */
//    public void setQty (double m_qty)
//    {
//        this.m_qty = m_qty;
//    }
//    
//    public double getUnitPrice () { return m_unit_price; }
//    
//    public void setUnitPrice (double _unitPrice)
//    {
//        this.m_unit_price = _unitPrice;
//    }
//
//    public String getSerialNo () { return m_serialno_s100; }
//
//    public void setSerialNo (String _sn)
//    {
//        this.m_serialno_s100 = (_sn != null) ? _sn : "";
//    }
//    
//    public String getBatchNo () { return m_batchNo; }
//
//    public void setBatchNo (String _batch)
//    {
//        this.m_batchNo = (_batch != null) ? _batch : "";
//    }
//
//    public StockAdjustment getAdjustment () { return m_stockAdj; }
//
//    public void setAdjustment (StockAdjustment m_stockAdj)
//    {
//        this.m_stockAdj = m_stockAdj;
//    }
//
//    public double getBalance () { return m_balance; }
//
//    public void setBalance (double _d)
//    {
//        m_balance = _d;
//    }
//
//    public Item getItem () { return m_item; }
//
//    public void setItem (Item m_item)
//    {
//        this.m_item = m_item;
//    }
//}
