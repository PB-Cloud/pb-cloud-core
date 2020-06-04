///*
// * StockReservation.java
// *
// * Created on October 17, 2008, 06:47 AM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.sql.*;
//import java.util.*;
//import javax.persistence.*;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.cred.UserCredential;
//import sunwell.permaisuri.core.entity.warehouse.Gudang;
//
///**
// * Merepresentasikan kegiatan reservasi stok untuk suatu sales order. Reservasi 
// * stok dilakukan dengan mengambil stok on-hand pada gudang X, dan menyimpannya 
// * juga pada gudang X. (Gudang X = m_rsrvdWH)
// * 
// * @author Irfin A
// * @version 1.0 - Oct 17, 2008 ; initial version
// * @version 1.3 - Apr 13, 2010 ; perubahan interface dari PersistentObject ke
// *                      EntityObject dan ITraceableBusinessObject
// */
//@Entity
//@Table (name = "stockreservation")
//public class StockReservation 
//{
//    
//    public static final int DELIVERY_PARTIAL_OR_NONE = 0;
//    public static final int DELIVERY_FULL = 1;
//    /** PRIMARY KEY ; auto-increment */
//    @Id
//    @Column( name = "id_stockrsrv" )
//    @SequenceGenerator (name = "stockreservation_id_stockrsrv_seq", sequenceName = "stockreservation_id_stockrsrv_seq", allocationSize = 1)
//    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "stockreservation_id_stockrsrv_seq")
//    private int systemId;
//    
//    @NotNull(message="{error_no_so}")
//    @ManyToOne
//    @JoinColumn( name = "id_so" )
//    private SalesOrder salesOrder;
//    
//    @NotNull(message="{error_no_warehouse}")
//    @ManyToOne
//    @JoinColumn( name = "id_gudang" )
//    private Gudang rsrvdWH;
//    
//    @ManyToOne
//    @JoinColumn( name = "sys_creator" )
//    private UserCredential sysCreator;
//    
//    @ManyToOne
//    @JoinColumn( name = "sys_updater" )    
//    private UserCredential sysUpdater;
//    
//    @OneToMany( mappedBy = "stockReservation", cascade=CascadeType.ALL, fetch=FetchType.EAGER )
//    private List<ItemStockReservation> items ;
//    
//    @Column( name = "reservation_datetime" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)      
//    private Calendar reservationDate;
//    
//    @Column( name = "sys_createdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP) 
//    private Calendar sysCreateDate;
//    
//    @Column( name = "sys_lastupdate" )
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP) 
//    private Calendar sysUpdateDate;
//    
//    @Column( name = "memo" )
//    private String memo;
//    
//    @Column( name = "fullydelivered" )
//    private int deliveryStatus = DELIVERY_PARTIAL_OR_NONE ;
//    
//
//    public StockReservation ()
//    {
//        this (-1);
//    }
//
//    public StockReservation (int _id)
//    {
//        systemId = _id;
//    }
//
//    public int getsystemId () { return systemId; }
//
//    public void setSystemId (int _id_stockrsrv)
//    {
//        this.systemId = _id_stockrsrv;
//    }
//    
//    public int getDeliveryStatus () { return deliveryStatus; }
//
//    public void setDeliveryStatus (int _status)
//    {
//        this.deliveryStatus = _status;
//    }
//   
//    public void setSalesOrder (SalesOrder _so)
//    {
//        this.salesOrder = _so;
//    }
//    
//    public Gudang getWarehouse () { return rsrvdWH; }
//    
//    public void setWarehouse (Gudang _g)
//    {
//        this.rsrvdWH = _g;
//    }
//    
//    public Calendar getReservationDatetime () { return reservationDate; }
//
//    public void setReservationDatetime (Calendar m_reservation_datetime)
//    {
//        this.reservationDate = m_reservation_datetime;
//    }
//
//    public String getMemo () { return memo; }
//
//    public void setMemo (String _txt)
//    {
//        this.memo = (_txt != null) ? _txt : "";
//    }
//    
//    public void setReservedItems (List<ItemStockReservation> _items)
//    {
//        items = _items;
//    }
//    
//    public List<ItemStockReservation> getReservedItems () 
//    { 
//        return items; 
//    }
//    
//    public int getReservedItemsCount ()
//    {
//    
//        return (this.items != null) ? this.items.size() : 0;
//    }
//    
//    /**
//     * @param _idx Index elemen dimulai dari 0, 1, 2 ... n
//     * @return
//     */
//    public ItemStockReservation getReservedItemAt (int _idx)
//    {
//        return items != null ? items.get(_idx) : null;
//    }
//    
//    public UserCredential getSysCreator()
//    {
//        return sysCreator;
//    }
//
//    public void setSysCreator (UserCredential _boCreator)
//    {
//        sysCreator = _boCreator;
//    }
//
//    public Calendar getSysCreateDate () { return sysCreateDate; }
//
//    public void setSysCreateDate (Calendar _c)
//    {
//        sysCreateDate = _c;
//    }
//
//    public UserCredential getSysUpdater ()
//    {
//        return sysUpdater;
//    }
//
//    public void setSysUpdater (UserCredential _e)
//    {
//        sysUpdater = _e;
//    }
//
//    public Calendar getSysUpdateDate() { return sysUpdateDate; }
//
//    public void setSysUpdateDate (Calendar _c)
//    {
//        sysUpdateDate = _c;
//    }
//   
//    public void resetAttributes ()
//    {
//        systemId = -1;
//        salesOrder = null;
//        rsrvdWH = null;
//        memo = "";
//        deliveryStatus = 0 ;
//    }
//
//}
