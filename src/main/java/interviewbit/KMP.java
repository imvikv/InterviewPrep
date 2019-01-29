package crack.coding.interview.strings;
//https://www.interviewbit.com/problems/implement-strstr/
public class KMP {

	public static void main(String[] args) {
		System.out.println(new KMP().strStr("abcxabcdabcdabcy", "dabcdabcy"));
	}

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
    	/*find B in A we will solve this problem with KMP algo , where we use prefix array to find the next index to match in case of mismatch o(m+n)
    	form prefix subarray of B , prefix array means so that we can find out that any index prefix string to that index has any such 
    	combination where prefix of that element is also suffix of that element
    	*/
    	int i=0,j=1,len1=A.length(),len2=B.length();
    	if(len1==0 || len2==0) return -1;
    	int[] prefix=new int[B.length()];
    	prefix[0]=0;
    	/*Algo : match i'th value to j'th if matched set j'th value to i+1 and increment i and j by one, else we find next j to match by checking prev element value from prefix array and match same 
    	this again until we i=0, if at any stage it's not matched then we state the value of j to 0 and increment j*/    	
    	while(j<len2)
    	{
    		if(B.charAt(j)==B.charAt(i))
    		{
    			prefix[j]=i+1;
    			i++;
    			j++;
    			
    		}
    		else
    		{
    			if(i!=0) i=prefix[i-1];
    			else
    			{
    				prefix[j]=0;
    				j++;
    			}
    		}
    	}
    	B.indexOf(A);
    	//now we start matching
    	i=0;j=0;
    	while(i<len1 && j<len2)
    	{
    		if(A.charAt(i)==B.charAt(j)) {
    			i++;
    			j++;
    		}
    		else
    		{
    			//now find the next element to match
    			if (j!=0) j=prefix[j-1];
    			else
    			{
    				i++;
    			}
    		}
    	}
    	if(j==len2) return i-len2;
    	return -1;
    }

}
