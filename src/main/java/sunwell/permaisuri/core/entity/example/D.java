package sunwell.permaisuri.core.entity.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="d")
public class D
{
	@Id
	@Column(name="id")
	private int id;

	public int getId ()
	{
		return id;
	}

	public void setId (int _id)
	{
		id = _id;
	}
}
