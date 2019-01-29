package algoRandomImpl;

import java.util.HashMap;
import java.util.Map;

public class MiniMumWindowSubString {

	public static void main(String[] args) {
		System.out.println(new MiniMumWindowSubString().minWindow("cabwefgewcwaefgcf", "cae"));

	}
	
	 public String minWindow(String s, String t) {
		 int minLen=Integer.MAX_VALUE;
	        Map<Character,Integer> map= new HashMap<>();
	        // this is to store the frequency of String t characters
	        for(char c: t.toCharArray())
	        {
	            if(map.containsKey(c))
	            {
	                map.put(c,map.get(c)+1);
	            }
	            else
	            {
	                map.put(c,1);
	            }
	        }
	        int counter=t.length();
	        int start=0,end=0;
	        
	        String ans="";
	        // now starting the sliding window
	        while(end<s.length())
	        {
	            char endChar=s.charAt(end);
	            if(map.containsKey(endChar))
	            {
	                // char matched from t in s
	                int value=map.get(endChar);
	                value--;
	                map.put(endChar,value);
	                if(value>=0) counter--;
	            }
	            end++;
	           // this is when you have a solution but you need to compress to remove extra
	            while(counter==0)
	           {
	               if(end-start<minLen)
	               {	minLen=end-start;
	                   ans=s.substring(start,end);
	               }
	                //now moving the window from the start 
	                
	                char startChar=s.charAt(start);
	              if(map.containsKey(startChar))
	              {
	                  int value=map.get(startChar);
	                  value++;
	                  map.put(startChar,value);
	                  if(value>0) counter++;
	              }
	                start++;
	           }
	        }
	        return ans;
	    }

}
