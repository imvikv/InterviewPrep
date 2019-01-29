package algoRandomImpl;

/*
 * Count Inversions in an array | Set 1 (Using Merge Sort)
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
*/
public class InversionCountArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328,
				437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395,
				204, 312, 323 };
		int temp[] = new int[arr.length];
		int count = countInversion(arr, temp, 0, arr.length - 1);
		System.out.println(count);
	}

	public static int countInversion(int[] arr, int[] temp, int left, int right) {

		int count = 0;
		if (right > left) {
			int mid = (left + right) / 2;
			count = countInversion(arr, temp, left, mid);
			count += countInversion(arr, temp, mid + 1, right);
			count += merge(arr, temp, left, mid, right);
		}
		return count;
	}

	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		int count = 0;
		while (i <= mid && j <= right) {
			if (arr[i] > arr[j] && i < j) {
				temp[k++] = arr[j++];
				// this is very critical
				count = count + (mid - i + 1);
			} else {
				temp[k++] = arr[i++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		for (int l = left; l <= right; l++) {
			arr[l] = temp[l];
		}

		return count;
	}
}
