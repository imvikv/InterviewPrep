package algoRandomImpl;

public class CheckMajorityInSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 3, 3, 3, 10 };
		int len = arr.length;
		int value = 3;
		int firstIndex = binarySearchFirstIndex(arr, value, 0, arr.length - 1);
		if (firstIndex + len / 2 >= arr.length / 2 && arr[firstIndex + len / 2] == value) {
			System.out.println(true);
		} else
			System.out.println(false);

	}

	private static int binarySearchFirstIndex(int[] arr, int value, int start, int end) {

		if (end >= start) {
			int mid = (start + end) / 2;
			if (arr[mid] == value && (mid == 0 || arr[mid - 1] < value)) {
				return mid;
				// >= is crucial condition means you want to search in lower
				// half of the array even if value is arr[mid]
			} else if (arr[mid] >= value) {
				return binarySearchFirstIndex(arr, value, start, mid - 1);
			} else {
				return binarySearchFirstIndex(arr, value, mid + 1, end);
			}
		}
		return -1;

	}

}
