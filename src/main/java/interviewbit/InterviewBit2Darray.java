package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class InterviewBit2Darray {

	public static void main(String[] args) {
	/*	
		ArrayList<Integer> a= new ArrayList<>();
		ArrayList<Integer> b= new ArrayList<>();
		ArrayList<Integer> c= new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		b.add(5);
		b.add(6);
		b.add(7);
		b.add(8);
		c.add(9);
		c.add(10);
		c.add(11);
		c.add(12);
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();;
		A.add(a);
		A.add(b);
		A.add(c);
		ArrayList<ArrayList<Integer>> B = performOps(A);
		for (int i = 0; i < B.size(); i++) {
		    for (int j = 0; j < B.get(i).size(); j++) {
		            System.out.print(B.get(i).get(j) + " ");
		    }
		}
*/
		ArrayList<Integer> s=new ArrayList<>(Arrays.asList(-4, -2, 0, -1, -6));
//		s.add(7);
//		s.add(9);
//		s.add(2);
		System.out.println(solve(s));
	}
	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());
        
            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
}
	 public static int solve(ArrayList<Integer> A) {
	        Collections.sort(A);
	        int s= A.size();
	        int index=1;
	       
	    for(int k=0;k<s;k++)
	    {
	        if(A.get(k)== s-index && (k<s-1 && A.get(k) !=A.get(k+1))||(k==s-1&& A.get(k)== s-index))
	        {
	            return 1;
	        }
	       
	        index++;
	    }
	    return -1;
	        
	    }
	    
}
