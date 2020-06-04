///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// * ItemPOPK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//
//package sunwell.permaisuri.core.entity.sales;
//
//import java.io.Serializable;
//
///**
// *
// * @author Benny
// */
//
//public class ItemDOConfirmationPK implements Serializable
//{
//    int m_doc ;
//    int m_item ;
//    
//    public int getItem ()
//    {
//        return m_item;
//    }
//
//    public void setItem (int _itemid)
//    {
//        this.m_item = _itemid;
//    }
//
//    public int getDeliveryOrder ()
//    {
//        return m_doc;
//    }
//
//    public void setDeliveryOrder (int _si )
//    {
//        this.m_doc = _si;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_doc;
//        hash += m_item ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ItemDOConfirmationPK)) {
//            return false;
//        }
//        ItemDOConfirmationPK other = (ItemDOConfirmationPK) object;
//        if (this.m_doc != other.m_doc)
//            return false;
//        if (this.m_item != other.m_item)
//            return false;
//        return true;
//    }
//}