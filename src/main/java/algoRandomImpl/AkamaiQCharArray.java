package algoRandomImpl;

import java.util.Arrays;

public class AkamaiQCharArray {

	public static void main(String[] args) {
		String s = "AB%20CD%20EF";
		char[] c = s.toCharArray();

		int j = s.length();

		// shift all the elements from end to front
		for (int k = 0, index = 0; k < s.length();) {
			int l = c[k];
			if (c[k] > 90 || c[k] < 65) {
				// no char element so move to end index
				c[k++] = ' ';
				// shift array to two position left
				for (int m = k; m < s.length() - 2; m++) {
					{
						c[m] = c[m + 2];
					}
					c[m + 1] = ' ';
					c[m + 2] = ' ';
				}
			} else {
				k++;
			}
		}
		System.out.println(Arrays.toString(c));
	}

}
