package ds.test.programs;

import java.util.ArrayList;

public class ReverseSpiralOrder {

	public static void main(String[] args) {
		generateMatrix(3);

	}
	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
	    
	    ArrayList<ArrayList<Integer>> b= new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> ar= new ArrayList<>();
	    for(int i=0;i<a;i++)
	    {
	    	ar.add(0);
	    }
	    for(int i=0;i<a;i++)
	    {
	        b.add((ArrayList<Integer>) ar.clone());
	    }
	    
	    int T=0,B=a-1,R=a-1,L=0,dir=0,m=1;
	    while(T<=B && L<=R)
	    {
	        if(dir==0)
	        {
	            for(int k=L;k<=R;k++,m++)
	            {
	                b.get(T).set(k,m);
	            }
	            T++;
	            
	        }
	        if(dir==1)
	        {
	            for(int k=T;k<=B;k++,m++)
	            {
	                b.get(k).set(B,m);
	            }
	            R--;
	            
	        }
	           if(dir==2)
	        {
	            for(int k=R;k>=L;k--,m++)
	            {
	                b.get(B).set(k,m);
	            }
	            B--;
	            
	        }
	           if(dir==3)
	        {
	            for(int k=B;k>=T;k--,m++)
	            {
	                b.get(k).set(L,m);
	            }
	            L++;
	            
	        }
	        
	        dir=(dir+1)%4;
	    }
	    return b;
	}
}
