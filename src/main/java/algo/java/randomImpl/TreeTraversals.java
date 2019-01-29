package algo.java.randomImpl;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

	public static void main(String[] args) {
		
		Node head= new Node(1, null, null);
		head.left=new Node(2, null, null);
		head.left.left=new Node(4, null, null);
		head.left.right=new Node(5, null, null);
		head.right=new Node(3, null, null);
		head.right.left=new Node(6, null, null);
		head.right.right=new Node(7, null, null);
		System.out.println("inorder");
		inorder(head);
		System.out.println();
		System.out.println("preOrder");
		preOrder(head);
		System.out.println();
		System.out.println("postorder");
		postOrder(head);
		System.out.println();
		System.out.println("levelOrder");
		levelOrderTraversal(head);
	}
	
	/**
	 * @param head
	 */
	public static  void inorder(Node head)
	{
		if(head== null)
		{
			return;
		}
		inorder(head.left);
		System.out.print(head.value+" ");
		inorder(head.right);
	}
	
	/**
	 * @param head
	 */
	public static  void  preOrder(Node head)
	{
		if(head== null)
		{
			return;
		}
		
		System.out.print(head.value+" ");
		preOrder(head.left);
		preOrder(head.right);
	}
	
	public static  void  postOrder(Node head)
	{
		if(head== null)
		{
			return;
		}
		
		
		postOrder(head.left);
		postOrder(head.right);
		System.out.print(head.value+" ");
	}
	
	public static void levelOrderTraversal(Node head)
	{
		Queue<Node> b= new LinkedList<>();
		b.add(head);
		while(!b.isEmpty())
		{
			Node k=b.remove();
			if(null !=k)
			{System.out.print(k.value+" ");
				b.add(k.left);
				b.add(k.right);
			}
		}
	}
}
/**
 * @author vikas
 *
 */
 class Node
{
	int value;
	Node left;
	Node right;
	
	public Node(int value, Node left, Node right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	
}
