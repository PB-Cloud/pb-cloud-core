/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * ItemPOPK.java
 *
 * Created on Apr 17, 2015, 11:50:33 AM
 */

package sunwell.permaisuri.core.entity.sales;

import java.io.Serializable;

/**
 *
 * @author Benny
 */

public class SalesOrderItemPK implements Serializable
{
    long parent ;
    int item ;
    
    public int getItem ()
    {
        return item;
    }

    public void setItem (int _itemid)
    {
        this.item = _itemid;
    }

    public long getParent ()
    {
        return parent;
    }

    public void setParent (long _so)
    {
        this.parent = _so;
    }    
    
    @Override
    public int hashCode ()
    {
        int hash = 0;
//        hash += salesOrder != null ? salesOrder.hashCode() : 0;
//        hash += item != null ? item.hashCode() : 0 ;
        hash += parent ;
        hash += item ;
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
    	if(object == null)
    		return false;
        if (!(object instanceof SalesOrderItemPK)) {
            return false;
        }
        SalesOrderItemPK other = (SalesOrderItemPK) object;
//        if (this.m_so != other.m_so)
//            return false;
//        if (this.m_item != other.m_item)
//            return false;
        
//        if ((this.salesOrder == null && other.salesOrder != null) || 
//            (this.salesOrder != null && !this.salesOrder.equals(other.salesOrder))) {
//            return false;
//        }
//        
//        if ((this.item == null && other.item != null) || 
//            (this.item != null && !this.item.equals(other.item))) {
//            return false;
//        }
        
        if(parent != other.parent)
        	return false;
        
        if(item != other.item)
        	return false;
       
        return true;
    }
}