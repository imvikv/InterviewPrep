package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Stickler is a thief and wants to loot money from a society of n houses placed in a line. He is a weird person and follows a rule while looting the houses and according to the rule he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to find the maximum amount he can end up with. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains an integer n which denotes the number of elements in the array a[]. Next line contains space separated n elements in the array a[].

Output:
Print an integer which denotes the maximum amount he can take home.

Constraints:
1<=T<=200
1<=n<=1000
1<=a[i]<=10000

Example:
Input:
2
6
5 5 10 100 10 5
3
1 2 3

Output:
110
4*/

public class SticklerThief {

	
	public static void main(String[] args) {

		
	    Scanner in = new Scanner(System.in);
	    int input= in.nextInt();
	    for(int i=0;i<input;i++)
	    {
	        int no_of_input=in.nextInt();
	        List<Integer> list= new ArrayList<>();
	        for(int j=0;j<no_of_input;j++)
	            {	                    
	                    list.add(in.nextInt());
	            }
	        //call the required method here
	        printmaxTakeHomeMoney(list);
	    }
	
	 
	}

	private static void printmaxTakeHomeMoney(List<Integer> list) {
		int incl=list.get(0),excl=0;
		for(int i=1;i<list.size();i++)
		{	
			int newincl=Math.max(list.get(i)+excl,incl);
			int newExcl=Math.max(incl,excl);
			incl=newincl;
			excl= newExcl;
		}
		System.out.println(Math.max(incl,excl));
	}
}
