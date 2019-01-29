package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//https://www.interviewbit.com/problems/add-one-to-number/
/*Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.*/
public class AddOneToNumber {

	public static void main(String[] args) {

		System.out.println(
				new AddOneToNumber().plusOne(new ArrayList<>(Arrays.asList(0,0,0))));

	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

		int countOf9 = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == 0) {
				a.remove(i);
				i--;
			}
			else
				break;
		}
		for(int i = 0; i < a.size(); i++)
		{
			if(a.get(i)==9)
			{
				countOf9++;
			}
		}
		int newSize = a.size();
		if (countOf9 == a.size()) {
			newSize += 1;
		}
		ArrayList<Integer> z = new ArrayList<>(newSize);
		if (a.size() != newSize) {
			z.add(1);
			for (int i = 1; i < newSize; i++) {
				z.add(0);
			}
			return z;
		} else {
			boolean carryFlag = true;
			for (int k = newSize - 1; k >= 0; k--) {
				int value = a.get(k);
				if (carryFlag) {
					value += 1;
				}
				if(value>9)
				{
					a.set(k, 0);
					carryFlag=true;
				}
				else
				{
					a.set(k, value);
					carryFlag=false;
				}
			
			}
		}
		return a;
	}

}
