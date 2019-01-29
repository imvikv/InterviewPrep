package algo.java.randomImpl;

public class ProductOfSubArray {

	public static void main(String[] args) {
//		int a[]= new int[] {2,3,-2,4}; 
		int a[]= new int[] {2,-5,-2,-4,3}; 
//		int a[]= new int[]{6,3,-10,0,2};
		System.out.println(new ProductOfSubArray().maxProduct(a));
	}
	 public int maxProduct(int[] nums) {     
	       int max_so_far=nums[0];
	         int max_now=nums[0];
	        int max_neg=nums[0];
	        for(int i=1;i<nums.length;i++)
	        {
	            if(nums[i]==0)
	            {
	             max_so_far=Math.max(max_so_far,nums[i]); 
	                max_neg=1;
	                
	            }
	             else if(nums[i]<0)
	             {
	                 max_neg=max_neg*nums[i];
	               max_so_far=Math.max(max_so_far,max_neg);
	                 max_now=1;
	             }
	             else{
	                 max_neg=max_neg*nums[i];
	                 max_now=Math.max(max_now*nums[i],nums[i]);
	                 max_so_far=Math.max(max_now,max_so_far);
	                 max_so_far=Math.max(max_neg,max_so_far);
	             }
	            }
	          return max_so_far;
	    }
}
