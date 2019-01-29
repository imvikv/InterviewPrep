package crack.coding.interview.strings;

/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
->
pales, pale -> true
pale, bale ->  true
pale, bake -> false

*/
public class OneAway {

	// driver
	public static void main(String[] args) {
		System.out.println(oneAwayCheker("pales", "pale"));
		System.out.println(oneAwayCheker("pale", "bale"));
		System.out.println(oneAwayCheker("pale", "bake"));
		System.out.println(oneAwayCheker("pale", "bae"));
		System.out.println(oneAwayCheker("pale", "ale"));
		System.out.println(oneAwayCheker("pale", "ale"));
		System.out.println(oneAwayCheker("pale", "paless"));

	}

	/**
	 * Crux of the logic is in all of the cases one edit or zero edit or replace
	 * a char we need to just maintain one flag to check if i already found the
	 * anomaly or not if yes next anomaly can't occur
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean oneAwayCheker(String a, String b) {

		boolean misMatchFound = false;
		String max = a.length() > b.length() ? a : b;
		String min = a == max ? b : a;
		if (Math.abs(a.length() - b.length()) > 1)
			return false;
		for (int i = 0, j = 0; i < min.length();) {
			if (min.charAt(i) != max.charAt(j)) {
				if (misMatchFound) {
					return false;
				}
				if (a.length() == b.length()) {
					i++;
					j++;
				} else {
					j++;
				}
				misMatchFound = true;
			} else {
				i++;
				j++;
			}

		}
		return true;

	}

}
