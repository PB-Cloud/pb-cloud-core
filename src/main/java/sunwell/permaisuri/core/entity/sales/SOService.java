///*
// * SOLines.java
// *
// * Created on November 18, 2014
// */
//package sunwell.permaisuri.core.entity.sales;
//
//
//import java.sql.*;
//import java.util.Arrays;
//import java.util.List;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//import sunwell.permaisuri.core.entity.inventory.Service;
///**
// *
// * @author Benny
// */
//@Entity
//@Table( name = "soservice" )
//@IdClass(SOServicePK.class)
//public class SOService 
//{
//    @NotNull(message="{error_no_so}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_so")
//    private SalesOrder salesOrder;
//    
//    @NotNull(message="{error_no_service}")
//    @Id
//    @ManyToOne
//    @JoinColumn( name = "id_service")
//    private Service service ;
//    
////    @OneToMany( mappedBy = "soService", cascade = CascadeType.ALL )
////    private List<AppliedSOServiceDiscount> discounts ;
//    
////    @Transient
////    private AppliedSOServiceDiscount[] m_arrDisc;
//    
//    @Column( name = "qty" )
//    private double qty;
//    
//    @Column( name = "harga_jual" )
//    private double hargaJual;
//    
//    
//    /** Creates a new instance of SOItem */
//    public SOService ()
//    {
//        salesOrder = null;
//        service = null;
//    }
//    
//    /** Creates a new instance of exist SOItem */
//    public SOService (SalesOrder _so, Service _service)
//    {
//        salesOrder = _so;
//        service = _service;
//    }
//        
//    public Service getService () { return service; }
//
//    public void setService (Service _service)
//    {
//        this.service = _service;
//    }
//
//    public double getQty () { return qty; }
//
//    public void setQty (double _qty)
//    {
//        this.qty = _qty;
//    }
//
//    public double getHargaJual () { return hargaJual; }
//
//    public void setHargaJual (double _harga_jual)
//    {
//        this.hargaJual = _harga_jual;
//    }
//
//    public SalesOrder getSalesOrder () { return salesOrder; }
//
//    public void setSalesOrder (SalesOrder m_so)
//    {
//        this.salesOrder = m_so;
//    }
//    
////    public int getDiscountCount ()
////    {
////        if (discounts != null)
////            return discounts.size();
////        else
////            return 0;
////    }
////
////    public List<AppliedSOServiceDiscount> getDiscounts () 
////    { 
////        return discounts; 
////    }
////
////    public void setServiceDiscs (List<AppliedSOServiceDiscount> _discs)
////    {
////        discounts = _discs;
////    }
//   
//    
//    public void resetAttributes ()
//    {
//        salesOrder = null;
//        service = null;
//    }
//}
