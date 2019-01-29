package interviewbit.tree;

public class TreeUtil {

	public  static TreeLinkNode createTree() {
		TreeLinkNode root=new TreeLinkNode(1);
		TreeLinkNode left=root.addLeftChild(2);
		TreeLinkNode right=root.addrightChild(3);
		left.addLeftChild(4);
		left.addrightChild(5);
		TreeLinkNode six=right.addLeftChild(6);
		six.addrightChild(8);
		TreeLinkNode seven=right.addrightChild(7);
		TreeLinkNode ten=seven.addLeftChild(10);
		TreeLinkNode eleven=ten.addrightChild(11);
		eleven.addrightChild(12);
		seven.addrightChild(9);
		
		return root;
	}
	

}

class TreeLinkNode
{
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	
public TreeLinkNode(int val) {
		super();
		this.val = val;
		this.left=null;
		this.right=null;
	}


public TreeLinkNode addLeftChild(int val) 
{
	TreeLinkNode node= new TreeLinkNode(val);
	this.left=node;
	return node;
	
	}
public TreeLinkNode addrightChild(int val) 
{
	TreeLinkNode node= new TreeLinkNode(val);
	this.right=node;
	return node;
	
	}	
}
