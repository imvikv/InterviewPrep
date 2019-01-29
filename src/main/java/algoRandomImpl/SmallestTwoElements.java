package algo.java.randomImpl;

//Find the smallest and second smallest element in an array
public class SmallestTwoElements {

	// driver
	public static void main(String[] args) {
		printTwoSmallest(new int[] { 12, 13, 1, 10, 34, 2 });
	}

	private static void printTwoSmallest(int[] arr) {
		int len = arr.length;
		int first;
		int sec;
		if (len < 2) {
			System.out.println(arr[0] + " " + arr[0]);
		}
		// handle the case when len is greater or equal to 2 , need to have two
		// smallest with one traversing
		else {
			first = arr[0] > arr[1] ? arr[1] : arr[0];
			sec = arr[0] > arr[1] ? arr[0] : arr[1];

			for (int i = 2; i < len; i++) {
				if (arr[i] < first) {
					sec = first;
					first = arr[i];
				} else if (arr[i] < sec && first != arr[i]) {
					sec = arr[i];
				}
			}
			System.out.println(first + " " + sec);
		}

	}
}
