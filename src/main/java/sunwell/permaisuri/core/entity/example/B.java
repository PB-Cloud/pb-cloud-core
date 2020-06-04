package sunwell.permaisuri.core.entity.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="b")
@IdClass(BPK.class)
public class B
{
	@Id
	@ManyToOne
	@JoinColumn(name="id_a")
	private A a;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_c")
	private C c;
	
	public A getA ()
	{
		return a;
	}
	public void setA (A _a)
	{
		a = _a;
	}
	public C getC ()
	{
		return c;
	}
	public void setC (C _c)
	{
		c = _c;
	}
}
