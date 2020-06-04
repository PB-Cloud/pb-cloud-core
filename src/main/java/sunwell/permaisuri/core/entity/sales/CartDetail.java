package sunwell.permaisuri.core.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import sunwell.permaisuri.core.entity.customer.Customer;
import sunwell.permaisuri.core.entity.inventory.Item;

@Entity
@Table(name="cartdetail")
@IdClass(CartDetailPK.class)
public class CartDetail
{
	@NotNull(message="{error_no_customer}")
	@Id
	@ManyToOne
	@JoinColumn(name="cust")
	private Customer customer;
	
	@NotNull(message="{error_no_item}")
	@Id
	@ManyToOne
	@JoinColumn(name="item")
	private Item item;
	
	@Column(name="qty")
	private double qty;
	
//	@Column(name="discount")
//	private double discount;
	
	@Column(name="reqnote")
	private String reqNote;
	
	public CartDetail() {
		
	}
	
	public CartDetail(Customer _cust, Item _item) {
		customer = _cust;
		item = _item;
	}
	
	public Customer getCustomer ()
	{
		return customer;
	}
	public void setCustomer (Customer _customer)
	{
		customer = _customer;
	}
	public Item getItem ()
	{
		return item;
	}
	public void setItem (Item _item)
	{
		item = _item;
	}
	public double getQty ()
	{
		return qty;
	}
	public void setQty (double _qty)
	{
		qty = _qty;
	}
	public String getReqNote ()
	{
		return reqNote;
	}
	public void setReqNote (String _reqNote)
	{
		reqNote = _reqNote;
	}
	
//	@Override
//	public int hashCode() {
//		int hash = 0;
//		long c = customer != null ? customer.getSystemId() : 0;
//		int i = item != null ? item.getSystemId() : 0;
//		hash += customer != null ? customer.getSystemId() : 0;
//		hash += item != null ? item.getSystemId() : 0;
//		System.out.println("HASH CODE in object c: " + c + " i: " + i + " hash: " + hash);
//		return hash;
//	}
//	
//	@Override
//	public boolean equals(Object _o) {
//		
//		if(!(_o instanceof CartDetail))
//			return false;
//		
//		CartDetail other = (CartDetail) _o;
//		if ((this.customer == null && other.customer != null) || 
//            (this.customer != null && !this.customer.equals(other.customer))) {
//			System.out.println("RETURN FALSE FROM OBJ, customer = " + customer.getSystemId() );
//            return false;
//        }
//		
//		if ((this.item == null && other.item != null) || 
//            (this.item != null && !this.item.equals(other.item))) {
//			System.out.println("RETURN FALSE FROM OBJ, customer  item = " + item.getSystemId() );
//            return false;
//        }
//		
//		System.out.println("RETURN TRUE FROM OBJ, customer = " + customer.getSystemId() + " item = " + item.getSystemId() );
//		return true;
//	}
//	public double getDiscount ()
//	{
//		return discount;
//	}
//	public void setDiscount (double _discount)
//	{
//		discount = _discount;
//	}

}
