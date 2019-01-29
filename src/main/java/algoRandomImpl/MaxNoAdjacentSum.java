package algo.java.randomImpl;

//Maximum sum such that no two elements are adjacent

public class MaxNoAdjacentSum {

	// driver programe
	public static void main(String[] args) {
		int[] arr = new int[] { 11, 1, 3, 2, 10, 4, 1 };
		System.out.println(maxSumCalculator(arr, 0));
		System.out.println(maxSumEfficient(arr));
	}

	/**
	 * This Programe will calculate max sum keeping in mid that at every step he
	 * has two options either select or do not select Through recursion
	 * 
	 * @param arr
	 * @return
	 */
	private static int maxSumCalculator(int[] arr, int curr_index) {
		if (curr_index >= arr.length) {
			return 0;
		}
		int firstSum = arr[curr_index] + maxSumCalculator(arr, curr_index + 2);
		int SecSum = maxSumCalculator(arr, curr_index + 1);
		return Math.max(firstSum, SecSum);
	}

	// Efficient algo : two parameters incl , excl : inclusive means if that
	// element is added , so inclusive will become max(exclusive+1, last
	// inclusive) ,
	// exclusive will be last inclusive(as last element was added so exclusive
	// need to ignore current element so max till last point was last inclusive)
	// refer tushor roy video if unclear
	private static int maxSumEfficient(int[] arr) {

		int incl = arr[0], excl = 0;
		for (int i = 0; i < arr.length; i++) {
			int newExcl = Math.max(incl, excl);
			int newIncl = excl + arr[i];
			excl = newExcl;
			incl = newIncl;

		}
		return Math.max(incl, excl);
	}

}
