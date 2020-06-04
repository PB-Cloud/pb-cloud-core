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

public class BonusItemUsedPK implements Serializable
{
    int salesInvoice ;
    int item ;
    
    public Integer getItem ()
    {
        return item;
    }

    public void setItem (int _itemid)
    {
        this.item = _itemid;
    }

    public int getSalesInvoice ()
    {
        return salesInvoice;
    }

    public void setEtnaSalesInvoice (int _si)
    {
        this.salesInvoice = _si;
    }
    
    @Override
    public int hashCode ()
    {
        int hash = 0;
//        hash += salesInvoice != null ? salesInvoice.hashCode() : 0;
//        hash += item != null ? item.hashCode() : 0 ;
        hash += salesInvoice ;
        hash += item ;
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonusItemUsedPK)) {
            return false;
        }
        BonusItemUsedPK other = (BonusItemUsedPK) object;
//        if (this.salesInvoice != other.salesInvoice)
//            return false;
//        if (this.item != other.item)
//            return false;
        
//        if ((this.salesInvoice == null && other.salesInvoice != null) || 
//            (this.salesInvoice != null && !this.salesInvoice.equals(other.salesInvoice))) {
//            return false;
//        }
//        
//        if ((this.item == null && other.item != null) || 
//            (this.item != null && !this.item.equals(other.item))) {
//            return false;
//        }
        if(salesInvoice != other.salesInvoice)
        	return false;
        
        if(item != other.item)
        	return false;
        
        return true;
    }
}