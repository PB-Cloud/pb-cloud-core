///**
// * SalesPackagePK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
///**
// *
// * @author Benny
// */
//public class SalesPackagePK implements java.io.Serializable
//{
//    int m_salesPackage ;
//    int m_product ;
//    
//    public long getProduct ()
//    {
//        return m_product;
//    }
//
//    public void setProduct (int _productid)
//    {
//        this.m_product = _productid;
//    }
//
//    public int getSalesPackage ()
//    {
//        return m_salesPackage;
//    }
//
//    public void setSalesPackage (int _pack)
//    {
//        this.m_salesPackage = _pack;
//    }
//    
//   
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_salesPackage;
//        hash += m_product ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SalesPackageItemPK)) {
//            return false;
//        }
//        SalesPackagePK other = (SalesPackagePK) object;
//        if (this.m_salesPackage != other.m_salesPackage)
//            return false;
//        if (this.m_product != other.m_product)
//            return false;
//       
//        return true;
//    }
//}