package gfg.arrays;

//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
//just moving mid pointer and based on its value changing the other values

//inputs 
/*
2
5
0 2 1 2 0
3
0 1 0

1
15
2 2 0 0 2 1 0 1 1 2 2 1 2 2 0

1
3
0 1 0
*/
import java.util.Scanner;

public class SegregateZeroOneTwo {
	
		public static void main (String[] args)
		 {
		
		    Scanner in = new Scanner(System.in);
		    int tcase= in.nextInt();
		    for(int i=0;i<tcase;i++)
		    {
		        int ip1=in.nextInt();
		       int[] arr= new int[ip1];
		        for(int j=0;j<ip1;j++)
		            {	                    
		                    arr[j]=in.nextInt();
		            }
		        //call the required method here
		        function(arr);
		        
		    }
		
		 }
		 public static void  function(int[] arr)
		 { int start=0,mid=0,end=arr.length-1;
	     while(mid<=end)
	     {
	         //base logic is move only mid from 0 to end and swap where ever necessary
	         if(arr[mid]==1) mid++;
	         else if(arr[mid]==0) 
	         {
	        	 //System.out.println("mid start arr[mid] arr[start]"+mid+ " "+start+" "+arr[mid]+" "+arr[start] );
	        	 
	             int temp=arr[start];
	             arr[start]=0;
	             arr[mid]=temp;
	              mid++; // we are increasing mid and start both here because it will come here when either the arr[mid] value would be 0 or 1 , if 0 then start will take care of it and if 1 then already getting incremented
	             start++;
	         }
	         else if(arr[mid]==2)
	         {
	             int temp=arr[end];
	             arr[end]=2;
	             arr[mid]=temp;
	             end--;
	         }
	         
	     }
	    
	     for(int i=0;i<arr.length;i++)
	     {
	         System.out.print(arr[i]+" ");
	     }
	     System.out.println();
	 }
	}

