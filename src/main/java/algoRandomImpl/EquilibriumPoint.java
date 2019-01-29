package algoRandomImpl;

import java.util.Scanner;

/*https://practice.geeksforgeeks.org/problems/equilibrium-point/0
	Given an array A your task is to tell at which position the equilibrium first occurs in the array. 
	Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of elements after it.
	Example:
Input:
2
1
1
5
1 3 5 2 2

Output:
1
3


1
43
24 5 17 8 15 11 21 13 23 39 30 4 14 10 8 39 20 15 3 4 16 9 19 39 34 25 29 21 31 3 21 2 9 22 31 7 21 4 30 23 5 36 3
	
	
	*
	*
	*/


class EquilibriumPoint
{
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
	/* public static void function(int[] arr)
	 {
	     if(arr.length==0) 
	     {
	         System.out.println("-1");
	         return;
	     }
	     if(arr.length==1) 
	     {
	         System.out.println("1");
	         return;
	     }
	     int i=0,j=arr.length-1;
	     int sum1=arr[i],sum2=arr[j];
	    while(i<j)
	    {
	        if(sum1==sum2 )
	        {
	            if(j-i==2){
	            System.out.println(i+2);
	            return;
	            }
	            else
	            {
	                i++;
	                j--;
	                sum1+=arr[i];
	                sum2+=arr[j];
	            }
	        }
	        if(sum1<sum2)
	        {   i++;
	            sum1+=arr[i];
	        }
	         if(sum1>sum2)
	        {
	            j--;
	            sum2+=arr[j];
	        }
	    }
	    System.out.println("-1");    
	 }*/
	 public static void  function(int[] arr)
	 {
	     if(arr.length==1) {
	      System.out.println("1"); 	
	     return;}
	     //maintain two array summation from start and from end\
	     int len=arr.length;
     int[] arr1=new int[arr.length];
     int[] arr2=new int[arr.length];
	   arr1[0]=arr[0];
	   arr2[len-1]=arr[len-1];
	 boolean found=false;
	     for(int i=1,j=len-2;i<len && j>=0;i++,j--)
	     {
	       arr1[i]=arr1[i-1]+arr[i];
	       arr2[j]=arr[j++]+arr[j];
	     }
	     
	     for(int k=0;k<len;k++)
	     {
	         if(arr1[k]==arr2[k])
	         {
	             System.out.println((k+1));
	             found=true;
	         }
	     }
	     if(!found)
	      System.out.println("-1"); 	
	 }
}