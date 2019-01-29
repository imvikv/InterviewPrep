package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSorted {

	 public int removeDuplicates1(ArrayList<Integer> a) {
	        if(a.size()<=1) return a.size();
	        int one=0,two=1;
	        while(two<a.size()&&one<two)
	        {
	        	//means duplicate values
	            if(a.get(two).equals(a.get(two-1)))
	            two++;
	            else
	            {
	                one++;
	                a.set(one,a.get(two));
	                two++;
	            }
	        }
	        
	        int len=one+1;
	        while(len!=a.size())
	        	a.remove(len);
	        System.out.println(a);
	        return len;
	    }
	 

	  public int removeDuplicates(ArrayList<Integer> a) {
	        
	        int last=a.size()-1;
	       int prev=last-1;
	       while(last>prev&&last>=1)
	       {
	           if(a.get(last).equals(a.get(prev)))
	           {
	               a.remove(last);
	               
	           }
	           last=prev;
	           prev--;
	          
	       }
	         System.out.println(a);
	        return a.size();
	    }
	 
	 public static void main(String[] args) {
		//System.out.println(new RemoveDuplicateFromSorted().removeDuplicates(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,3))));
		System.out.println(new RemoveDuplicateFromSorted().removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ))));
	}
}
