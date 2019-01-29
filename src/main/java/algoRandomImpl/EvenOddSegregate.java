package algo.java.randomImpl;

/*
 * Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.

Example

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3} 
In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.
 * */

public class EvenOddSegregate {

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 34, 45, 9, 8, 90, 3 };
		arr = segregateEvenOdd(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * thinking of having two index one from start and one from end and move
	 * them once i have odd at first index and stop and wait for second ondex to
	 * get even values and then swap and move the indexes
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] segregateEvenOdd(int[] arr) {
		int len = arr.length;
		for (int i = 0, j = len - 1; i < j;) {
			if (arr[i] % 2 == 0) {
				i++;
			}
			if (arr[j] % 2 != 0) {
				j--;
			}
			if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j--;
			}
		}
		return arr;
	}

}
