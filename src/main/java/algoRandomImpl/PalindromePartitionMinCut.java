package algo.java.randomImpl;

/*
 *Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. 
 *For example, â€œaba|b|bbabb|a|b|abaâ€? is a palindrome partitioning of â€œababbbabbababaâ€?. Determine the fewest cuts needed for palindrome 
 *partitioning of a given string. For example, minimum 3 cuts are needed for â€œababbbabbababaâ€?. The three cuts are â€œa|babbbab|b|ababaâ€?. 
 *If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed. 
 *
 * https://www.youtube.com/watch?v=WPr1jDh3bUQ
 * */
public class PalindromePartitionMinCut {

	// driver
	public static void main(String[] args) {
		String s = "ababbbabbababa";
		// we are going to form boolean array first of all combination either
		// palindrome or not
		int len = s.length();
		boolean[][] n = new boolean[len][len];
		n = fillbooleanPalindromeArray(s, n);
		int cut[] = new int[len];
		cut = fillCutArray(n, s, cut);
		System.out.println(cut[len - 1]);
	}

	/**
	 * boolean 2d array to store that all combination are palindrome or not , by
	 * using DP where we find the current value by values which we already
	 * calculated for ex: length of 3 string palindrome will be calculated the
	 * values of length of two values
	 * 
	 * it will be divided in two section for length 1 already assume palindrome
	 * length 2 by checking first and end
	 * 
	 * for len =3 and more by checking first and last and then smaller string
	 * value from a;ready calculated boolean array
	 * 
	 * @param s
	 * @param n
	 * @return
	 */
	private static boolean[][] fillbooleanPalindromeArray(String c, boolean[][] n) {
		char[] s = c.toCharArray();
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

	/**
	 * This method will fill the cut array based on filled values in boolean
	 * array first it will check if the value is already boolean
	 * 
	 * @param n
	 * @param s
	 * @param cut
	 * @return
	 */
	private static int[] fillCutArray(boolean[][] n, String s, int[] cut) {

		for (int i = 0; i < s.length(); i++) {
			int temp = Integer.MAX_VALUE;
			// for 1 length string
			if (n[0][i]) {
				// no cut required for 1 length string
				cut[i] = 0;
			} else {
				// the case to check for bigger length values lets say string is
				// niti , i=3 and j will start from 0 to 2 , we needed j+1
				// because 0,3 is already done in if case
				for (int j = 0; j < i; j++) {
					if (n[j + 1][i] && temp > cut[j] + 1) {
						temp = cut[j] + 1;
					}
				}
				cut[i] = temp;

			}
		}
		return cut;
	}

}
