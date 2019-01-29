package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralOrderMatrix {
//	https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0

	public static void main (String[] args) throws IOException 
	 {
	
	      // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase 
        int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
              String size = br.readLine(); 
            String[] temp = size.trim().split("\\s+"); 
            int m = Integer.parseInt(temp[0]); 
            int n = Integer.parseInt(temp[1]);
  
            // Declaring array 
            int arr[] = new int[m*n]; 
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < m*n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 
  
            // Calling Functions to segregate Array elements 
	        function(arr,m,n);
			/*
			StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < n; i++) 
                sb.append(arr[i] + " "); 
  
            // finally printing the string 
            System.out.println(sb); 
			*/ 
	    }
	
	 }
	 public static void  function(int[] arr,int m,int n){
	     int T=0,L=0,B=m-1,R=n-1,dir=0;
	     int[][] arr1=new int[m][n];
	     for(int a=0,c=0;a<m;a++){
	         for(int b=0;b<n;b++)
	         arr1[a][b]=arr[c++];    
	     }
	     StringBuffer sb=new StringBuffer();
	     for(int d=0;d<arr.length;d++){
	     switch(dir){
	         case 0:
	                //going left to right
	                for(int i=L;i<=R;i++)
	                sb.append(arr1[T][i]+" ");
	                T++;
	                break;
	         case 1:
	               //top to bottom
	               for(int i=T;i<=B;i++)
	                sb.append(arr1[i][R]+" ");
	                R--;
	                break;
	         case 2:
	                //going right to left
	                for(int i=R;i>=L;i--)
	                sb.append(arr1[B][i]+" ");
	                B--;
	                break;
	         case 3:
	                //going bottom to top
	                for(int i=B;i>=T;i--)
	                sb.append(arr1[i][L]+" ");
	                L++;
	                break;
	     }
	     dir=(dir+1)%4;
	     }
	     System.out.println(sb);
	     
	 }

}
