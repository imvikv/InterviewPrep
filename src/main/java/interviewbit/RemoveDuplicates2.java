package interviewbit;
//two pointer section
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates2 {

	 public int removeDuplicates(ArrayList<Integer> a) {
	        if(a==null) return 0;
	        if(a.size()==1) return 1;
	        int start=0,count=1;
	        Integer value=a.get(start);
	        for(int i=1;i<a.size();i++)
	        {
	            if(value.equals(a.get(i)))
	            {
	                if(count<2){
	                count++;
	                start++;
	                a.set(start, a.get(i));
	                }
	              
	            }
	            else  //when start and i do not match value
	            {	              
	            	   start++;
	                   a.set(start,a.get(i));
	                   count=1;
	                   value=a.get(i);
	            }
	            
	        }
	        //System.out.println(start);
	        int len=start+1;
	        while(len!=a.size()) {
	        	a.remove(a.size()-1);
	        }
	        System.out.println(a);
	        return a.size();
	    }
	
	 public static void main(String[] args) {
			System.out.println(new RemoveDuplicates2().removeDuplicates(new ArrayList<>(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010))));
			System.out.println(new RemoveDuplicates2().removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 ))));
		}
}
