package algoRandomImpl;

import java.util.LinkedList;
import java.util.List;

public class LinkedlistMidElement {

	public static void main(String[] args) {
		List<Integer> l1= new LinkedList<>();
		
		for(int i=3;i<13;i++)
		{
			l1.add(i);
		}
		// now need to find the mid element
		
		System.out.println(l1.get(l1.size()/2));
		
		
	}

}
