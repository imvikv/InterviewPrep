package algo.java.randomImpl;
import java.util.*;
public class ArraySwap_HoneyWell {

	


	
	   /* public static void main(String args[] ) throws Exception {
	      
	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int N = s.nextInt();
	        int[] arr= new int[N];
	        
	        
	        
	        for (int i = 0; i < N; i++) {
	            arr[i]=s.nextInt();
	        }
	        int lc=s.nextInt();
	        for(int j=0;j<lc;j++)
	        {
	        	int l=s.nextInt();
	        	int r=s.nextInt();
	        	for(int k=l;k<=r;k++)
	        	{int temp=arr[k-1];
	        		arr[k-1]=arr[N-k];
	        		arr[N-k]=temp;
	        		
	        	}
	        	
	        }
	        
	       
	 for (int i = 0; i < N; i++) {
	        System.out.print(arr[i]+" ");
	        }
	       
	    }*/
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr= new int[N];
        
        
        
        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
        int[] arr1=new int[N+1];
        for (int i = 0; i < N+1; i++) {
            arr1[i]=0;
        }
        
        
        
        int lc=s.nextInt();
        for(int j=0;j<lc;j++)
        {
        	int l=s.nextInt();
        	int r=s.nextInt();
        	arr1[l-1]=arr1[l-1]+1;
        	arr1[r]=arr1[r]-1;
        	
        }
        //cumulative array
        for (int k=1;k<N;k++)
        {
        	arr1[k]=arr1[k]+arr1[k-1];
        }
        for(int l=0;l<N;l++)
        {
        if(arr1[l]%2!=0)
        {int temp=arr[l];
        	arr[l]=arr[N-l-1];
        	arr[N-l-1]=temp;
        }
        }
        
        for (int k = 0; k < N; k++) {
	        System.out.print(arr[k]+" ");
	        }
	}
	

}
