package algoRandomImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.*/
public class LargestNumber {

	public static void main(String[] args) {
		System.out.println(new LargestNumber().largestNumber(new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9))));
		System.out.println(new LargestNumber().largestNumber(new ArrayList<>(Arrays.asList(0,0,0))));

	}

	public String largestNumber(final List<Integer> a) {
		List<Integer> b=new ArrayList<>();
		b.addAll(a);
		Collections.sort(b, new CompareImpl());
		/*for (int i = 0; i < a.size() - 1; i++) {

			for (int j = i + 1; j < a.size(); j++) {
				if (compare(b.get(i), b.get(j))) {
					Collections.swap(b, i, j);
					Collections.sort(list, );

				}
			}
		}*/
		StringBuilder s = new StringBuilder("");
		for (int k = 0; k < a.size(); k++) {
			s = s.append(b.get(k).toString());
		}
		String s1=s.toString();
		if(s1.replaceAll("0", "").equals(""))
		{
			return "0";
		}
		return s1;
	}

	// below was needed to done to pass to sort of collection

	class CompareImpl implements Comparator<Integer>
	{

		@Override
		public int compare(Integer a, Integer b) {
			String a1=a.toString().concat(b.toString());
			String a2=b.toString().concat(a.toString());
			return a2.compareTo(a1);
		}
		
	}
}
