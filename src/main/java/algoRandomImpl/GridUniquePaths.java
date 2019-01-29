package algoRandomImpl;

/*The robot can only move either down or right at any point in time. The robot is trying to 
 * reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)*/
/*
solution Approach
the approch to solve is to understand how it works in the smaller input , took an example of 2*2 first the 3*3 ,
made me realised it can be solved only by recursion as at every step you have two option going right or down, so if i can make
a method which does this operation of and at the end of the recusrion just increase one counter. 
woah so happy solved first recusrion problem from my self....:)*/

public class GridUniquePaths {
	
	public static void main(String[] args) {
		System.out.println(new GridUniquePaths().uniquePaths(3, 3));
	}
	
	public int uniquePaths(int a, int b) {
	
		
		int v1=0,v2=0;
		return totalCount(a,b,v1,v2);
	}

	static  int totalCount(int a, int b,int v1,int v2) {
		int count=0;
		if(a-1==v1 && b-1==v2)
		{
			return 1;
		}
		if(a-1>v1 && b-1 >v2) {
		count=count+totalCount(a, b, v1+1, v2)+totalCount(a, b, v1, v2+1);}
		else if(a-1>v1)
		{
			count+=totalCount(a, b, v1+1, v2);
		}
		else {
			count+=totalCount(a, b, v1, v2+1);
		}
		return count;
	}

	
}
