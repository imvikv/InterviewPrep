package algo.java.randomImpl;

/*
 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

Examples:

Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.  
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"
 * */
public class ReverseArrayWithSpecialchars {

	// driver
	public static void main(String[] args) {
		String s = "Ab,c,de!$";
		reversePrintString(s);
		reversePrintString("a,b$c");
	}

	private static void reversePrintString(String s) {
		char[] c = s.toCharArray();

		for (int i = 0, j = c.length - 1; i < j;) {
			if (isAlphabet(c[i]) && isAlphabet(c[j])) {
				char temp = c[j];
				c[j] = c[i];
				c[i] = temp;
				i++;
				j--;
			}
			if (!isAlphabet(c[i])) {
				i++;
			}
			if (!isAlphabet(c[j])) {
				j--;
			}
		}
		System.out.println(s);
		System.out.println(String.valueOf(c));
	}

	public static boolean isAlphabet(char c) {
		int a = c;
		if ((a >= 65 && a <= 90) || (a >= 97 && a <= 122)) {
			return true;
		}
		return false;
	}
}
