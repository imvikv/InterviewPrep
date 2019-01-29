//https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
package interviewbit.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevelNode2 {

	public void connect(TreeLinkNode root) {

		// now we will try to solve this problem using queue
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		q.add(null);
		// doing level order traversal
		while (!q.isEmpty()) {
			TreeLinkNode n1 = q.poll();
			if (n1 != null) {
				n1.next=q.peek();
				// add left and right child
				if (n1.left != null)
					q.add(n1.left);
				if (n1.right != null)
					q.add(n1.right);

			} 
			//this case is imp as q is not empty is the distinguising condition that all elements are done or not,if we blindly add null when ever we 
			//encounter null as polled item then we will go to infinite loop
			else if(!q.isEmpty())
			{
				q.offer(null);
			}
		}

	}

	public static void main(String[] args) {
		// driver programe
		TreeLinkNode root = TreeUtil.createTree();
		new ConnectSameLevelNode2().connect(root);
		System.out.println(root);
	}
}
