package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
/*Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90*/
public class MaxOfAllSubarrayOfSizeK {


	public static void main (String[] args) throws IOException 
	 {
	
	      // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase 
        int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
            //int n = Integer.parseInt(br.readLine()); 
            String line0=br.readLine();
             String[] strs0 = line0.trim().split("\\s+");
             int n=Integer.parseInt(strs0[0]);
             int k=Integer.parseInt(strs0[1]);
            // Declaring array 
            int arr[] = new int[n]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 
  
            // Calling Functions to segregate Array elements 
	        function(arr,k);
			/*
			StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < n; i++) 
                sb.append(arr[i] + " "); 
  
            // finally printing the string 
            System.out.println(sb); 
			*/ 
	    }
	
	 }
	 public static void  function(int[] arr,int k)
	 {
	     Queue<Integer> subarray=new PriorityQueue<Integer>(k,Collections.reverseOrder());
	     for(int i=0;i<k;i++)
	     subarray.offer(arr[i]);
	     
	     for(int j=k,m=0;j<arr.length;j++)
	     {
	         int l=subarray.peek();
	         subarray.remove(arr[m++]);
	         System.out.print(l+" ");
	         subarray.offer(arr[j]);
	     }
	     System.out.print(subarray.peek()+" ");
	     System.out.println();
	 }

}
