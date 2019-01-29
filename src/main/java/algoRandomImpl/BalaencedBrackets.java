package algo.java.randomImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BalaencedBrackets {



	public static void main(String args[]) throws Exception {

		char leftIndicator = '(';
		char rightIndicator = ')';
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int ind = in.nextInt();
		int len = input.length();
		char[] l = input.toCharArray();
		int counter = 0;
		if (ind == 2) {
			for (int i = 0; i < input.length() - 1; i++) {
				if (l[i] == leftIndicator && l[i + 1] == rightIndicator) {
					i++;
					counter++;

				} else {
					break;
				}

			}
		}
		else
		{

			for (int  i= input.length() - 1; i > 1; i--) {
				if (l[i] == rightIndicator && l[i - 1] == leftIndicator) {
					i--;
					counter++;

				} else {
					break;
				}

			}
		
		}
	
		// this is to remove balanced parentheses from start
		if (counter != 0) {
			if (ind == 2) {
				input = input.substring(2 * counter);
			}
			else
			{
				input = input.substring(0,(len-2 * counter));	
			}
			
		}
		
		for(int i=0;i<input.length();i++)
		{
			
			if(ind==2 && input.charAt(i)==leftIndicator)
			{
				if(i==0)
				{
					System.out.println(input.substring(0,1)+")"+input.substring(i));	
				}
				else
				{
					System.out.println(input.substring(0,i)+")"+input.substring(i));
				}
			}
			
			if(ind==1 && input.charAt(i)==leftIndicator)
			{
				if(i==0)
				{
					System.out.println(input.substring(0,1)+")"+input.substring(i));	
				}
				else
				{
					System.out.println(input.substring(0,i+1)+")"+input.substring(i+1));
				}
			}
		}
		
		int leftCnt = 0;
		int rightCnt = 0;
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) == leftIndicator) {
				leftCnt++;
				
			} else {
				rightCnt++;
			}

		}
		char[] m= new char[input.length()+2];
		m=input.toCharArray();
		if (ind == 2) {
			
			for(int i=1;i<input.length();i++)
			{
			System.out.println(input.substring(0,i)+")"+input.substring(i));
			}
					
			System.out.println(leftCnt);
		} else {
			for(int i=1;i<input.length();i++)
			{
				if(i==0)
				{
					System.out.println("("+input.substring(i));
				}
				else
					
			{System.out.println(input.substring(0,i)+"("+input.substring(i));}
			}
			System.out.println(rightCnt);
		}

	}


	}
	
	