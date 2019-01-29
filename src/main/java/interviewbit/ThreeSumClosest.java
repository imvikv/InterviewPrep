package interviewbit;
//https://www.interviewbit.com/problems/3-sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {

	public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int len=A.size();
        int diff=Integer.MAX_VALUE;
       for(int i=0;i<len-2;i++)
       {
           int j=i+1;
           int k=len-1;
           while(j<k)
           {
               int val=A.get(i)+A.get(j)+A.get(k);
               if(val==B)
                return B;
              
               diff=nearest(diff,val,B);
              
               if(val<B)
               {
                  j++; 
               }
               else
               k--;
              
           }
       }
       return diff+B;
        
    }
	private int nearest(int diff1, int val, int b) {
		int diff2=val-b;
		if(Math.abs(diff2)<Math.abs(diff1))
			return diff2;
		return diff1;
	}
	public static void main(String[] args) {
		System.out.println(new ThreeSumClosest().threeSumClosest(new ArrayList<>(Arrays.asList( 2, 1, -9, -7, -8, 2, -8, 2, 3, -8)), -1));
	}
}
