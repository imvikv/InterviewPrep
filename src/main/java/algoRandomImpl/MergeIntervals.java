package algoRandomImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
https://www.interviewbit.com/problems/merge-intervals/
*/

public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		System.out.println(insert(intervals, new Interval(10, 8)));

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> a, Interval newInterval) {
		if (newInterval.start > newInterval.end) {
			newInterval = new Interval(newInterval.end, newInterval.start);
		}
		a.add(newInterval);
		Collections.sort(a, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if (o1.start == o2.start)
					return 0;
				return o1.start > o2.start ? 1 : -1;
			}

		});
		for (int i = 1; i < a.size(); i++) {
			boolean overlapped = overlappingInterval(a, i);
			if (overlapped) {
				a.set(i, new Interval(a.get(i - 1).start, a.get(i).end));
				a.remove(i - 1);
				i--;
			}

		}

		return a;
	}

	private static boolean overlappingInterval(ArrayList<Interval> a, int i) {
		if (a.get(i).start > a.get(i - 1).start && a.get(i).start < a.get(i - 1).end) {
			return true;
		}
		return false;
	}

}

/**
 * Definition for an interval.
 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
