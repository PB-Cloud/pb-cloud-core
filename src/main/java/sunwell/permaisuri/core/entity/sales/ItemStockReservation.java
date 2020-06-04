///*
// * ItemStockReservation.java
// *
// * Created on October 17, 2008, 08:02 PM
// */
//package sunwell.permaisuri.core.entity.sales;
//
//import java.sql.*;
//import javax.persistence.*;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.inventory.Item;
//
///**
// *
// * @author Irfin A
// * @version 1.0 - Oct 17, 2008 ; initial version
// * @version 1.3 - Apr 13, 2010 ; implementasi interface EntityObject.
// */
//@Entity
//@Table (name = "itemstockreservation")
//@IdClass( ItemStockReservationPK.class )
//public class ItemStockReservation 
//{
//	@NotNull(message="{error_no_sr}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_stockrsrv" )
//    private StockReservation stockReservation;
//    
//	@NotNull(message="{error_no_item}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Item item;
//    
//    @Column( name = "qty" )
//    private double qty = 0.0;
//
//    public ItemStockReservation ()
//    {
//        stockReservation = null;
//    }
//    
//    public ItemStockReservation (StockReservation _sr)
//    {
//        stockReservation = _sr;
//    }
//    
//    public StockReservation getStockRerservation () { return stockReservation; }
//
//    public void setStockReservation (StockReservation m_stockRsrv)
//    {
//        this.stockReservation = m_stockRsrv;
//    }
//
//    public Item getItem () { return item; }
//
//    public void setItem (Item m_item)
//    {
//        this.item = m_item;
//    }
//
//    public double getQty () { return qty; }
//
//    public void setQty (double m_qty)
//    {
//        this.qty = m_qty;
//    }
//}
