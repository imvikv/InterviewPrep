package algo.java.randomImpl;

import java.util.ArrayList;

public class ReverseTheString {
	 public String reverseWords(String a) {
		    //create string array
		    ArrayList<String> b= new ArrayList<String>();
		    //read word by word and add to b
		    int start=0,end=0;
		    String result="";
		    for(int i=0;i<a.length();i++)
		    {
		        
		        if(a.charAt(i)==' ')
		        {
		            //means space so new
		            if(end-start>0&& start<end && end<=a.length())
		            {
		                b.add(a.substring(start,end));
		            }
		            start=i+1;
		            end=i+1;
		            
		        }
		        else
		        end++;
		    }
		    if(end-start>0&& start<end && end<=a.length())
            {
                b.add(a.substring(start,end));
            }
		    for(int i=b.size()-1;i>=0;i--)
		    {boolean added=false;
		        if(b.get(i)!=" ")
		        {
		            result+=b.get(i);
		            added=true;
		        }
		        if(i!=0 && added)
		        {
		            result+=" ";
		        }
		    }
		    return result;
		    }
	 
	 public static void main(String[] args) {
		System.out.println(new ReverseTheString().reverseWords(" s bbb"));
	}

}
