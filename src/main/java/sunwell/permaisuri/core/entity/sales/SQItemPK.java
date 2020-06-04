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
//public class SQItemPK implements Serializable
//{
//    int m_sq ;
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
//    public int getSQ ()
//    {
//        return m_sq;
//    }
//
//    public void setSQ (int _poid)
//    {
//        this.m_sq = _poid;
//    }
//    
//    
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 0;
//        hash += m_sq;
//        hash += m_item ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof SQItemPK)) {
//            return false;
//        }
//        SQItemPK other = (SQItemPK) object;
//        if (this.m_sq != other.m_sq)
//            return false;
//        if (this.m_item != other.m_item)
//            return false;
//       
//        return true;
//    }
//}