package sunwell.permaisuri.core.entity.example;

import java.io.Serializable;

public class BPK implements Serializable
{
	private int a ;
	private int c ;
	
	public int getA ()
	{
		return a;
	}
	public void setA (int _a)
	{
		a = _a;
	}
	public int getC ()
	{
		return c;
	}
	public void setC (int _c)
	{
		c = _c;
	}
	
	public int hashCode() {
		return a + c;
	}
	
	public boolean equals(Object _o) {
		BPK other = (BPK) _o;
		return (a == other.a) && (c == other.c);
	}
}
