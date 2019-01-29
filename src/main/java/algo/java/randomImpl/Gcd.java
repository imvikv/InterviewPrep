package algo.java.randomImpl;


/*Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 */
public class Gcd {

	public static void main(String[] args) {
	System.out.println(new Gcd().gcd(2,0));

	}
	
	public int gcd(int a, int b) {
		int value=1,min;
		if(a==0||b==0)
		{
			return value=a>=b?a:b;
		}
		min=a<b?a:b;
		for(int i=min;i>1;i--)
		{
			if(a%i==0 && b%i==0)
			{value=i;
				break;
			}
		}
		return value;
	}

}
