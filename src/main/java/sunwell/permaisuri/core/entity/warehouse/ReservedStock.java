///*
// * ReservedStock.java
// *
// * Created on December 14, 2007, 02:29 AM
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
// * @author Benny
// * 
// * @version 1.0 14 Dec 2007
// * @version 1.5 6 Jan 2015 ; tambahan atribut untuk no batch, expire date dan no seri
// */
//@Entity
//@IdClass(ReservedStockPK.class)
//@Table(name="onhandstok")
//public class ReservedStock
//{
//    /** ID/Primary Key dari objek StockReservation yg disimpan oleh objek ini */
//    @Id
//    @Column( name = "id_stockrsrv" )
//    private int m_id_stockRsrv;
//    
//    @Column( name = "qty" )
//    private double m_qty;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_roduct" )
//    private Item m_item;
//    
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang m_gudang;
//    
//    @Id
//    @Column( name = "str_expiry_date" )
//    private String m_str_exp_date ;
//    
//    @Transient
//    private Calendar m_expiry_date = null;
//    
//    @Id
//    @Column( name = "batch_no" )
//    private String m_batchNo = "" ;
//    
//    @Id
//    @Column( name = "serialno_s100" )
//    private String m_serialNo = "" ;
//    
//    @Id
//    @Column( name = "source_ref_type" )
//    private int m_source_ref_type;
//    
//    @Id
//    @Column( name = "source_ref_id" )
//    private int m_source_ref_id;
//    //private StockReservation m_stockRsrv;
//    
//    
//    public ReservedStock ()
//    {
//        m_qty = 0;
//        m_item = null;
//        m_gudang = null;
//        m_id_stockRsrv = -1;
//    }
//    
//    public double getQty () { return m_qty; }
//    
//    public void setQty (double _qty)
//    {
//        this.m_qty = _qty;
//    }
//    
//    public String getBatchNo () { return m_batchNo; }
//    
//    public void setBatchNo (String _batchNo)
//    {
//        this.m_batchNo = _batchNo;
//    }
//    
//    public String getSerialNo () { return m_serialNo; }
//    
//    public void setSerialNo (String _serialNo)
//    {
//        this.m_serialNo = _serialNo;
//    }
//    
//    
//    public Item getItem () { return m_item; }
//    
//    public void setItem (Item _item)
//    {
//        this.m_item = _item;
//    }
//    
//    public Gudang getWarehouse () { return m_gudang; }
//    
//    public void setWarehouse (Gudang _gdg)
//    {
//        this.m_gudang = _gdg;
//    }
//    
//    public int getStockReservationID () { return m_id_stockRsrv; }
//    
//    public void setStockReservationID (int _idThatYouWontLie)
//    {
//        this.m_id_stockRsrv = _idThatYouWontLie;
//    }
//
//    public void setExpiryDate (Calendar _c)
//    {
//        m_expiry_date = _c;
//        m_str_exp_date = _c.toString();
//     }
//
//    public Calendar getExpiryDate () { return m_expiry_date; }
//
//    public void setSourceRefType (int _type)
//    {
//        m_source_ref_type = _type;
//    }
//
//    public int getSourceRefType () { return m_source_ref_type; }
//
//    public void setSourceRefId (int _refid)
//    {
//        m_source_ref_id = _refid;
//    }
//
//    public int getSourceRefId () { return m_source_ref_id; }
//}
