package algoRandomImpl;

/*Question: There are 2 sorted arrays A and B of size n each. 
Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))*/

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		int arr1[] = new int[] { 4, 8, 13, 18 };
		int arr2[] = new int[] { 10, 11, 12, 15 };
		// int arr1[] = new int[] { 1, 12, 15, 26, 38 };
		// int arr2[] = new int[] { 2, 13, 17, 30, 45 };
		int len1 = arr1.length;
		int len2 = arr2.length;
		System.out.println(medianSortedBruteforce(arr1, arr2));
		// double k = median(arr1, 0, len1 - 1, arr2, 0, len2 - 1);
		double k = findMedianSortedArrays(arr1, arr2);
		System.out.println(k);
	}

	public static double median(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2) {
		int m1 = (l1 + h1) / 2;
		int m2 = (l2 + h2) / 2;

		if (h1 - l1 == 1) {
			return (double) (Math.max(arr1[l1], arr2[l2]) + Math.min(arr2[h1], arr2[h2])) / 2;
		}
		if (arr1[m1] > arr2[m2]) {
			return median(arr1, l1, m1, arr2, m2, h2);
		} else
			return median(arr1, m1, h1, arr2, l2, m2);
	}

	static double medianSortedBruteforce(int[] arr1, int[] arr2) {

		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] arr = new int[len1 + len2];
		for (int i = 0, j = 0, k = 0; k < arr.length;) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i = (i + 1 < len1 ? i + 1 : i);
				k++;
			} else {
				if (j < len2) {
					arr[k] = arr2[j];
					j = (j + 1 < len2 ? j + 1 : j);
					k++;
				}
			}
		}
		int n = arr.length;
		return (double) (arr[(n - 1) / 2] + arr[n / 2]) / 2;
	}

	// static double medianBinarySearch(int[] arr1, int[] arr2) {
	//
	// }

	/**
	 * works for both sorted and unsorted
	 * 
	 * median of an array is --> = (L + R)/2 = (A[(N-1)/2] + A[N/2])/2
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int N1 = nums1.length;
		int N2 = nums2.length;
		if (N1 < N2)
			return findMedianSortedArrays(nums2, nums1); // Make sure nums2 is
															// the
															// shorter one.

		if (N2 == 0)
			return ((double) nums1[(N1 - 1) / 2] + (double) nums1[N1 / 2]) / 2; // If
																				// nums2
																				// is
																				// empty

		int lo = 0, hi = N2 * 2;
		while (lo <= hi) {
			int mid2 = (lo + hi) / 2; // Try Cut 2
			int mid1 = N1 + N2 - mid2; // Calculate Cut 1 accordingly

			double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2]; // Get
																					// L1,
																					// R1,
																					// L2,
																					// R2
																					// respectively
			double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
			double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

			if (L1 > R2)
				lo = mid2 + 1; // A1's lower half is too big; need to move C1
								// left (C2 right)
			else if (L2 > R1)
				hi = mid2 - 1; // A2's lower half too big; need to move C2 left.
			else
				return (Math.max(L1, L2) + Math.min(R1, R2)) / 2; // Otherwise,
																	// that's
																	// the right
																	// cut.
		}
		return -1;
	}
}
