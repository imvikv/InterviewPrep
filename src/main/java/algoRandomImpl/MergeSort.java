package algo.java.randomImpl;

public class MergeSort {

	// driver
	public static void main(String[] args) {
		int[] a = new int[] { 2, 9, 7, 1, 6, 3 };
		int[] temp = new int[a.length];
		mergeSort(a, temp, 0, a.length - 1);

	}

	private static void mergeSort(int[] a, int[] temp, int left, int right) {

		if (right > left) {
			int mid = (left + right) / 2;
			mergeSort(a, temp, left, mid);
			mergeSort(a, temp, mid + 1, right);
			merge(a, temp, left, mid, right);

		}

	}

	private static void merge(int[] a, int[] temp, int left, int mid, int right) {
		// this is the merging process of arr left to mid and mid+1 to right
		// assume both and right are sorted arrays
		// you can either right recursive algo or iterative algo for merging
		int i = left;
		int k = left;
		int j = mid + 1;
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];

			} else {
				temp[k++] = a[j++];

			}
		}
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		for (int l = left; l <= right; l++) {
			a[l] = temp[l];

		}
	}

}
