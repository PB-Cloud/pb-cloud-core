//Source file: C:\\Documents and Settings\\root\\My Documents\\LT_Corporation\\Projects\\Permaisuri Ban\\Program\\demeter\\src\\demeter\\inventory\\ProductSellPriceHistory.java

package sunwell.permaisuri.core.entity.inventory;

import java.sql.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Menyimpan daftar perubahan harga barang. Harga aktual (yg digunakan skr)
 * didasarkan pada tanggal perubahan terakhir.
 *
 * @author Nugroho Latifolia
 */
@Entity
@Table(name = "productsellpricehistory")
public class ProductSellPriceHistory
{
	/** PRIMARY KEY ; auto-increment */
	@Id
	@Column(name = "id_productpricehistory")
	@SequenceGenerator(name = "productsellpricehistory_id_itempricehistory_seq", sequenceName = "productsellpricehistory_id_itempricehistory_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsellpricehistory_id_itempricehistory_seq")
	private int systemId;

	@NotNull(message = "{error_no_price}")
	@Column(name = "price")
	private double price;
	/** Di database harus bertipe TIMESTAMP. */

	@Column(name = "date")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Calendar date;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "id_pricelevel", referencedColumnName = "id_pricelevel"),
			@JoinColumn(name = "id_product", referencedColumnName = "id_product") })
	private ProductSellPrice itemSellPrice;

	/**
	 * @roseuid 45D1638D002E
	 */
	public ProductSellPriceHistory ()
	{
	}

	public Integer getSystemId ()
	{
		return systemId;
	}

	public void setSystemId (int _id)
	{
		this.systemId = _id;
	}

	public double getPrice ()
	{
		return price;
	}

	public void setPrice (double _price)
	{
		this.price = price;
	}

	public Calendar getDate ()
	{
		return date;
	}

	public void setDate (Calendar m_date)
	{
		this.date = m_date;
	}

	public ProductSellPrice getItemPrice ()
	{
		return itemSellPrice;
	}

	public void setItemPrice (ProductSellPrice _ip)
	{
		itemSellPrice = _ip;
	}

	public int hashCode ()
	{
//		return systemId != null ? systemId.hashCode() : 0;
		return systemId;
	}

	@Override
	public boolean equals (Object obj)
	{
		if (obj == null)
			return false;
		if (!(obj instanceof ProductSellPriceHistory)) {
			return false;
		}

		ProductSellPriceHistory other = (ProductSellPriceHistory) obj;
//		if ((this.systemId == null && other.systemId != null)
//				|| (this.systemId != null && !this.systemId.equals(other.systemId))) {
//			return false;
//		}
//		return true;
		return systemId == other.systemId;
	}
}
