///*
// * @File : ItemTransferStok.java	@Date : Des 12, 2007, 12:07:04 AM
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
// */
//@Entity
//@Table( name = "itemtransferstok" )
//@IdClass( ItemTransferStokPK.class )
//public class ItemTransferStok 
//{
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_transfer" )
//    private TransferStok m_transferStok;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item m_item;
//    
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Column( name = "serialno_s100" )
//    private String m_serialno_s100;
//    
//    @Column( name = "str_expiry_date" )
//    private String m_str_exp_date ;
//    
//    @Transient
//    private Calendar m_expiry_date;
//
//    /** Objek Statement yg bsifat static utk efisiensi proses insert yg mungkin
//     *   tjadi berkali2x dlm waktu yg bdekatan. */
//    private static Statement m_stmt = null;
//
//    static {
//        m_stmt = null;
//    }
//
//
//    /**
//     * @roseuid 45C7F94701D2
//     */
//    public ItemTransferStok ()
//    {
//        m_serialno_s100 = "";
//        m_expiry_date = null;
//    }
//
//    public Calendar getExpiryDate () { return m_expiry_date; }
//
//    public void setExpiryDate (Calendar _c)
//    {
//        this.m_expiry_date = _c;
//        m_str_exp_date = _c.toString();
//    }
//
//    public double getQty ()
//    {
//        return m_qty;
//    }
//
//    public void setQty (double m_qty)
//    {
//        this.m_qty = m_qty;
//    }
//
//    public String getSerialNo ()
//    {
//        return m_serialno_s100;
//    }
//
//    public void setSerialNo (String _serialno_s100)
//    {
//        if (_serialno_s100 == null)
//            this.m_serialno_s100 = "";
//        else
//            this.m_serialno_s100 = _serialno_s100;
//    }
//
//    public TransferStok getTransferStok ()
//    {
//        return m_transferStok;
//    }
//
//    public void setTransferStok (TransferStok m_transferStok)
//    {
//        this.m_transferStok = m_transferStok;
//    }
//
//    public Item getItem ()
//    {
//        return m_item;
//    }
//
//    public void setItem (Item m_item)
//    {
//        this.m_item = m_item;
//    }
//}
