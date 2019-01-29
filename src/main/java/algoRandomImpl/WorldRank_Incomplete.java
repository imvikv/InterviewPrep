package algoRandomImpl;

/*You have been given a String SS consisting of lowercase alphabets of the English Language. Now, we call a String WW an anagram of another String SS, if we can obtain String SS be rearranging the characters of String WW.

For example , the word "aba""aba" has 33 anagrams i.e ["aba","aab","baa"]["aba","aab","baa"] .

Now, you need to find all the disitnct anagrams of String SS , sort them lexicographically and then print to output the anagram that occurs at the NthNth position in this sorted order.

Can you do it ?

INPUT:

The first line of input contains the number of test cases denoted by T. The next T lines of input contain a string S and a number N.

OUTPUT:

You need to find and print the anagram of the given string which occurs at the $$N^{th} position when they are arranged in lexicographical order.

Constraints:

11 ≤ T ≤ 104104

11 ≤ |S| ≤ 2020

11 ≤ N ≤ 10181018
Sample Input

4
bcda 20
cbad 5
ydvtrs 268
asfda 32

Sample Output

dacb
adbc
srdvyt
dfasa

Explanation

For case 2, one need to find the anagram of "cbad" which occurs at 5th place when arranged in lexicographical order.
// TODO Auto-generated method stub
The anagrams that occur at the first four positions are abcd, abdc, acbd and acdb respectively. The fifth anagram is adbc.*/
public class WorldRank_Incomplete {

	public static void main(String[] args) {

		// print in lexographich order
		printAllPermutaion("abcd");
	}

	private static void printAllPermutaion(String s) {
		for (int i = 0; i < s.length(); i++) {
			String pre = s.substring(0, i + 1);
			perm1("", s);
		}

	}

	private static void perm1(String prefix, String s) {
		int n = s.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
		}

	}

	/*
	 * private static char findPermuation(String pre, int i, String s) { if (i
	 * == s.length() - 1) { return s.charAt(i); } else { //
	 * System.out.println(pre+); }
	 * 
	 * }
	 */
}
