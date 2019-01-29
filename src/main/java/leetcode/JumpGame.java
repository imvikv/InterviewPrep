package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
	
	   public boolean canJump(int[] nums) {
		     
	        boolean[] arr= new boolean[nums.length];
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            int count=nums[i]+1;
	            for(int j=i;count>0&&j<nums.length;j++)
	            {
	                if(i==0||arr[i])
	                {
	                    arr[j]=true;
	                    count --;
	                }
	            }
	        }
	    return arr[nums.length-1];
	    }
public static void main(String[] args) {
	System.out.println(new JumpGame().canJump(new int[] {2,3,1,1,4}));
}
}
