package leetcode;

public class UniquePaths {
	 public int uniquePaths(int m, int n) {
	        //m is columns n is row
	        int[][] arr= new int[n][m];
	        arr[0][0]=1;
	        for(int i=1;i<m;i++)
	            arr[0][i]=1;
	        
	        for(int i=1;i<n;i++)
	            arr[i][0]=1;
	        
	        for(int j=1;j<n;j++)
	        {
	            for(int k=1;k<m;k++)
	                arr[j][k]=arr[j-1][k]+arr[j][k-1];
	        }
	        return arr[n-1][m-1];
	    }

	 public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(3, 2));
		
	}
}
