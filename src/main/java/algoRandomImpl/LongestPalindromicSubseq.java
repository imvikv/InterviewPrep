package algoRandomImpl;

public class LongestPalindromicSubseq {

	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubseq().LPSSlen("BBABCBCAB"));

	}
	
	private int LPSSlen(String a)
	{
		char[] b= a.toCharArray();
		int count =0;
		count=lpscount(b,0,b.length-1);
		return count;
	}

	private int lpscount(char[] b, int i, int j) {
		if(i==j)
		{
			return 1;
		}
		if(i+1==j && b[i]==b[j])
			return 2;
		if(b[i]==b[j])
		{
			return lpscount(b, i+1, j-1)+2;
		}
		else
		{
			return Math.max(lpscount(b, i+1, j), lpscount(b, i, j-1));
		}
		
	}

}
