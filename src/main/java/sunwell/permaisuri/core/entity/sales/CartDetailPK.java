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

public class CartDetailPK implements Serializable
{
    long customer ;
    int item ;
    
    public CartDetailPK() {
    	
    }
    
    public CartDetailPK(long _cust, int _item) {
    	customer = _cust;
    	item = _item;
    }
    
    public Integer getItem ()
    {
        return item;
    }

    public void setItem (int _itemid)
    {
        this.item = _itemid;
    }

    public long getCustomer ()
    {
        return customer;
    }

    public void setCustomer (long _si)
    {
        this.customer = _si;
    }
    
    @Override
    public int hashCode ()
    {
        int hash = 0;
//        hash += salesInvoice != null ? salesInvoice.hashCode() : 0;
//        hash += item != null ? item.hashCode() : 0 ;
        hash += customer ;
        hash += item ;
//        long c = customer != null ? customer.getSystemId() : 0;
//		int i = item != null ? item.getSystemId() : 0;
//		hash += customer != null ? customer.getSystemId() : 0;
//		hash += item != null ? item.getSystemId() : 0;
		System.out.println("HASH CODE c: " + customer + " i: " + item + " hash" + hash);
        return hash;
    }

    @Override
    public boolean equals (Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartDetailPK)) {
            return false;
        }
        CartDetailPK other = (CartDetailPK) object;
        if(customer != other.customer) {
        	System.out.println("RETURN FALSE, customer = " + customer);
        	return false;
        }
        
        if(item != other.item) {
        	System.out.println("RETURN TRUE,  item = " + item );
        	return false;
        }
        
        System.out.println("RETURN TRUE, customer = " + customer + " item = " + item );
        return true;
    }
}