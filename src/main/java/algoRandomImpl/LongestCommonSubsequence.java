package algoRandomImpl;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String a = "ABCBDAB";
		String b = "BDCABA";
		String e = b;
		char[] c = a.toCharArray();
		char[] d = b.toCharArray();

		int  index2 = 0;		
		for (int j = 0; j < c.length; j++) {
			StringBuilder s = new StringBuilder();
			index2 = 0;
			for (int i = 0; i < c.length; i++) {
				int l = search(b, c[i], index2);
				if (l != -1 && l > index2 || l == 0) {
					index2 = l;
					s.append(c[i]);
				}
			}
			System.out.println(s);
			c = a.substring(j + 1).toCharArray();
		}
		long end = System.currentTimeMillis();
		System.out.println("execution time " + (end - start) + "ms");
	System.out.println(" max length is " + LCS(a.toCharArray(),e.toCharArray(),a.length(),e.length()));
	}

	static int search(String b, char c, int index) {
		char[] s = b.toCharArray();
		for (int i = index; i < s.length; i++) {
			if (s[i] == c) {
				return i;
			}
		}
		return -1;
	}

	// implementation with DP with max length
	public static int LCS(char[] a,char[] b, int len1,int len2)
	{
		if(len1==0||len2==0)
		{
			return 0;
		}
		if(a[len1-1]==b[len2-1])
		{
			System.out.print(a[len1-1]);
			return 1+LCS(a,b,len1-1,len2-1);
		}
		return max(LCS(a,b,len1,len2-1),LCS(a,b,len1-1,len2));
	}

	private static int max(int a, int b) {
		return (a>b)?a:b;
	}
	
}
