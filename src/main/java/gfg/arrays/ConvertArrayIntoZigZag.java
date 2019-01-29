package gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
public class ConvertArrayIntoZigZag {

	public static void main(String[] args) throws IOException {

		// Using BufferedReader class to take input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// taking input of number of testcase
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			// n : size of array
			int n = Integer.parseInt(br.readLine());

			// Declaring array
			int arr[] = new int[n];

			// to read multiple integers line
			String line = br.readLine();
			String[] strs = line.trim().split("\\s+");

			// array elements input
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(strs[i]);

			// Calling Functions to segregate Array elements
			function(arr);

		}

	}

	public static void function(int[] arr) {
		for (int i = 1; i < arr.length; i++) {

			if (i % 2 != 0 && arr[i] < arr[i - 1]) {

				int temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			}

			else if (i % 2 == 0 && arr[i] > arr[i - 1]) {
				int temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			}

		}

		// printing o/p
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i] + " ");

		// finally printing the string
		System.out.println(sb);
	}

}
