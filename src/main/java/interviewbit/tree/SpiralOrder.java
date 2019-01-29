package interviewbit.tree;

import java.util.Stack;

public class SpiralOrder {

	public static void main(String[] args) {
		TreeNode root=createTree();
		System.out.println(root);
		printInSpiralOrder(root);
	}

	private static void printInSpiralOrder(TreeNode root) {
		//use of two stack adding them either in left->right and right->left way
		Stack<TreeNode> s1= new Stack<TreeNode>();
		Stack<TreeNode> s2= new Stack<TreeNode>();
		s1.add(root);
		while(!s1.isEmpty()&&s2.isEmpty()) {
		while(!s1.isEmpty())
		{
			TreeNode curr= s1.pop();
			System.out.print(curr.val+" ");
			//add it's child to other queue in reverse order
			
			if(curr.left !=null)
				s2.add(curr.left);
			if(curr.right!=null)
				s2.add(curr.right);
		
				
		}
		while(!s2.isEmpty())
		{
			TreeNode curr= s2.pop();
			System.out.print(curr.val+" ");
			//add it's child to other queue in normal order
			
			if(curr.right!=null)
				s1.add(curr.right);
			if(curr.left !=null)
				s1.add(curr.left);
							
		}
	}
	}

	public  static TreeNode createTree() {
		TreeNode root=new TreeNode(1);
		TreeNode left=root.addLeftChild(2);
		TreeNode right=root.addrightChild(3);
		left.addLeftChild(4);
		left.addrightChild(5);
		right.addLeftChild(6);
		right.addrightChild(7);
		return root;
	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	
	
public TreeNode(int val) {
		super();
		this.val = val;
		this.left=null;
		this.right=null;
	}


public TreeNode addLeftChild(int val) 
{
	TreeNode node= new TreeNode(val);
	this.left=node;
	return node;
	
	}
public TreeNode addrightChild(int val) 
{
	TreeNode node= new TreeNode(val);
	this.right=node;
	return node;
	
	}	
}