package interviewbit;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/stepping-numbers/
public class SteppingNumbers {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=A;i<=B;i++)
        {
            if(i<=10 ||isSteppingNumber(i))
            result.add(i);
        }
        return result;
    }
    
    public boolean isSteppingNumber(int input) {
    	//maintain 0 to 9
        int[] arr= new int[10];int i=0;
        //now need to get all the individual digit , or make it string and manipulate
       while(input>0)
       {
    	   int val=input%10;
    	   arr[i++]=val;
    	    input=input/10;
       }
       for(int j=1;j<i;j++)
       {
    	   if(Math.abs(arr[j]-arr[j-1])!=1)
    	   {
    		   return false;
    	   }
       }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new SteppingNumbers().stepnum(100, 110));
	}
}
