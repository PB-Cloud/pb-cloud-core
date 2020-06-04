///**
// * SalesPackageItemPK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//package sunwell.permaisuri.core.entity.inventory;
//
///**
// *
// * @author Benny
// */
//public class SalesPackageItemPK implements java.io.Serializable
//{
//    int m_salesPackage ;
//    int m_product ;
//    int m_no_urut ;
//    String m_serialno_s100 ;
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
//    public int getNoUrut ()
//    {
//        return m_no_urut;
//    }
//
//    public void setNoUrut (int _noUrut)
//    {
//        this.m_no_urut = _noUrut;
//    }
//
//    public String getSerialNo ()
//    {
//        return m_serialno_s100;
//    }
//
//    public void setSalesPackage (String _serial)
//    {
//        this.m_serialno_s100 = _serial;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_salesPackage;
//        hash += m_product ;
//        hash += m_no_urut;
//        hash += Integer.parseInt (m_serialno_s100) ;
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
//        SalesPackageItemPK other = (SalesPackageItemPK) object;
//        if (this.m_salesPackage != other.m_salesPackage)
//            return false;
//        if (this.m_product != other.m_product)
//            return false;
//        if (this.m_no_urut != other.m_no_urut)
//            return false;
//        if (this.m_serialno_s100 != other.m_serialno_s100)
//            return false;
//        return true;
//    }
//}