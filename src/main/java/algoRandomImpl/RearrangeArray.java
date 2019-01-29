package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.List;

/*Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer */
public class RearrangeArray {

	public static void main(String[] args) {
		ArrayList<Integer> b= new ArrayList<>();
b.add(3);
b.add(2);
b.add(0);
b.add(1);


		new RearrangeArray().arrange(b);
	}
	
	public void arrange(ArrayList<Integer> a) {
		int size=a.size();
		for(int i=0;i<a.size();i++)
		{
			int value=a.get(i)+((a.get(a.get(i))%size)*size);
			a.set(i, value);
		}
		
		for(int i=0;i<size;i++)
		{
			a.set(i, a.get(i)/size);
		}
	System.out.println(a);
	}
}
