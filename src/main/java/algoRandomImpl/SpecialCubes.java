package algoRandomImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecialCubes {
	static int cubeNumbers(int M, int N) {
        int countM=0,countN=0;
        Map<Integer,Boolean> mMap= new HashMap<>();
        Map<Integer,Boolean> nMap= new HashMap<>();
        Map<Integer,Boolean> kMap= new HashMap<>();
        for(int i=1;i<=M;i++)
            {
            if(perfectSquareQube(i))
                {
                countM++;
                mMap.put(i,true);
            }
        }
 for(int j=1;j<=N;j++)
            {
            if(perfectSquareQube(j))
                {
                countN++;
                nMap.put(j,true);
            }
        }
        //now search for equal values
      
        int ev=0;
        for(int k=1;k<=N;k++)
            {
        		if(null ==nMap.get(k)) {
            
        			for(int l=1;k<=M;k++)
        				
        		 {if(null ==nMap.get(l)) {
        		 double d=3*Math.cbrt(l*l)*Math.cbrt(k)+3*Math.cbrt(l)*Math.cbrt(k*k);
        	    	int a=(int)d;
        	        if(a==d)
        	            {
        	            ev++;
        	        }
        	    }
        		 }
        	    }
            }
            
        
 return countM*countN+ev;
    }

static boolean perfectSquareQube(int d)
    {
    
    double k=Math.cbrt((double)d); 
    int a=(int)k;
    if(a==k)
        {
        return true;
    }
    return false;
}



public static void main(String[] args) {
   /* Scanner in = new Scanner(System.in);
    int res;
    int _M;
    _M = Integer.parseInt(in.nextLine());
    
    int _N;
    _N = Integer.parseInt(in.nextLine());
    */
//    res = cubeNumbers(_M, _N);
//    System.out.println(res);
    for(int k=2;k<=1000;k++)
    {
    	double d=3*Math.cbrt(4)*Math.cbrt(k)+3*Math.cbrt(2)*Math.cbrt(k*k);
    	int a=(int)d;
        if(a==d)
            {
            System.out.println(d);
        }
    }
    
}

}
