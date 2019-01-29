package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RelativeSorting {
	public static void main (String[] args) throws IOException 
	 {
	
	      // Using BufferedReader class to take input 
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
 
       // taking input of number of testcase 
       int t = Integer.parseInt(br.readLine()); 
       
       while (t-- > 0) { 
           // m,n : size of array
           String size = br.readLine(); 
           String[] arrSize = size.trim().split("\\s+"); 
           int m = Integer.parseInt(arrSize[0]);
           int n = Integer.parseInt(arrSize[1]);
           Map<Integer,Integer> freq=new LinkedHashMap<>();
           Queue<Integer> sorted=new PriorityQueue<Integer>();
           int arr[] = new int[m]; 
           
           // to read multiple integers line 
           String line = br.readLine(); 
           String[] strs = line.trim().split("\\s+"); 
           for (int i = 0; i < m; i++) 
               arr[i] = Integer.parseInt(strs[i]); 
           
           String a2=br.readLine(); 
           String[] a2Strs = a2.trim().split("\\s+");
           for (int i = 0; i < n; i++) 
               freq.put(Integer.parseInt(a2Strs[i]),0);
           
           for(int j=0;j<m;j++)
           {
               if(freq.containsKey(arr[j]))
               freq.put(arr[j],freq.get(arr[j])+1);
               else
               sorted.offer(arr[j]);
           }
   
           //time to print
           StringBuffer sb = new StringBuffer(); 
           for (Integer i:freq.keySet()) 
               {
                   for(int j=0;j<freq.get(i);j++)
                   sb.append(i+" ");
               } 
           while(sorted.size()!=0)
           sb.append(sorted.poll()+" ");
           
           System.out.println(sb); 
               
           // Calling Functions to segregate Array elements 
	        //function(arr);
			/*
			StringBuffer sb = new StringBuffer(); 
           for (int i = 0; i < n; i++) 
               sb.append(arr[i] + " "); 
 
           // finally printing the string 
           System.out.println(sb); 
			*/ 
	    }
	
	 }
	 
}
