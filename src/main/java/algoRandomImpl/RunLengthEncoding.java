package algo.java.randomImpl;

import java.util.Scanner;
import java.util.TreeMap;

public class RunLengthEncoding {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		String s= "wwwwaaadexxxxxx";
		char[] a= s.toCharArray();
		int counter=1;		
		System.out.print(a[0]);
		for(int i=1;i<a.length;i++)
		{
		// if old char 
			if(a[i-1]==a[i])
			{
				counter++;
			}
			//if new char
			else
			{
				System.out.print(counter);
				System.out.print(a[i]);
				counter=1;
			}
		}
		System.out.print(counter);
	}
}
