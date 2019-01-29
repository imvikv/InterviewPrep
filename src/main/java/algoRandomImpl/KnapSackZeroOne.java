package algoRandomImpl;

/**
 * @author vermv2
 ** 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 * 
 * reference
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
 */
public class KnapSackZeroOne {

	public static void main(String[] args) {
		KnapSackZeroOne k = new KnapSackZeroOne();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
         k.bottomUpDP(val, wt, 30);
        System.out.println(k.bottomUpDP(val, wt, 30));

	}

	private int bottomUpDP(int[] val, int[] wt, int capacity) {
		int len=val.length;
		//dp array
		int[][] dp= new int[len+1][capacity+1];
		
		//build DP array
		for(int i=0;i<len+1;i++)
		{
			for(int j=0;j<capacity+1;j++)
			{
				//base case for zero case when either the capacity is zero or given array length
				if(i==0||j==0)
					dp[i][j]=0;
				//case when selected wt array element is less or equal to capacity of knapsack
				//wt[i-1] because wt array is started with 0 and dp array all 0 index are 0 already so 
				else if(wt[i-1]<=capacity)
				{
					dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][capacity-wt[i-1]]);
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[len][capacity];
	}

}
