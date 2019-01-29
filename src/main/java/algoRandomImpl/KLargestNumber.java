package algoRandomImpl;

import java.util.ArrayList;import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KLargestNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int input= in.nextInt();
	    for(int i=0;i<input;i++)
	    {
	        int no_of_input=in.nextInt();
	        List<Integer> list= new ArrayList<>();
	        int k=in.nextInt();
	        for(int j=0;j<no_of_input;j++)
	            {	                    
	                    list.add(in.nextInt());
	            }
	        //call the required method here
	        printKElements(list,k);
	    }
	

	}

	private static void printKElements(List<Integer> list,int k) {
		
		Queue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
		for(Integer l:list)
		{
			q.add(l);
		}
		for(int i=0;i<k;i++)
		{
			System.out.print(q.poll()+" ");
		}
		System.out.println();
		
	}

}
