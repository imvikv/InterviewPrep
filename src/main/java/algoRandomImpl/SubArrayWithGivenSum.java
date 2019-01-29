package algoRandomImpl;

/*Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

input
1
5 12
1 2 3 7 5

1
42 468
135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.

visulize the subarray keep sliding until you have the subarray
Source: Google Interview Question*/

import java.util.Scanner;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nt = in.nextInt();
		for (int i = 0; i < nt; i++) {
			int size = in.nextInt();
			int[] a = new int[size];
			int sum = in.nextInt();
			for (int j = 0; j <size; j++) {
				a[j] = in.nextInt();

			}
			int curr_sum=a[0],start=0,end=1;
//			subArraySum(a, size, sum);
		//	printIndex(size, a, sum, curr_sum, start, end);
			function(a,sum);
		}
	}

	 public static void function(int[] arr, int ip2)
	 {
	     int sum=arr[0],start=0,end=0;
	     for(int i=1;i<arr.length+1;i++)
	     {
	          if(sum<ip2)
	          {
	              sum+=arr[i];
	              end=i;
	          }
	          else if(sum==ip2)
	         {	start++;
	             System.out.println(start+" "+ (i));
	             return;
	         }
	         while (sum>ip2 && start<end)
	         {
	             
	             sum=sum-arr[start];
	             start++;
	         }
	     }
	     if(sum==ip2)
	     {	start++;
	    	 System.out.println(start+" "+ (end)); 
	     }
	     System.out.println("-1"); 	
	 }
	
	 //working lot of edge cases problem becasue of index start from 0 
	private static int subArraySum(int arr[], int n, int sum) 
    {
        int curr_sum = arr[0], start = 0, i;
 
        // Pick a starting point
        for (i = 1; i <= n; i++) 
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum - arr[start];
                start++;
            }
             
            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) 
            {
            	start++;
                int p = i;
                System.out.println(start+" "+p);
//                System.out.println("Sum found between indexes " + start
//                        + " and " + p);
                return 1;
            }
             
            // Add this element to curr_sum
            if (i < n)
            curr_sum = curr_sum + arr[i];
             
        }
        
 
        System.out.println("-1");
        return 0;
    }
 
	//below solution not working in all cases above solution is working for copied from GFG
	
	private static boolean printIndex(int size, int[] a, int sum, int curr_sum, int start, int end) {
		for(end=1;end<=size;end++)
		{
			while(curr_sum>sum && start<end-1)
			{	curr_sum=curr_sum-a[start];
			start++;
			}
			
			
			 if(curr_sum==sum)
				{
				 start++;
					System.out.println(start +" "+ end);
					return true;
				}
				
			 if(curr_sum<sum&& end<size)
				{					
					curr_sum+=a[end];
				
				}
		
		}
		
			System.out.println("-1");
			
		
		return false;
	}

	
	

}
