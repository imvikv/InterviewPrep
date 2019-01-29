/**
 * 
 */
package algoRandomImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author vikas.verma
 *Given two strings str1 and str2 and below operations that can performed on str1. 
 *Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
Insert
Remove
Replace
All of the above operations are of equal cost.
Examples:
Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.
Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a
 */
public class EditDistance {

	public static void main(String[] args) {
		List  k= new LinkedList();
	}
	public int minEdits(String s1, String s2, int len1, int len2)
	{
		//edge case
		if(len1==0)
		{
			return len2;
		}
		if(len2==0)
		{
			return len1;
		}
		// if end chars are same then 
		if(s1.charAt(len1-1)==s2.charAt(len2-1))
		{
			return minEdits(s1, s2, len1-1, len2-1);
		}
		else
		{
			return Math.min(Math.min(minEdits(s1, s2, len1, len2-1),minEdits(s1, s2, len1-1, len2)),minEdits(s1, s2, len1-1, len2-1));
		}
	}
}
