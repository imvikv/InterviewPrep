package algo.java.randomImpl;

public class PalineDromeInt {

	public static void main(String[] args) {
		System.out.println(new PalineDromeInt().isPalindrome(1000000003));

	}
	public boolean isPalindrome(int a) {
		if(a<0)
			return false;
	    
		String s=Integer.toString(a);
		StringBuilder k= new StringBuilder(s);
		String rev=k.reverse().toString();
		if(s.equals(rev))
		{
			return true;
		}
	/*	if(Integer.parseInt(k.toString())==Integer.parseInt(k.reverse().toString()))
		{
			return true;
		}*/
		return false;
	}

}
