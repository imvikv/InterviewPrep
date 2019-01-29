package java.multiThreadingImpl;

import java.multiThreadingImpl.A.C;

public class B  extends A{

	public B(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
A a= new B("");
B b= (B) a;
}

class A {

	/**
	 * @param s
	 */
	public A(String s) {
		super();
		this.s = s;
	}

	private String s;
	public int b;
	protected char c;
	byte l;

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public char getC() {
		return c;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}

	/**
	 * @return the l
	 */
	public byte getL() {
		return l;
	}

	/**
	 * @param l
	 *            the l to set
	 */
	public void setL(byte l) {
		this.l = l;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	 class C
	{
		 public C(String s)
		 {
			 
		 }
		public void printMethod()
		{
			System.out.println("printing values"+s);
		}
	}
}