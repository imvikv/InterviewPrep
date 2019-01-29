package gfg.string;

import java.util.HashMap;

/*Questions statment:
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­
drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)*/

public class PalindromePermuation {

	// driver
	public static void main(String[] args) {
		System.out.println(palinDromeChecker("Tact Coa"));
		System.out.println(palinDromeChecker("Tacti Coa"));
		System.out.println(palinDromeChecker("TactCa"));

		System.out.println(palindrome("Tact Coa"));
		System.out.println(palindrome("Tacti Coa"));
		System.out.println(palindrome("TactCa"));
	}

	// Method to implement palinDromeChecker logic with hashMap as frequency
	// keeper

	public static boolean palinDromeChecker(String input) {
		// replace all non-word chars from string

		input = input.replaceAll("\\W", "").toLowerCase();
		// put values and there frequency in hashmap

		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);
			if (null == frequencyMap.get(c)) {
				frequencyMap.put(c, 1);
			} else
				frequencyMap.put(c, frequencyMap.get(c) + 1);
		}
		// below flag will be used to check there can be only one char whose
		// freq is 1 if not so then return false
		boolean singleFlag = false;
		for (Character c : frequencyMap.keySet()) {
			if (singleFlag && frequencyMap.get(c) == 1) {
				return false;
			} else if (frequencyMap.get(c) == 1) {
				singleFlag = true;
			}

		}
		return true;
	}

	public static boolean palindrome(String input) {
		// input = input.replaceAll("\\W", "").toLowerCase();
		int k = input.charAt(0);
		for (int i = 1; i < input.length(); i++) {
			int j = input.charAt(i);
			int l = Character.getNumericValue(j);
			if (l != -1) {
				k = k ^ j;
			}
		}
		if (input.length() % 2 == 0 && k == 0) {
			return true;
		} else {
			if (input.indexOf(k) >= 0) {
				return true;
			}
		}
		return false;
	}

}
