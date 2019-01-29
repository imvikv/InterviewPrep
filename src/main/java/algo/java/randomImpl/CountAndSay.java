package algo.java.randomImpl;

public class CountAndSay {

	public String countAndSay(int A) {
		String[] b = new String[A + 1];
		b[1] = "1";
		b[2]="11";
		for (int i = 3; i <= A; i++) {
			// read the last value in string array
			String k = b[i - 1];
			// now we can read this string
			
			int old = -1;
			int newv = -1;
			int count = 0;
			String finalv = "";
			for (char c : k.toCharArray()) {
				newv = c - '0';
				if (newv == old) {
					count++;
				} else {
					if (count != 0) {
						finalv = finalv + Integer.toString(count) + Integer.toString(old);										
					}
					count = 1;
					old = newv;
					
				}

			}
			if (count != 0) {
				finalv = finalv + Integer.toString(count) + Integer.toString(old);										
			}
			b[i]=finalv;
		}
		return b[A];

	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(5));

	}

}
