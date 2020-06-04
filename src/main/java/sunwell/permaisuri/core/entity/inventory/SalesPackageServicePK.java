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
//public class SalesPackageServicePK implements java.io.Serializable
//{
//    int m_salesPackage ;
//    int m_service ;
//    int m_no_urut ;
//    
//    
//    public long getservice ()
//    {
//        return m_service;
//    }
//
//    public void setService (int _itemid)
//    {
//        this.m_service = _itemid;
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
//   
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_salesPackage;
//        hash += m_service ;
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
//        if (this.m_service != other.m_product)
//            return false;
//        return true;
//    }
//}