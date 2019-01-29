package algoRandomImpl;

// rotate the array of n elements by d elements

public class RotateArray {

	// driver programe
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 4;
		// rotateArrayByReversing(arr, k);
		// leftRotate(arr, k);
		int gcd = findGcd(arr.length, k);
		rotateArray(arr, gcd, k);
	}

	/*
	 * static void leftRotate(int arr[], int d) { int n = arr.length; int i, j,
	 * k, temp; for (i = 0; i < gcd(d, n); i++) { move i-th values of blocks
	 * temp = arr[i]; j = i; while (1 != 0) { k = j + d; if (k >= n) k = k - n;
	 * if (k == i) break; arr[j] = arr[k]; j = k; } arr[j] = temp; }
	 * 
	 * }
	 * 
	 */

	/**
	 * this works simply by reversing the array individually broken at 0 to k-1
	 * and k-1 to end and reverse the whole array
	 * 
	 * @param arr
	 * @param k
	 */
	private static void rotateArrayByReversing(int[] arr, int k) {
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * it works on a principle of rotation , the outer loop will run the gcd of
	 * array length and number of rotation inner loop will run until every
	 * element in the set which is decided by gcd is placed in right location
	 * 
	 * @param arr
	 * @param gcd
	 * @param k
	 */
	private static void rotateArray(int[] arr, int gcd, int k) {
		// gcd is the set length for which the rotation will happen
		int len = arr.length;
		for (int i = 0; i < gcd; i++) {
			int temp = arr[i];
			int j = i;
			int l = -1;
			while (true) {
				l = ((j + k) % len);
				if (l == i) {
					break;
				}
				arr[j] = arr[l];
				j = l;
			}
			arr[j] = temp;
		}
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * This method finds the dcs of two elements
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int findGcd(int a, int b) {

		int low = a < b ? a : b;
		int high = a < b ? b : a;

		if (high % low == 0) {
			return low;
		} else {
			return findGcd(high, high % low);
		}
	}

}
