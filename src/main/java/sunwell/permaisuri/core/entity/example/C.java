package sunwell.permaisuri.core.entity.example;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import sunwell.permaisuri.core.entity.inventory.ItemCategory;

@Entity
@Table(name="c")
public class C
{
	@Id
	@Column(name="id")
	private int id ;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="cd",
	    joinColumns=
	        @JoinColumn(name="id_c", referencedColumnName="id"),
	    inverseJoinColumns=
	        @JoinColumn(name="id_d", referencedColumnName="id")
    )
    private List<D> listD ;

	

	public int getId ()
	{
		return id;
	}

	public void setId (int _id)
	{
		id = _id;
	}
	
	public List<D> getListD ()
	{
		return listD;
	}

	public void setListD (List<D> _listD)
	{
		listD = _listD;
	}
}
