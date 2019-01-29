package algoRandomImpl;

/*Ceiling in a sorted array
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array

 * */

public class CeilingFloorSortedArray {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 8, 9, 10, 12, 19 };
		int x = 10;
		printCeiling(a, x, 0, a.length - 1);
		printFloor(a, x, 0, a.length - 1);

	}

	/**
	 * searching of ceiling and floor by binary search handle the case till you
	 * have segregated till the last point when start==end means till one
	 * element
	 * 
	 * @param a
	 * @param x
	 * @param start
	 * @param end
	 */
	private static int printCeiling(int[] a, int x, int start, int end) {

		if (start == end) {
			if (a[start] < x) {
				System.out.println("Ceiling = -1");
			} else {
				System.out.println("Ceiling= " + a[start]);
			}
			return start;

		} else {// this is the case to steer in right arary

			int mid = (start + end) / 2;
			if (a[mid] == x) {
				System.out.println("Ceiling= " + a[mid]);
				return mid;
			} else if (a[mid] > x) {
				return printCeiling(a, x, start, mid);
			} else {
				return printCeiling(a, x, mid + 1, end);
			}

		}
	}

	private static int printFloor(int[] a, int x, int start, int end) {

		if (start == end) {
			if (a[start] > x) {
				System.out.println("-1");
			} else {
				System.out.println("Floor= " + a[start]);
			}
			return start;

		} else {// this is the case to steer in right arary

			int mid = (start + end) / 2;
			if (a[mid] == x) {
				System.out.println("Floor= " + a[mid]);
				return mid;
			} else if (a[mid] > x) {
				return printFloor(a, x, start, mid);
			} else {
				return printFloor(a, x, mid + 1, end);
			}

		}
	}

}
