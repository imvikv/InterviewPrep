package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
public class ChocklateDistributionProb {

	public static void main (String[] args) throws IOException 
	 {
	
	      // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase 
        int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
            int n = Integer.parseInt(br.readLine()); 
  
            // Declaring array 
            int arr[] = new int[n]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 
             int k = Integer.parseInt(br.readLine()); 
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
	 public static void  function(int[] arr, int k)
	 {
	  Arrays.sort(arr);
	  int min=Integer.MAX_VALUE;
	 
	  
	    for(int i=0,j=k-1;j<arr.length;i++,j=i+k-1)
	  {
	    	
	      min=Math.min(min,arr[j]-arr[i]);
	      
	  }
	  System.out.println(min);
	 }


}
