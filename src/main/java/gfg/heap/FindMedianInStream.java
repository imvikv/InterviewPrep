package gfg.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0
public class FindMedianInStream {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> min = new PriorityQueue<>(); // min heap will have right side of array
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // max heap will have left side of
																						// array
		int t = Integer.parseInt(br.readLine());
		while (t--> 0) {
			int element = Integer.parseInt(br.readLine());
			addElement(element, min, max);
			reBalance(min, max);
			System.out.println(getMedian(min, max));
		}
	}




	/**This method will add element to deserving heap 
	 * @param element
	 * @param min
	 * @param max
	 */
	private static void addElement(int element, PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		//rules for adding first element goes to left side maintaining heap which is max 
		if(max.isEmpty()||max.peek()>element)
		{
			max.offer(element);
		}
		else
			min.offer(element);
	}
	
	/**This method will make sure that difference in sizes between both of the heap should not be more than one
	 * @param min
	 * @param max
	 */
	private static void reBalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		int sizeMin=min.size();
		int sizeMax=max.size();
		if(Math.abs(sizeMax-sizeMin)<=1)
			return ;
		else
		{
			//now to reBalance we need to remove extra element from bigger heap to smaller heap
			if(sizeMax<sizeMin) {
				 reBalance(max, min);
				 return;
			}
			else
			{
				int val=max.poll();
				min.offer(val);
			}
		}
	}
	/**This method will take top two if even else take bigger one top
	 * @param min
	 * @param max
	 * @return
	 */
	private static int getMedian(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		int sizeMin=min.size();
		int sizeMax=max.size();
		if((sizeMax+sizeMin)%2!=0) {
		if(sizeMax<sizeMin)
			return getMedian(max, min);
		return max.peek();
		}
		else
		{
			return (max.peek()+min.peek())/2;
		}
	}
}
