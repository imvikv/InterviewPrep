package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplet {
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
 
           // Calling Functions to segregate Array elements 
	        function(arr);
			/*
			StringBuffer sb = new StringBuffer(); 
           for (int i = 0; i < n; i++) 
               sb.append(arr[i] + " "); 
 
           // finally printing the string 
           System.out.println(sb); 
			*/ 
	    }
	
	 }
	 public static void  function(int[] arr)
	 {
	     boolean found=false;
	     Set<Integer> part3=new HashSet<Integer>();
	     for(int i=0;i<arr.length;i++)
	     {
	         part3.add(arr[i]*arr[i]);
	     }
	     for(int i=0;i<arr.length-1;i++)
	     {
	         for(int j=i+1;j<arr.length;j++){
	        int g=(int) (Math.pow(arr[i],2)+Math.pow(arr[j],2));
	         if(part3.contains(g))
	         {
	             found =true;
	             break;
	         }
	         }
	     }
	     if(found)
	     System.out.println("Yes");
	     else
	     System.out.println("No");
	 }
}
