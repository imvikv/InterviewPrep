package algo.java.randomImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
	//	System.out.println(new TwoSum().twoSum(new int[] {2, 7, 11, 15},9));
		System.out.println(new TwoSum().twoSum(new int[] {-3,4,3,90},0));
		

	}
	   public int[] twoSum(int[] nums, int target) {
	        int[] res= new int[2];       
	        Map  nmap= new HashMap<>();
	        int k=0;
	    for(int i=0;i< nums.length;i++)
	    {
	        nmap.put(nums[i],i);
	    }
	    for (int j=0;j<nums.length;j++)
	    {
	    	Boolean OtherPartexist=nmap.containsKey(target-nums[j]);
	       if(OtherPartexist){
	    	   k=(int)nmap.get(target-nums[j]);
	    	   if(j!=k)
	    	   {
	    		   res[0]=j;
		           res[1]=k;
		           break;
	    	   }
	       }
	    	
	       
	    }
	    return res;
	 }
    
}
