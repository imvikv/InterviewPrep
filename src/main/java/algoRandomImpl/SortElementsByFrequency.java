package algoRandomImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*Sort elements by frequency | Set 1
Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.

Examples:

Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 * */
public class SortElementsByFrequency {
	// driver programe
	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 7, 7, 7, 3, 2, 2, 2, 7, 3, 1, 7, 1, 6, 3, 5, 5, 4, 5, 6, 2, 1, 2, 4, 7, 3, 1, 3, 5,
				4, 1, 7, 2, 6, 1, 2 };
		a = sortByFreq(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static int[] sortByFreq(int[] arr) {

		Map<Integer, Element> a = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			Element e = a.get(arr[i]);
			if (null != e) {
				a.put(arr[i], new Element(arr[i], e.index, (e.getCount() + 1)));
			} else {
				a.put(arr[i], new Element(arr[i], i, 1));
			}
		}
		List<Element> b = new ArrayList<>();
		for (Entry<Integer, Element> e : a.entrySet()) {
			b.add(e.getValue());
		}
		Collections.sort(b, new Comparator<Element>() {
			// this comparaator can be tweaked to get desired results
			@Override
			public int compare(Element o1, Element o2) {
				if (o1.count > o2.count) {
					return 1;
				} else if (o1.count == o2.count) {
					if (o1.value < o2.value) {
						return 1;
					} else
						return -1;
				} else {
					return -1;
				}

			}
		});
		int index = 0;
		for (int j = b.size() - 1; j >= 0; j--) {
			Element e1 = b.get(j);
			for (int i = 0; i < e1.count; i++) {
				arr[index++] = e1.value;
			}
		}
		return arr;
	}

}

class Element {
	int value;

	/**
	 * @param value
	 * @param index
	 * @param count
	 */
	public Element(int value, int index, int count) {
		super();
		this.value = value;
		this.index = index;
		this.count = count;
	}

	int index;
	int count;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param index
	 * @param count
	 */
	Element(int index, int count) {
		super();
		this.index = index;
		this.count = count;
	}

	/**
	 * @param count
	 */
	Element(int count) {
		super();
		this.count = count;
	}

}
