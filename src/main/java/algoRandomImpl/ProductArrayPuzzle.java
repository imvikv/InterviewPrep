package algoRandomImpl;

/*
 * A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}

*/
public class ProductArrayPuzzle {
	// driver
	public static void main(String[] args) {
		int[] arr = new int[] { 8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2 };
		long[] prod = createProductArray(arr);
		for (int i = 0; i < prod.length; i++) {
			System.out.print(prod[i] + " ");
		}

	}

	/**
	 * basically it works like you have two temp arrays with multiplication from
	 * start to end and other temp array from right to left then prod array will
	 * come by multiplication of first and second array to optimize that instead
	 * of creating second temp array we can do same operation which we are doing
	 * in second temp array to same forst temp array and return the same.
	 * 
	 * @param arr
	 * @return
	 */
	private static long[] createProductArray(int[] arr) {
		long[] prod = new long[arr.length];
		prod[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			prod[i] = arr[i - 1] * prod[i - 1];
		}
		long mult = arr[arr.length - 1];
		for (int j = arr.length - 2; j >= 0; j--) {
			prod[j] = mult * prod[j];
			mult = mult * arr[j];
		}
		return prod;
	}
}
