package ds.test.programs;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given the following matrix:
		 * [
		    [ 1, 2, 3 ],
		    [ 4, 5, 6 ],
		    [ 7, 8, 9 ]
		   ]
				You should return

						[1, 2, 3, 6, 9, 8, 7, 4, 5]
						https://www.youtube.com/watch?v=siKFOI8PNKM&feature=player_embedded
						
						*/
		

	}
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int m=a.size();
		 int n=a.get(0).size();
		 int t=0,b=m-1,l=0,r=n-1,dir=0;
		 while(t<=b && l<=r)
		 {
			 if(dir==0)
			 {
				 for(int i=l;i<=r;i++)
				 {
					 result.add(a.get(t).get(i));
				 }
				 t++;
			 }
			 if(dir==1)
			 {
				 for(int i=t;i<=b;i++)
				 {
					 result.add(a.get(i).get(r));
				 }
				 r--;
			 }
			 if(dir==2)
			 {
				 for(int i=r;i>=l;i--)
				 {
					 result.add(a.get(b).get(i));
				 }
				 b--;
			 }
			 if(dir==3)
			 {
				 for(int i=b;i>=t;i--)
				 {
					 result.add(a.get(i).get(l));
					 
				 }
				 l++;
			 }
			 dir=(dir+1)%4;
		 }
		 
		 return result;
	}
}
