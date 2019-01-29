package algo.java.randomImpl;

import java.util.Scanner;

/*There are n stairs, a person standing at the bottom wants to reach the top. 
The person can climb either 1 stair or 2 stairs at a time. 
Count the number of ways, the person can reach the top.

The formula says that in order to reach the n'th step we have to firstly reach:

n-3'th step and then take 3 steps at once i.e. K(n-3)
or n-2'th step and then take 2 steps at once i.e. K(n-2)
or n-1'th step and then take 1 steps at once i.e. K(n-1)


*/
public class StairsNth {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		System.out.println(reach(value));
	}

	private static int reach(int value) {
		if (value < 3) {
			return value;
		}
		return reach(value - 1) + reach(value - 2);
	}

}
