package algo.java.randomImpl;

import java.util.Arrays;

/*Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 4
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
 * */
public class CountTripletsWithMinSum {

	// driver
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 1, 3, 4, 7 };
		int k = 12;
		System.out.println(findAllTripletsWithSumLessThanGivenValue(arr, k));
	}

	/**
	 * sort the array and then fix one index in one loop and run two other index
	 * in second loop
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	private static int findAllTripletsWithSumLessThanGivenValue(int[] arr, int sum) {
		int count = 0;
		int len = arr.length;
		int i = 0, j = i, k = i;
		Arrays.sort(arr);

		// loop from 1 to n-2
		for (; i < len - 2; i++) {
			for (j = i + 1, k = len - 1; j < k;) {
				if (arr[i] + arr[j] + arr[k] <= sum) {
					k--;
				} else {
					count += k - j;
					j++;
				}
			}
		}
		return count;
	}

}
