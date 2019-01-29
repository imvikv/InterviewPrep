package crack.coding.interview.strings;

/*String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).*/

public class StringCompression {

	// driver
	public static void main(String[] args) {
		printCompression("aabcccccaaab");
		printCompression("abc");
	}

	private static void printCompression(String s) {
		StringBuilder s1 = new StringBuilder("");
		char prev = s.charAt(0);
		s1.append(prev);
		int count = 1;
		// loop to iterate and form compression string
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prev) {
				count++;
			} else {
				s1.append(count);
				s1.append(s.charAt(i));
				prev = s.charAt(i);
				count = 1;

			}
		}
		if (s.equals(s1.toString().replaceAll("1", ""))) {
			System.out.println(s);
		} else {
			System.out.println(s1.toString());
		}
	}
}
