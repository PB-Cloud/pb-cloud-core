package sunwell.permaisuri.core.entity.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="a")
public class A
{
	@Id
	@Column(name="id")
	private int id;
	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="a", cascade=CascadeType.ALL)
	private List<B> b;

	public List<B> getB ()
	{
		return b;
	}

	public void setB (List<B> _b)
	{
		b = _b;
	}
}
