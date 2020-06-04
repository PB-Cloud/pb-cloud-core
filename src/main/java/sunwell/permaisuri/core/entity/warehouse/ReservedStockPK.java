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
//public class ReservedStockPK implements Serializable
//{
//    
//    private int m_id_stockRsrv ;
//    private int m_item ;
//    private int m_gudang ;
//    private int m_source_ref_type ;
//    private int m_source_ref_id ;
//    private String m_str_exp_date = null;
//    private String m_batchNo = "" ;
//    private String m_serialNo = "" ;
//    
//    public int getStockReservation ()
//    {
//        return m_id_stockRsrv;
//    }
//
//    public void setStockReservation (int _stockrsrv)
//    {
//        this.m_id_stockRsrv = _stockrsrv;
//    }
//    
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
//    public int getWarehouse ()
//    {
//        return m_gudang;
//    }
//
//    public void setWarehouse (int _w )
//    {
//        this.m_gudang = _w;
//    }
//    
//    public int getSourceRefType ()
//    {
//        return m_source_ref_type;
//    }
//
//    public void setSourceRefType (int _t)
//    {
//        this.m_source_ref_type = _t;
//    }
//    
//    public int getSourceRefId ()
//    {
//        return m_source_ref_id;
//    }
//
//    public void setSourceRefId (int _id)
//    {
//        this.m_source_ref_id = _id;
//    }
//
//    public String getExpiryDate ()
//    {
//        return m_str_exp_date;
//    }
//
//    public void setExpiryDate (String _exp )
//    {
//        this.m_str_exp_date = _exp;
//    }
//    
//    @Override
//    public int hashCode ()
//    {
//        int hash = 11;
//        hash += m_id_stockRsrv ;
//        hash += m_item ;
//        hash += m_gudang ;
//        hash += m_source_ref_id*m_source_ref_type ;
//        hash += m_batchNo.hashCode () ;
//        hash += m_str_exp_date.hashCode () ;
//        hash += m_serialNo.hashCode () ;
//        return hash;
//    }
//
//    @Override
//    public boolean equals (Object object)
//    {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ReservedStockPK)) {
//            return false;
//        }
//        ReservedStockPK other = (ReservedStockPK) object;
//        
//        if (this.m_id_stockRsrv != other.m_id_stockRsrv)
//            return false;
//        if (this.m_item != other.m_item)
//            return false;
//        if (m_gudang != other.m_gudang)
//            return false;
//        if (m_source_ref_id != other.m_source_ref_id || m_source_ref_type !=other.m_source_ref_type)
//            return false;
//        if(!m_batchNo.equals (other.m_batchNo))
//            return false;
//        if(!m_str_exp_date.equals (other.m_str_exp_date))
//            return false;
//        if(!m_serialNo.equals (other.m_serialNo))
//            return false;
//        return true;
//    }
//}