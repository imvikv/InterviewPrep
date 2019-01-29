package algoRandomImpl;

import java.util.ArrayList;
import java.util.Collections;

public class AllFactorsOfAnumber {

	public static void main(String[] args) {
		System.out.println(new AllFactorsOfAnumber().allFactors(36));

	}

	public ArrayList<Integer> allFactors(int a) {
	    ArrayList<Integer> b=new ArrayList<>();
	    b.add(1);
	    b.add(a);
	    for(int i=2;i<=Math.sqrt(a);i++)
	    {
	        if(a%i==0)
	        {
	            b.add(i);
	            if(i!=a/i){
	            b.add(a/i);
	            }
	        }
	    }
	    Collections.sort(b);
	    return b;
	}


}
