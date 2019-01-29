package algoRandomImpl;

/*
 * Given a string, find all possible palindromic partitions of given string.

Example:
nitin

n i t i n
n iti n
nitin
 * */
/**
 * Basically the apporach is solving this with brute force takes about o(n^3) ,
 * we need to solve that in less than that case so we are going to build one
 * boolean 2d array to store that all combination are palindrome or not , by
 * using Partial DP where we find the current value by values which we already
 * calculated for ex: length of 3 string palindrome will be calculated the
 * values of length of two values
 * 
 * @author vikas
 *
 */
public class PrintPossiblePalindromePartitions {

	public static void main(String[] args) {
		String s = "nitin";
		int len = s.length();
		boolean[][] n = new boolean[len][len];
		n = fillBooleanArrayWithPalindromeValues(s.toCharArray(), n);
		printPossiblePalindromeSub(n, s);
	}

	private static boolean[][] fillBooleanArrayWithPalindromeValues(char[] s, boolean[][] n) {

		int len = s.length;
		// for string len 1
		for (int i = 0; i < len; i++) {
			n[i][i] = true;
		}
		// for len2 strings
		for (int i = 0; i < len - 1; i++) {
			if (s[i] == s[i + 1]) {
				n[i][i + 1] = true;
			} else {
				n[i][i + 1] = false;
			}
		}

		// for len3 and more subStrings, basic logic is match first and last
		// element and then get the smaller string boolean value from boolean
		// array
		for (int cur_len = 3; cur_len <= len; cur_len++) {
			for (int i = 0; (i + cur_len) <= len; i++) {
				int j = i + cur_len - 1;
				// checking if end chars match
				if (s[i] == s[j] && n[i + 1][j - 1]) {
					n[i][j] = true;
				} else {
					n[i][j] = false;
				}
			}
		}

		return n;
	}

	private static void printPossiblePalindromeSub(boolean[][] n, String s) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				if (n[i][j]) {
					System.out.print(s.substring(i, j + 1) + " ");
				}
			}
		}
	}

	// private static boolean isPalindrome(char[] c, int start, int end) {
	//
	// for (int i = start, j = end; i < j;) {
	// if (c[i] == c[j]) {
	// i++;
	// j--;
	// } else {
	// return false;
	// }
	// }
	// return true;
	// }
}
