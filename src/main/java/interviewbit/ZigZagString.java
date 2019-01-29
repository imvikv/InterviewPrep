package crack.coding.interview.strings;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/zigzag-string/
public class ZigZagString {

	public static void main(String[] args) {
		System.out.println(new ZigZagString().convert("PAYPALISHIRING", 3));
	}

    public String convert(String A, int B) {
      List<List<Character>> data=new ArrayList<>();
      char[] c=A.toCharArray();
      int dir=-1,level=B-1;
      for(int i=0;i<A.length();i++)
      {
          if(i<B)
          {
              List<Character> k=new ArrayList<>();
              k.add(c[i]);
              data.add(k);
          }
          else
          {
              if(dir==-1)
              {
                  //means we need to go up
                  level--;
                 
              }
              else  if(dir==1)
              {
                  level++;
                  
              }
                  List<Character> k=data.get(level);
                  k.add(c[i]);
                 // data.add(level, k);
                  if(level==0)
                	  dir=1;
                  else if (level==B-1)
                	  dir=-1;
              
          }
      }
      StringBuffer sb= new StringBuffer();
      for(int i=0;i<data.size();i++)
      {
    	  
    	 for(char m:data.get(i)) {
    	  sb.append(m);
    	 }
      }
      return sb.toString();
    }
    

}
