package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAnagraminString {

	public static void main(String[] args) {
	//List<Integer> kl=new FindAnagraminString().findAnagrams("cbaebabacd", "abc");
	List<Integer> kl=new FindAnagraminString().findAnagrams("baa", "aa");
	for(Integer i:kl)
	{
		System.out.println(i);
	}

	}

/*	
 * my solution
 * public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> table= new HashMap<>();
        for(Character c: p.toCharArray())
        {
            if(table.containsKey(c))
            {
                int value=table.get(c);
                table.put(c,value+1);
            }
            else
            {
            table.put(c,1);
            }
        }
        
        int begin=0,end=0,counter=p.length();
        while(end<s.length())
        {
            char endchar=s.charAt(end);
            if(table.containsKey(endchar))
            {
                int value=table.get(endchar);
                value--;
                table.put(endchar, value);
                if(value>=0) counter--;
            }
            end++;
            while(counter==0)
            {
                //Houston we might have a solution
                if(end-begin==p.length())
                {
                    res.add(begin);
                }
                char startChar=s.charAt(begin);
                
               if(table.containsKey(startChar))
               {
                   int value=table.get(startChar);
                   value++;
                   table.put(startChar,value);
                   if(value>0) counter++;
               }
                begin++;
            }
        }
        return res;
    }*/
	
	 public List<Integer> findAnagrams(String s, String t) {
	        List<Integer> result = new LinkedList<>();
	        if(t.length()> s.length()) return result;
	        Map<Character, Integer> map = new HashMap<>();
	        for(char c : t.toCharArray()){
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        }
	        int counter = map.size();
	        
	        int begin = 0, end = 0;
	        int head = 0;
	        int len = Integer.MAX_VALUE;
	        
	        
	        while(end < s.length()){
	            char c = s.charAt(end);
	            if( map.containsKey(c) ){
	                map.put(c, map.get(c)-1);
	                if(map.get(c) == 0) counter--;
	            }
	            end++;
	            
	            while(counter == 0){
	                char tempc = s.charAt(begin);
	                if(map.containsKey(tempc)){
	                    map.put(tempc, map.get(tempc) + 1);
	                    if(map.get(tempc) > 0){
	                        counter++;
	                    }
	                }
	                if(end-begin == t.length()){
	                    result.add(begin);
	                }
	                begin++;
	            }
	            
	        }
	        return result;
	    } 
}
