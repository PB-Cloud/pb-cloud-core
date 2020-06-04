//package sunwell.permaisuri.core.entity.inventory;
//
//
///*
//
// * ProductPurchasePrice.java
// *
// * Created on September 19, 2007, 6:33 PM
// */
//
//import java.io.Serializable;
//
//import java.sql.*;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//
///**
// *
// * @author Irfin A
// * @author Benny
// */
//@Entity
//@Table( name = "productpurchaseprice" )
//@IdClass( ProductPurchasePricePK.class )
//public class ProductPurchasePrice 
//{
//    @NotNull(message="{error_no_product}")
//	@Id
//    @ManyToOne
//    @JoinColumn( name = "id_product" )
//    private Product product;
//    
//    @NotNull(message="{error_no_memo}")
//    @Id
//    @Column( name = "memo_s100")
//    private String memoS100;
//    
//    @NotNull(message="{error_no_price}")
//    @Column( name = "price" )
//    private double price;
//    
//    
//    /** Creates a new instance of ProductPurchasePrice */
//    public ProductPurchasePrice ()
//    {
//        memoS100 = "";
//    }
//
//    public Product getProduct () { return product; }
//
//    public void setProduct (Product _product)
//    {
//        this.product = _product;
//    }
//
//    public double getPrice () { return price; }
//
//    public void setPrice (double m_price)
//    {
//        this.price = m_price;
//    }
//
//    public String getMemo () { return memoS100; }
//
//    /**
//     * Character length of parameter _memo must not exceeds 100 chars.
//     * 
//     * @param _memo
//     */
//    public void setMemo (String _memo)
//    {
//        this.memoS100 = (_memo != null) ?
//                                ((_memo.length () < 101) ?
//                                    _memo : _memo.substring (0, 101))
//                           : "";
//    }   
//    
//    @Override
//    public int hashCode ()
//    {
//    	int hash = 0;
//        hash += product != null ? product.hashCode() : 0;
//        hash += memoS100 != null ? memoS100.hashCode () : 0;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object _obj)
//    {
//    	if(_obj == null)
//    		return false;
//        if (!(_obj instanceof ProductPurchasePrice)) {
//            return false;
//        }
//        
//        ProductPurchasePrice other = (ProductPurchasePrice) _obj;
//        if ((this.product == null && other.product != null) || 
//            (this.product != null && !this.product.equals(other.product))) {
//            return false;
//        }
//        
//        if ((this.memoS100 == null && other.memoS100 != null) || 
//            (this.memoS100 != null && !this.memoS100.equals(other.memoS100))) {
//            return false;
//        }
//        
//        return true;
//    }
//}
