package algo.java.randomImpl;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		System.out.println(new ExcelColumnNumber().titleNumber("BBC"));
	}

	public int titleNumber(String s) {
		int sum = 0;
		Character l = 'A';
		Map<Character, Integer> pool = new HashMap<>();

		for (int i = 1; i <= 26; i++, l++) {
			pool.put(l, i);
		}
		char[] arr=s.toCharArray();
		for(int i=s.length()-1;i>=0;i--)
		{
			sum+=getIndividualValue(pool.get(arr[i]), s.length()-i-1);
		}
		return sum;
	}

	static int getIndividualValue(int value, int index) {
		index++;
		int mult=1;
		while(index>1)
		{
			mult=mult*26;
			index--;
		}
		
		return mult*value;
	}
}
