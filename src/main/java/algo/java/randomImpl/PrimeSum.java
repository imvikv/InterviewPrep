package algo.java.randomImpl;

import java.util.ArrayList;

public class PrimeSum {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> j=new PrimeSum().primesum(28);
		System.out.println(j.get(0));
	}

    public ArrayList<Integer> primesum(int a) {
        
    ArrayList<Integer> b= new ArrayList<>();
    for(int k=2;k<=a-2;k++)
    {
    	if(isAprime(k)&& isAprime(a-k))
    	{
    		b.add(k);
    		b.add(a-k);
    		break;
    	}
    }
    return b;
    }

    static boolean isAprime(int a)
    {
    	if(a<2)
    	{
    		return false;
    	}
    	else
    	{
    		for(int i=2;i<=Math.sqrt(a);i++)
    		{
    			if(i< a && a%i==0)
    			{
    				return false;
    			}
    		}
    	}
   return true;
    }

}
