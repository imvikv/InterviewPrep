package algo.java.randomImpl;
/*Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer*/
public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-1146467285));
	}
	public int reverse(int a) {
	 
		boolean negflag=false;
		if(a<0)
		{
			negflag=true;
		}
		String s= Integer.toString(a);
		if(negflag)
		{
			s=s.substring(1);
			StringBuilder k= new StringBuilder(s);
			k=k.reverse();
			s=k.toString();
			s="-"+s;
		}
		else
		{
			StringBuilder k= new StringBuilder(s);
			k=k.reverse();
			s=k.toString();
		}
		
		long l=Long.parseLong(s);
		if(l<=Integer.MIN_VALUE || l>=Integer.MAX_VALUE)
		{
			return 0;
		}
		return Integer.parseInt(s);
	}

}
