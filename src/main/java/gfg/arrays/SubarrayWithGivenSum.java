package gfg.arrays;

import java.util.Scanner;

public class SubarrayWithGivenSum {

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

		public static void main (String[] args)
		 {
		
		    Scanner in = new Scanner(System.in);
		    int tcase= in.nextInt();
		    for(int i=0;i<tcase;i++)
		    {
		        int ip1=in.nextInt();
		        int sum=in.nextInt();
		       int[] arr= new int[ip1];
		        for(int j=0;j<ip1;j++)
		            {	                    
		                    arr[j]=in.nextInt();
		            }
		        //call the required method here
		        function(arr,sum);
		    }
		
		 }
		 public static void  function(int[] arr,int sum)
		 {
		     int start=0,end=0;
		     int sum2=0;
		     for(int i=0;i<arr.length;i++)
		     {
		    	 if(sum2==sum)
		    		 break;
		    	 
		         while(sum2+arr[i]>sum)
		         {
		             sum2-=arr[start];
		             start++;
		             System.out.println("sum2 now +"+sum2+" "+start +" "+arr[i]);
		         }
		          if(sum2+arr[i]<=sum)
		         {
		             end++;
		             sum2+=arr[i];
		             System.out.println("sum2 now +"+sum2);
		         }
		        
		         
		     }
		     if(sum2==sum)
		     System.out.println((start+1)+" "+(end+1));
		     else
		     System.out.println("-1");
		 }

}
