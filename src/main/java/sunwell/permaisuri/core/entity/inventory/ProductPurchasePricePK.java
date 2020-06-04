///**
// * ProductPurchasePricePK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
//import java.io.Serializable;
//
///**
// *
// * @author Benny
// */
//public class ProductPurchasePricePK implements Serializable
//{
//    Integer product ;
//    String memoS100 ;
//    
//    public Integer getProduct ()
//    {
//        return product;
//    }
//
//    public void setProduct (Integer _product)
//    {
//        this.product = _product;
//    }
//
//    public String getMemoS100 ()
//    {
//        return memoS100;
//    }
//
//    public void setMemoS100 (String _memo)
//    {
//        this.memoS100 = _memo;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += product != null ? product.hashCode() : 0;
//        hash += memoS100 != null ? memoS100.hashCode () : 0;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ProductPurchasePricePK)) {
//            return false;
//        }
//        ProductPurchasePricePK other = (ProductPurchasePricePK) object;
//        
////        if (!(product == null && other.product == null) || (product == null && other.product != null) || !this.product.equals(other.product))
////            return false;
////        if (!(memoS100 == null && other.memoS100 == null) || (memoS100 == null && other.memoS100 != null) || !this.memoS100.equals(other.memoS100))
////            return false;
//        
//        if(product != null)
//        	if(!product.equals(other.product))
//        		return false;
//        else 
//	    	if(other.product != null)
//	    		return false;
//        
//        
//        if(memoS100 != null)
//        	if(!memoS100.equals(other.memoS100))
//        		return false;
//        else
//        	if(other.memoS100 != null)
//        		return false;
//        
//        return true;
//    }
//}