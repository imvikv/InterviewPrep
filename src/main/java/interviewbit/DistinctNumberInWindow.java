package interviewbit;
//https://www.interviewbit.com/problems/distinct-numbers-in-window/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInWindow {
	 public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
	        Map<Integer,Integer> count=new HashMap<>();
	        ArrayList<Integer> result= new ArrayList<>();
	        for(int i=0;i<B;i++)
	        {   int val=0,key=A.get(i);
	            if(count.containsKey(key))
	            val=count.get(key);
	            val++;
	            count.put(key,val);
	        }
	        result.add(count.size());
	        for(int j=B;j<A.size();j++)
	        {
	           Integer prev=A.get(j-B);
	           Integer pVal=count.get(prev);
	           if(pVal==1) count.remove(prev);
	           else{
	               pVal--;
	           count.put(prev,pVal);
	           }
	           int val=0;
	           int key=A.get(j);
	           if(count.containsKey(key))
	            val=count.get(key);
	           val++;
	            count.put(key,val);
	           result.add(count.size());
	        }
	        return result;
	    }
	 public static void main(String[] args) {
		//System.out.println(new DistinctNumberInWindow().dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
		System.out.println(new DistinctNumberInWindow().dNums(new ArrayList<>(Arrays.asList(31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31)), 3));
	}

}
