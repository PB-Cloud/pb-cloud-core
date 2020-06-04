///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// * SalesItemPK.java
// *
// * Created on Apr 17, 2015, 11:50:33 AM
// */
//
//package sunwell.permaisuri.core.entity.warehouse;
//
//import java.io.Serializable;
//
///**
// *
// * @author Benny
// */
//
//public class ItemTransferStokPK implements Serializable
//{
//    int m_transferStok ;
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
//    public int getTransferStok ()
//    {
//        return m_transferStok;
//    }
//
//    public void setTransferStok (int _bbk )
//    {
//        this.m_transferStok = _bbk;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_transferStok;
//        hash += m_item ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ItemTransferStokPK)) {
//            return false;
//        }
//        ItemTransferStokPK other = (ItemTransferStokPK) object;
//        if (this.m_transferStok != other.m_transferStok)
//            return false;
//        if (this.m_item != other.m_item)
//            return false;
//        return true;
//    }
//}