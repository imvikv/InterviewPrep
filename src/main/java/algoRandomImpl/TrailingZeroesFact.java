package algoRandomImpl;
/*Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1*/
public class TrailingZeroesFact {

	public static void main(String[] args) {
		System.out.println(new TrailingZeroesFact().trailingZeroes(28));

	}
	public int trailingZeroes(int a) {
		int count=0;
		for(int i=5;a/i>=1;i*=5)
		{
			count+=Math.floorDiv(a, i);
		}
	    return count;
	}

}
