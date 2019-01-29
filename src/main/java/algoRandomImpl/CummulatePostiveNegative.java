package algoRandomImpl;

public class CummulatePostiveNegative {

	public static void main(String[] args) {
		int[] arr= new int[] {-1,-3,3,5,-6,8};
		
		int si=0,li=arr.length-1;
		while(si<=li)
		{
		if(arr[si]>=0 && arr[li]<0)
		{
			
			int temp=Integer.MAX_VALUE;
			temp=arr[si];
			arr[si]=arr[li];
			arr[li]=temp;
			si++;
			li--;
		}
		else if(arr[si]<0)
		{
			si++;
		}
		else if(arr[li]>=0)
		{
			li--;
		}
		
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

}
