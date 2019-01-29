package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
//https://www.interviewbit.com/problems/diffk/
//Given an array ‘A’ of sorted integers and another non negative integer k, 
//find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
public class Diffk {

    public int diffPossible(ArrayList<Integer> A, int B) {
        int len=A.size();
        if(len==0) return 0;
        for(int i=0,j=1;i<len&&j<len;)
        {
            int val=A.get(j)-A.get(i);
           if(val==B&&i!=j) return 1;
           if(val<B)
           {
               //means diff of two items needs to be increased
               j++;
           }
           else
           i++;
        }
        return 0;
    }
  

	    
	  public static void main(String[] args) {
		System.out.println(new Diffk().diffPossible(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4 )), 0));
	} 
}
