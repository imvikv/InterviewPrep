package algo.java.randomImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/description/
public class WorldLadder {

	 
    
    class Node{
       String s;
       int len;
       public Node(String s){this.s=s;}
        public Node(String s,int len){this.s=s;this.len=len;}
       
   }
   

    

   public int ladderLength(String start, String end, List<String> dictV) {
   //System.out.println(start+" "+end+" "+dictV);
       if(!dictV.contains(end)) return 0;
   if(start.equals(end)) return 1;
   
   List<Node> dict=new ArrayList<>();
   for(String s1:dictV)
   dict.add(new Node(s1));
   
   Queue<Node> q= new LinkedList<>();
   Set<String> visited= new HashSet<>();
   q.offer(new Node(start,1));
       int val=Integer.MAX_VALUE;
   while(!q.isEmpty())
   {
      Node k=q.poll();
      visited.add(k.s);

           
          for(Node n1 :dict)
          {
              String element=n1.s;
              //!q.contains case was special as there can be node which are accessible by 1 and 2 both othe queue item, we need to take the least value
              if(isPathPossible(k.s,element)&&!visited.contains(n1.s)&&!q.contains(n1))
              {
                  q.offer(n1);
                  n1.len=k.len+1;
                   if(element.equals(end)) return n1.len;
                 //  if(isPathPossible(element,end)) return n1.len+1;
              }
          }
              
          
   }
   return 0;



   
   }
   
   
   public boolean isPathPossible(String s1,String s2)
   {
       int offChars=0;
       for(int i=0;i<s1.length();i++)
       {
           if(s1.charAt(i)!=s2.charAt(i))
           offChars++;
       }
       if(offChars>1) return false;
       return true;
   }

    public static void main(String[] args) {
    	ArrayList<String> dict= new ArrayList<>(Arrays.asList("aaababaaabbaabbbaaaaabbaaabaababbbbabbaaaaabbb","babbbaabbbbbabaaaabbaabbbaabbabbbaababbaabbbba","aaaaaaaabbbaababbbbbbbbababbbbbaaabaaababbaaba","abaabbaaabbbbbaabaaababababbabbabbbbbbabaababb","babbbabaaaababbbabbbabaabbbaababaabaabaabbabbb","baabbaaabaabbaabbbbbbbaabbabbaaabaaabbabbbbbaa","baaabbabbbbaaabaabbbbabbbaabbaaabaabbabbaabaab","bbabbaaaaaabaabbabbbabaaaabbbbaabababaabbaabba","bbabbabbbbbbbabbaabaaabaaabbaaaaaaaaabbabbaaab","baaabbaababbabaaaaaabaaabaaaabaabbbaaabbbbabba","babbbaaaabbaabaaaaabaaabbabaabaabaaaabababaaaa","aabbabaabaaababaabbbbbbaaabaaaaabbaaaaabaaaaba","abbbabbabaabbabbbabaababaaaabaaabaaaaaabbbaaaa","aaaababaaaababaaabbabaabaabaabaababbbabbbaaaab","abbbabaaabaababbbbbaaaaabbbbbbaabbababbbabbbaa","aabbbabbbabaaaaabaaaabaaaabaabbbbabbbaaaaaaaaa","abbabbaababbbaaaaabaaabbbbaaaabbbbbaabbaaababa","baaaaaabaaaaabaabaaabababaaabaaaaaaababbabbbbb","bbaabaabaababababbbbbbabbabbbbbbbbabbabbbbbbbb","abbaaaaaabbabaabbababaaaabbbbaaaaabaabbaaaabaa","aaaababbbbabaaaababaaaabbabbbbbabababaaabbaabb","abbbbbbbabaababaababbababaaabaaabaababbaaaabaa","babbbaaabbbbbabaaaaaaabaaaabaaabbabaabbababbbb","abbabbaaabaabaaaaaabbabbaabaaaaabababbaabbaaaa","abbaaabbbbbabbbbabaaaaaabaaabaabaaabbabbbababb","bababbbbaaabaabbbbbbabbaabbbbbaaabaaabbbbbbbba","aabaaaabbabbaabaaababbbaabbaabababaaaababbbbbb","baababbbbbbbbbbaabaabaabbbbbbababbabaaababbaba","babbabbabaaaababaabababbabaaaaaabbbaaaabaaabba"));
		//System.out.println(new WorldLadder().ladderLength("aabbbaabaabaaabbbbbbabbbbaaabababbbbbbaababaaa", "abaabaaababbbabbbbaaaabaaababaabbababbbaabbbba",dict ));
		//System.out.println(new WorldLadder().ladderLength("hit","cog",new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
		//System.out.println(new WorldLadder().ladderLength("bb","ab",new ArrayList<>(Arrays.asList("bb","ab"))));
//		System.out.println(new WorldLadder().ladderLength("a","c",new ArrayList<>(Arrays.asList("a","b","c"))));
		System.out.println(new WorldLadder().ladderLength("hot","dog",new ArrayList<>(Arrays.asList("hot","dog","cog","pot","dot"))));
	}

}
