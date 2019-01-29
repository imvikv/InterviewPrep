package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://practice.geeksforgeeks.org/problems/minimum-platforms/0

/*input 
2
35
635 1032 632 941 1141 1509 1359 128 123 626 313 350 853 1551 54 123 357 1500 334 1315 131 1008 33 926 907 932 452 127 704 1854 1718 1924 1337 623 720
1202 2100 2151 941 1751 1549 1411 949 1500 647 2105 1350 1552 2300 2022 1238 2013 1543 2300 1332 2125 1300 200 941 924 1030 800 2010 755 1857 1829 2335 1348 1700 1500
79
6 552 244 936 151 1604 1110 301 1448 529 1125 930 236 1651 640 1712 1042 305 1032 222 756 1722 1954 503 1515 1422 1632 727 1626 1635 137 341 601 1 1439 401 1756 126 1126 1613 9 1717 820 19 149 928 1525 1031 704 102 1 1237 333 430 1242 546 1433 305 1505 553 553 1129 1638 1528 534 1800 1950 538 1705 732 821 256 838 1717 247 35 132 1730 1522
1448 1200 700 1600 1818 1608 1128 1523 1539 543 1141 1158 244 2037 1958 1734 1054 838 1040 900 1928 1755 2027 2026 1552 1609 1633 800 1639 1652 1100 2309 614 1611 1518 1331 2235 1705 1130 1620 200 2000 855 600 854 930 1639 1053 2158 1317 1727 2053 900 528 1254 555 1454 2300 1509 1700 1800 1834 1709 1557 1924 1831 1956 557 1705 951 2300 2138 1334 1746 1900 245 1700 2101 2359
*/public class MinmumPlatform {


	public static void main (String[] args) throws IOException 
	 {
	
	      // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase 
        int t = Integer.parseInt(br.readLine()); 
  
        while (t-- > 0) { 
            // n : size of array 
            int n = Integer.parseInt(br.readLine().trim()); 
  
            // Declaring array 
            int arr[] = new int[n]; 
            int arr1[] = new int[n];
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            
            // array elements input 
            for (int i = 0; i < n; i++) 
                arr[i] = Integer.parseInt(strs[i]); 
            
            
            String line2 = br.readLine(); 
            String[] strs2 = line2.trim().split("\\s+"); 
            
            // array elements input 
            for (int i = 0; i < n; i++) 
                arr1[i] = Integer.parseInt(strs2[i]); 
  
  
            // Calling Functions to segregate Array elements 
	        function(arr,arr1);
			/*
			StringBuffer sb = new StringBuffer(); 
            for (int i = 0; i < n; i++) 
                sb.append(arr[i] + " "); 
  
            // finally printing the string 
            System.out.println(sb); 
			*/ 
	    }
	
	 }
	 public static void  function(int[] arr1,int[] arr2)
	 {
	     
	     int[] arr=new int[2361];
	     int max=0;
	     for(int i=0;i<arr1.length;i++)
	     {
	         //extra handling for wrong case that when start and end time are same
	         if(arr1[i]==arr2[i]) arr[arr1[i]]+=1;
	         for(int j=arr1[i];j<arr2[i];j++)
	         {
	             arr[j]+=1;
	             if(max<arr[j])
	             max=arr[j];
	         }
	     }
	     System.out.println(max);
	     
	 }

}
