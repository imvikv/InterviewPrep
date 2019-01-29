package algo.java.randomImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayGame {

	   public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
//	        final String fileName = System.getenv("OUTPUT_PATH");
//	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        long res;
	        
	        int _numbers_size = 0;
	        _numbers_size = Integer.parseInt(in.nextLine().trim());
	        int[] _numbers = new int[_numbers_size];
	        int _numbers_item;
	        for(int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
	            _numbers_item = Integer.parseInt(in.nextLine().trim());
	            _numbers[_numbers_i] = _numbers_item;
	        }
	        
	        res = countMoves(_numbers);
	        System.out.println(res);
//	        bw.write(String.valueOf(res));
//	        bw.newLine();
//	        
//	        bw.close();
	    }

	static long countMoves(int[] numbers) {
		long moves = 0;
		Arrays.sort(numbers);
		int len = numbers.length;
		int maxIndex = len - 1;
		int max = numbers[len - 1];
		boolean loopFlag = true;

		if (max == numbers[0]) {

			return moves;
		}
		while (loopFlag) {
			int tempMax=max;
			int tempIndex=maxIndex;
			for (int i = 0, count = 0; i < len; i++) {
				if (numbers[i] == max) {
					count++;
					if (i != maxIndex) {
						numbers[i] += 1;
						if(numbers[i]>max)
						{
							tempMax=numbers[i];
							tempIndex=i;
						}
					}

				} else {
					numbers[i] += 1;
					if(numbers[i]>max)
					{
						tempMax=numbers[i];
						tempIndex=i;
					}
				}
				if (count == len) {
					loopFlag = false;
					moves--;
					break;
				}

			}
//			Arrays.sort(numbers);
//			max = numbers[len - 1];
//			maxIndex = len - 1;

			moves++;
		}

		return moves;
	}

	static long countMovesReverse(int[] nums)
	{
		long moves=0;
		Arrays.sort(nums);
		if(nums[0]==nums[nums.length-1])
		{
			return moves;
		}
		else
		{int min=nums[0];
		for(int i=1;i<nums.length;i++)
		{
			moves=moves+(nums[i]-min);
		}
			
		}
		return moves;
	}
	
}
