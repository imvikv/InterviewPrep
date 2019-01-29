package algoRandomImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChocolateDistributionProblem {

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
	            int students= in.nextInt();
	        //call the required method here
	        printDifference(list, students);
	    }
	
	 }
	public static void printDifference(List<Integer> list, int m)
	 {
		if(m>list.size())
		{
			return;
		}
	     Collections.sort(list);
	     List<Integer> k = new ArrayList<>();
	     for(int i=0;i<list.size()-m+1;i++)
	     {
	         int diff= list.get(i+m-1)-list.get(i);
	         k.add(diff);
	     }
	     Collections.sort(k);
	     if(k.size()>0) {
	     System.out.println(k.get(0));
	     }
	     else
	     {
	    	 System.out.println(list.get(0));
	     }
	 }

}
