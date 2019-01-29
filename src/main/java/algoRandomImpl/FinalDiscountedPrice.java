package algoRandomImpl;

import java.util.Scanner;

public class FinalDiscountedPrice {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }
        
        finalPrice(_prices);
        
    }
	/*
	 * Complete the function below.
	 */

	    static void finalPrice1(int[] arr) {
	        int sum=0;
	        int j=0;
	        int[] index=new int[arr.length];
	        for(int i=0;i<arr.length-1;i++)
	            {
	            if(arr[i+1]<=arr[i])
	                {
	                arr[i]=arr[i]-arr[i+1];                
	            }
	            else{
	                index[j]=i;
	                j++;
	            }
	            sum=sum+arr[i];
	        }
	        index[j]=arr.length-1;
	        sum=sum+arr[arr.length-1];
	        System.out.println(sum);
	        for(int k=0;k<=j;k++)
	            {
	            System.out.print(index[k]);
	            if(k!=index.length-1)
	                {
	                System.out.print(" ");
	            }
	        }
	        

	    }
	    
	    /*
	     * Complete the function below.
	     */

	        static void finalPrice(int[] arr) {
	        	int len=arr.length;
	        	int temp=arr[len-1];
	        	int sum=temp;
	        	int[] index= new int[len];
	        	index[0]=len-1;
	        	int j=1;
	        	
	        	for(int i=len-2;i>=0;i--)
	        	{
	        		if(arr[i+1]<=arr[i])
	        		{
	        			sum=sum+(arr[i]-arr[i+1]);
	        		}
	        		else if(arr[i]>temp)
	        		{
	        			sum=sum+arr[i]-temp;
	        		}
	        		else if(arr[i]<=temp)
	        		{
	        			sum=sum+arr[i];
	        			temp=arr[i];
	        			index[j]=i;
	        			j++;
	        		}
	        		
	        	}
	        	System.out.println(sum);
	        	
	        	for(int k=j-1;k>=0;k--)
	        	{
	        		System.out.print(index[k]+" ");
	        		
	        	}
	        }

	       



}
