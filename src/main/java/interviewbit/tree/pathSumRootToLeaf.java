package interviewbit.tree;

import java.util.ArrayList;

public class pathSumRootToLeaf {

	public static void main(String[] args) {
		TreeNode root=createTree();
		System.out.println(root);
		new pathSumRootToLeaf().pathSum(root,7);
	}

	 public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
	        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> list= new ArrayList<Integer>();
	         modPreOrder(result,list,A,B,0);
	         return result;
	    }
	    
	    public void  modPreOrder(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,TreeNode A,int B,int sumNow)
	    {
	        if(A==null)
	        return ;
	        list.add(A.val);
	        sumNow+=A.val;
	        if(sumNow==B && isLeaf(A))
	        {
	             ArrayList<Integer> subList= new ArrayList<Integer>();
	            for(Integer i:list)
	            {
	             subList.add(i);   
	            }
	            result.add(subList);
	        }
	        else
	        {
	        modPreOrder(result,list,A.left,B,sumNow);
	        modPreOrder(result,list,A.right,B,sumNow);
	       
	        }
	        list.remove(list.size()-1);
	    }
	    public boolean isLeaf(TreeNode n)
	    {
	        return n.left==null && n.right==null;
	    }

	public  static TreeNode createTree() {
		TreeNode root=new TreeNode(1);
		TreeNode left=root.addLeftChild(2);
		TreeNode right=root.addrightChild(3);
		left.addLeftChild(4);
		left.addrightChild(5);
		right.addLeftChild(3);
		right.addrightChild(7);
		return root;
	}
}


