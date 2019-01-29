package algo.java.randomImpl;

/*Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] 
then returned value should be 2 (Diff between 7 and 9)
http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
*/

public class Maxdifference {

	public static void main(String[] args) {
		int[] arr = new int[] { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328,
				437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395,
				204, 312, 323 };
		// int[] arr1 = new int[] { 174, 165, 142, 212, 254, 369, 48, 145, 163,
		// 258, 38, 360, 224, 242, 30, 279, 317, 36,
		// 191, 343, 289, 107, 41, 443, 265, 149, 447, 306, 391, 230, 371, 351,
		// 7, 102 };
		int[] arr1 = new int[] { 174, 165, 5, 3, 1, 78 };
		printMaxDiff(arr1);

	}

	/**
	 * this method will work on principle that min will be allocated to least
	 * value fetched and diff value will be changed only in case of diff is more
	 * than previously calculated so this makes sure that latest value of i gets
	 * assigned to max and diff is calculated
	 * 
	 * @param arr
	 */
	private static void printMaxDiff(int[] arr) {
		int min = 0, max = 1, diff = arr[max] - arr[min];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[min] > diff) {
				max = i;
				// this was the trick , you need to calculate diff only when
				// current element to min will be more
				diff = arr[max] - arr[min];
			}
			if (arr[i] < arr[min]) {

				min = i;

			}

		}
		System.out.println(diff + " " + arr[min] + " " + arr[max]);
	}

}
