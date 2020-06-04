/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * SalesItemPK.java
 *
 * Created on Apr 17, 2015, 11:50:33 AM
 */

package sunwell.permaisuri.core.entity.warehouse;

import java.io.Serializable;

/**
 *
 * @author Benny
 */

public class OnHandStockPK implements Serializable
{
    private int item ;
    private int warehouse ;
//    private int m_source_ref_type ;
//    private int m_source_ref_id ;
//    private String strExpiryDate = "";
//    private String batchNo = "" ;
//    private String serialNo = "" ;
    
    public OnHandStockPK() {
    	
    }
    
    public OnHandStockPK(int _item, int _warehouse) {
    	item = _item;
    	warehouse = _warehouse;
//    	strExpiryDate = _expDate;
//    	serialNo = _serialNo;
//    	batchNo = _batchNo;
    }
    
//    public OnHandStockPK(int _item, int _warehouse, String _expDate, String _serialNo, String _batchNo) {
//    	item = _item;
//    	warehouse = _warehouse;
////    	strExpiryDate = _expDate;
////    	serialNo = _serialNo;
////    	batchNo = _batchNo;
//    }
    
    
    public int getItem ()
    {
        return item;
    }

    public void setItem (int _itemid)
    {
        this.item = _itemid;
    }

    public int getWarehouse ()
    {
        return warehouse;
    }

    public void setWarehouse (int _w )
    {
        this.warehouse = _w;
    }
    
//    public String getBatchNo ()
//    {
//        return batchNo;
//    }
//
//    public void setBatchNo (String _batch )
//    {
//        this.batchNo = _batch;
//    }
//    public String getSerialNo ()
//    {
//        return serialNo;
//    }
//
//    public void setSerialNo (String _serial )
//    {
//        this.serialNo = _serial;
//    }
//    
//    public String getExpiryDate ()
//    {
//        return strExpiryDate;
//    }
//
//    public void setExpiryDate (String _exp )
//    {
//        this.strExpiryDate = _exp;
//    }
    
    @Override
    public int hashCode ()
    {
        int hash = 11;
        hash += item ;
        hash += warehouse ;
//        hash += batchNo.hashCode () ;
//        hash += strExpiryDate.hashCode () ;
//        hash += serialNo.hashCode () ;
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnHandStockPK)) {
            return false;
        }
        OnHandStockPK other = (OnHandStockPK) object;
        
        if (this.item != other.item)
            return false;
        if (warehouse != other.warehouse)
            return false;
//        if(!batchNo.equals (other.batchNo))
//            return false;
//        if(!strExpiryDate.equals (other.strExpiryDate))
//            return false;
//        if(!serialNo.equals (other.serialNo))
//            return false;
        return true;
    }
}