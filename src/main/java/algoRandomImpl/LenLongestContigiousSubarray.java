package algoRandomImpl;

/*Given an array of integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

In the previous post, we have discussed a solution that assumes that elements in given array are distinct. Here we discuss a solution that works even if the input array has duplicates.*/

class LenLongestContigiousSubarray {
	// driver programe
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 11, 10, 10, 14, 10, 10, 13 };
		System.out.println(" longest subsequence is " + lenoflongestSubArray(arr));

	}

	public static int lenoflongestSubArray(int[] arr) {

		int count = 0, tempCount = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			// assuming decreasing order

			if ((arr[i] + 1) == arr[i + 1]) {
				tempCount++;
			} else {
				tempCount = 0;
			}
			if (count < tempCount) {
				count = tempCount;
			}
		} // end for loop
		return count + 1;
	}

}