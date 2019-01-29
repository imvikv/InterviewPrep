package interviewbit;

import java.util.ArrayList;

public class MinimizeAbsDiff {

	 public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
	        int i=A.size()-1,j=B.size()-1,k=C.size()-1,min=Integer.MAX_VALUE;
	        while(i!=-1&&j!=-1&&k!=-1)
	        {
	            int maxVal=Math.max(A.get(i),Math.max(B.get(j),C.get(k)));
	            int minVal=Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
	           int minTemp=Math.abs(maxVal-minVal);
	            min=Math.min(minTemp,min);
	            if(maxVal==A.get(i))
	            i--;
	            else if(maxVal==B.get(j))
	            j--;
	            else if(maxVal==C.get(k))
	            k--;
	            
	        }
	        return min;
	    }
	 
	 public static void main(String[] args) {
		
	}
}
