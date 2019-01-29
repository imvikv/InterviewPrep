package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumberFormedByArray {

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
	        sortAndPrintTheArray(list);
	    }
	}

	private static <T> void sortAndPrintTheArray(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1= ""+o1+o2;
				String s2= ""+o2+o1;
				
				Integer a1= Integer.parseInt(s1);
				Integer a2= Integer.parseInt(s2);
				return a1.compareTo(a2);
			}
		});
		String s= "";
		for(int i=list.size()-1;i>=0;i--)
		{
			s=s+list.get(i);
		}
		System.out.println(s);
		
	}
	
}
