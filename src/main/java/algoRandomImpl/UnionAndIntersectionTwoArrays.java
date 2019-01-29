package algoRandomImpl;

/*Union and Intersection of two sorted arrays
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6}
Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.
1:05
 */
public class UnionAndIntersectionTwoArrays {

	// driver
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 3, 4, 5, 7 };
		int[] arr2 = new int[] { 2, 3, 5, 6 };
		printUnion(arr1, arr2);
		System.out.println();
		printIntersection(arr1, arr2);
		System.out.println();
		printIntersectionBSearch(arr1, arr2);
	}

	private static void printIntersectionBSearch(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] s = len1 < len2 ? arr1 : arr2;
		int[] b = len1 > len2 ? arr1 : arr2;
		for (int i = 0; i < s.length; i++) {
			if (-1 != searchAndPrintIntersection(s[i], b, 0, b.length - 1))
				System.out.print(s[i] + " ");
		}
	}

	private static int searchAndPrintIntersection(int value, int[] b, int start, int end) {
		if (start > end) {
			return -1;
		} else {
			int mid = (start + end) / 2;
			if (b[mid] == value) {
				return mid;
			} else if (b[mid] > value) {
				return searchAndPrintIntersection(value, b, start, mid - 1);
			} else {
				return searchAndPrintIntersection(value, b, mid + 1, end);
			}
		}

	}

	private static void printIntersection(int[] arr1, int[] arr2) {

		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			} else {
				System.out.print(arr2[j++] + " ");
				i++;
			}
		}
	}

	/**
	 * In case of union please apply below strategy print till either of the
	 * arrays all values are printed then print the array whose values are left,
	 * it would be simpler than handling both of the arrays together
	 * 
	 * @param arr1
	 * @param arr2
	 */
	private static void printUnion(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i++] + " ");
			} else if (arr2[j] < arr1[i]) {
				System.out.print(arr2[j++] + " ");
			} else {
				System.out.print(arr2[j++] + " ");
				i++;
			}
		}
		while (i < arr1.length) {
			System.out.print(arr1[i++] + " ");
		}
		while (j < arr2.length) {
			System.out.print(arr2[j++] + " ");
		}
	}

}
