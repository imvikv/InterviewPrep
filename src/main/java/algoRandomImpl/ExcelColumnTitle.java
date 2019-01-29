package algo.java.randomImpl;

import java.util.HashMap;
import java.util.Map;

/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class ExcelColumnTitle {
	public static void main(String[] args) {
		System.out.println(new ExcelColumnTitle().convertToTitle(468096));
	}
	public String convertToTitle(int a) {
	int count=1;
	int value=26;
	String k="";
	while(value<a)
	{
		count++;
		value=value*26;
		
	}
	Character c=65;
	Map<Integer, Character> alp= new HashMap<>();
	for(int i=1 ;i<=26;i++)
	{
		alp.put(i, c);
		c++;
	}
	value=value/26;
	int divison=value;
	for(int i=1;i<=count;i++)
	{
		int index=a/divison;
		if(a-divison*index==0 && divison !=1)
		{
			index=index-1;
		}
		k=k+alp.get(index);
		a=a-divison*index;
//		value=value/26;
		divison=divison/26;
	}
	
	return k;
	}
}
