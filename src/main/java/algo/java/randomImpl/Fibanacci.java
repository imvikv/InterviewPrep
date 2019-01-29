package algo.java.randomImpl;

import java.util.Scanner;

public class Fibanacci {

	static int[] arr;

	public static void main(String[] args) {
		System.out.println("Enter input range size ");
		long start = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int range = in.nextInt();
		arr = new int[range];
		for (int i = 0; i < range; i++) {
			System.out.println(fibRecursive(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("execution time :" + (end - start) + "ms");

	}

	private static int fibRecursive(int n) {
		if (arr[n] > 0) {
			// System.out.println("got it from array"+arr[n]);
			return arr[n];

		}
		if (n < 2) {
			arr[n] = n;
			return n;
		}
		arr[n] = fibRecursive(n - 1) + fibRecursive(n - 2);
		return arr[n];
	}

	private static int simpleFibCalculate(int n) {
		if (n < 2) {
			arr[n] = n;
			return n;
		}

		return simpleFibCalculate(n - 1) + simpleFibCalculate(n - 2);
	}

}
