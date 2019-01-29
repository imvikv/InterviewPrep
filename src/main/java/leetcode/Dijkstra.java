package algo.java.impl.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/network-delay-time/solution/

/*There are N network nodes, labeled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.*/
public class Dijkstra { //THIS IS DJIKSTRA
    class Node{
        int source;
        int distance;
        public Node(int s,int d){this.source=s;this.distance=d;}        
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,Map<Integer,Integer>> graph= new HashMap<>();
        //now the graph is formed
        for(int i=0;i<times.length;i++)
        {
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            Map<Integer,Integer> val=new HashMap<>();
            if(graph.containsKey(u)) val=graph.get(u);
            val.put(v,w);
            graph.put(u,val);
        }
        
        Map<Integer,Integer> dist= new HashMap<>();
        PriorityQueue<Node> q= new PriorityQueue<>((q1,q2)->(q1.distance-q2.distance));
        q.offer(new Node(K,0));
        dist.put(K,0);
        while(!q.isEmpty())
        {
            Node n=q.poll();
            if(!dist.containsKey(n.source)||dist.containsKey(n.source)&& dist.get(n.source)>n.distance)
            dist.put(n.source,n.distance);
            //add it's child
            Map<Integer,Integer> m= graph.get(n.source);
            if(m !=null) {
            for(Integer dest:m.keySet())
            {
                int length=m.get(dest)+n.distance;               
                       
                if(!dist.containsKey(dest)||dist.containsKey(dest)&& dist.get(dest)>length)
                {
                  dist.put(dest,length);
                q.add(new Node(dest,length));    
                  
                } 
            }
            }
            
        }
        if(dist.size()!=N) return -1;
        int time=0;
        for(Integer val:dist.keySet())
        {
           if(time<dist.get(val))
               time=dist.get(val);
        }
            
        return time;
    }
    public static void main(String[] args) {
    	int[][] times=new int[][] {
    		{2,1,1},
    		{2,3,1},
    		{3,4,1}
    	};
    	int[][] times1=new int[][] {
    		{1,2,1},
    		{2,1,3}    		
    	};
		System.out.println(new Dijkstra().networkDelayTime(times, 4, 2));
    	System.out.println(new Dijkstra().networkDelayTime(times1, 2, 2));
	}
    }
