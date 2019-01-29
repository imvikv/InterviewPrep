package java.multiThreadingImpl;

import java.sql.Date;



public final class  ImmutableClass {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
	private final String s;
	private final Date d;
	private final int c;
	
	
	/**
	 * @param s
	 * @param d
	 * @param c
	 */
	public ImmutableClass(String s, Date d, int c) {		
		this.s = s;
		this.d = new Date(d.getDate());
		this.c = c;
		
	}
	
/*	
 * By making it final you can't change value once it's intialized
 * public void go()
	{
		s="asd";
	}*/
	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}
	
	/**
	 * @return the d
	 */
	public Date getD() {
		return new Date(this.d.getDate());
	}

	/**
	 * @return the c
	 */
	public int getC() {
		return c;
	}
public static void main(String[] args) {
	ImmutableClass c= new ImmutableClass("sd", new Date(2014,12,12), 2);
	
}
	
}
