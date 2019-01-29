package interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root=createTree();
		ArrayList<ArrayList<Integer>> result= new VerticalOrderTraversal().verticalOrderTraversal(root);
		System.out.println(result);
	}
	public  static TreeNode createTree() {
		TreeNode root=new TreeNode(1);
		TreeNode left=root.addLeftChild(2);
		TreeNode right=root.addrightChild(3);
		left.addLeftChild(4);
		left.addrightChild(5);
		TreeNode six=right.addLeftChild(6);
		six.addrightChild(8);
		TreeNode seven=right.addrightChild(7);
		TreeNode ten=seven.addLeftChild(10);
		TreeNode eleven=ten.addrightChild(11);
		eleven.addrightChild(12);
		seven.addrightChild(9);
		
		return root;
	}
	
	 public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
	        Map<Integer,List<Integer>> resultMap=new TreeMap<Integer, List<Integer>>();
	        Queue<QueueUtil> q= new LinkedList<QueueUtil>();
	        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	        int level=0;
	        q.add(new QueueUtil(A,level));
	        while(!q.isEmpty())
	        {
	            QueueUtil b=q.poll();
	            List<Integer> list=null;
	            if(!resultMap.containsKey(b.level)){
	            list= new ArrayList<Integer>();
	            }
	            else
	            {
	            list=resultMap.get(b.level);    
	            }
	            list.add(b.t.val);
	            resultMap.put(b.level,list);
	            //add left and right child
	            if(b.t.left !=null)
	            q.add(new QueueUtil(b.t.left,b.level-1));
	            if(b.t.right !=null)
	            q.add(new QueueUtil(b.t.right,b.level+1));
	            
	        }
	        
	        for(List<Integer> l: resultMap.values())
	        {
	            result.add((ArrayList<Integer>) l);
	        }
	        return result;
	    }
	 
	 class QueueUtil
	 {
	     TreeNode t;
	     int level;
	     
	     public QueueUtil(TreeNode t,int level)
	     {
	         this.t=t;
	         this.level=level;
	     }
	     
	  
	 }
	
}

