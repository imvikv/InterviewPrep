package algo.java.randomImpl;
/*Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. */
public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPower(4));
		
	}

	public boolean isPower(int a) {
	a=Math.abs(a);
	if(a<=1)
	{
		return true;
	}
	if(a<=3)
	{
		return false;
	}
		Boolean flag=false;
		
		for(int k=2;k<=Math.sqrt(a);k++)
		{
			for(int i=2;a>=Math.pow(k, i);i++)
			{
				if(a==Math.pow(k, i))
				{
					flag=true;
				}
			}
		}
		return flag;
		
    }
}