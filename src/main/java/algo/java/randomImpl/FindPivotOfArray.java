package algo.java.randomImpl;

/*Search an element in a sorted and rotated array
given an array find the rotation point
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10   
Output : Found at index 3
*/

public class FindPivotOfArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		// search without pivot
		System.out.println(findElement(arr, 0, arr.length - 1, 3));
		int pivot = finDPivotBinarySearch(arr, 0, arr.length - 1);
		int key = 2;
		if (arr[pivot] == key) {
			System.out.println(pivot);
		}
		if (arr[0] <= key) {
			System.out.println(binarySearch(arr, 0, pivot - 1, key));
		} else
			System.out.println(binarySearch(arr, pivot + 1, arr.length - 1, key));
	}

	public static int binarySearch(int[] arr, int start, int end, int key) {

		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid] < key) {
			start = mid + 1;
		} else
			end = mid - 1;

		return binarySearch(arr, start, end, key);
	}

	public static int finDPivotBinarySearch(int[] arr, int start, int end) {

		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}
		if (arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (arr[start] < arr[mid]) {
			start = mid + 1;
		} else
			end = mid - 1;
		return finDPivotBinarySearch(arr, start, end);
	}

	/**
	 * remeber u need to find out the array partition is sorted or not by
	 * checking boundary elements in increasing order
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param key
	 * @return
	 */
	public static int findElement(int[] arr, int start, int end, int key) {
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (start > end) {
			return -1;
		}
		// check if first part of array is sorted or not
		if (arr[start] < arr[mid]) {
			// check if element exist in this section
			if (key >= arr[start] && key < arr[mid]) {
				return findElement(arr, start, mid - 1, key);
			} else {
				return findElement(arr, mid + 1, end, key);
			}
		}
		// if start to mid is not sorted means the pivot exist in between start
		// to mid , so other partition of array would be sorted ,then search for
		// in sorted place first
		// checking if key belong to right partition
		if (key >= arr[mid + 1] && key <= arr[end]) {
			return findElement(arr, mid + 1, end, key);
		}
		// else search in unsorted array same way
		else {
			return findElement(arr, start, mid - 1, key);
		}
	}

}