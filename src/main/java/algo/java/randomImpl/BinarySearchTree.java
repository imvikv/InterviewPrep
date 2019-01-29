package algo.java.randomImpl;

public class BinarySearchTree {

	public static void main(String[] args) {

		BstNode head = new BstNode(11, null, null);
		head=insert(head,new BstNode(10, null, null));
		head=insert(head,new BstNode(9, null, null));
		head=insert(head,new BstNode(11, null, null));
		head=insert(head,new BstNode(12, null, null));
		head=insert(head,new BstNode(8, null, null));
		System.out.println("Inorder");
		inOrder(head);
		System.out.println("searching values");
		BstNode search=search(head, 1);		
		System.out.println(null == search? null : search.value);
	}

	/**
	 * @param head
	 * @param node
	 */
	private static BstNode insert(BstNode head,BstNode node) {		
		if(null ==head)
		{
			head=node;
			return head;
		}
		else
		{
			//traverse to position
			if(head.value>=node.value)
			{
				head.left=insert(head.left, node);
			}
			else
			{
				head.right=insert(head.right, node);
			}
		}
		return head;
		
	}
	
	/**
	 * @param head
	 * @param value
	 * @return
	 */
	private static BstNode search(BstNode head,int value)
	{
		if (null == head ||head.value==value)
		{
			return head;
		}
		else
		{
			if(head.value>value)
			{
				return search(head.left, value);
			}
			else
				return search(head.right, value);
		}
	}
	
	private static void inOrder(BstNode head)
	{
		if(head==null)
		{
			return;
		}
		inOrder(head.left);
		System.out.println(head.value+" ");
		inOrder(head.right);
	}
	
}

class BstNode {
	int value;
	BstNode left, right;

	public BstNode(int value, BstNode left, BstNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
