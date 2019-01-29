package algoRandomImpl;


/*Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that 
prints all occurrences of pat[] 
and its permutations (or anagrams) in txt[]. You may assume that n > m. 
Expected time complexity is O(n)

1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
*/
	
public class AnagramSubstringSearch {

	
		public static void main(String[] args) {
			printAnagramIndex("ABCD","BACDGABCDA");
			printAnagramIndex("AABA","AAABABAA");
		}
		
		private  static void  printAnagramIndex(String pattern, String input)
		{
			int[] hashArray=calculateHashForInput(input,pattern);
			int patternHash=calculateHash(pattern);
			for(int i=0;i+pattern.length()<=input.length();i++)
			{
				if(patternHash==hashArray[i])
						{
					System.out.print(i+" ");
						}
			}
			System.out.println();
		}
		
		private static int calculateHash(String s)
		{
			int hashedValue=0;
			for(int i=0;i<s.length();i++)
			{
				hashedValue=hashedValue+(int)s.charAt(i);
			}
			return hashedValue;
		}
		
		/**
		 * @param s
		 * @return
		 */
		private static int[] calculateHashForInput(String s,String pattern)
		{
			int patternLen=pattern.length();
			int[] arr= new int[s.length()];
			arr[0]=calculateHash(s.substring(0, patternLen));
			for(int i=1;i+patternLen<=s.length();i++)
			{
				arr[i]=arr[i-1]+s.charAt(i+patternLen-1)-s.charAt(i-1);
			}
			return arr;
		}
}

