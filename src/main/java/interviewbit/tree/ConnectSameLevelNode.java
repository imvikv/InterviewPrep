package interviewbit.tree;
//https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
public class ConnectSameLevelNode {

	/**
	 * Definition for binary tree with next pointer.
	 */
/*	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}*/
	
	//using constant extra space
	public void connect(TreeLinkNode root) {
		if (null == root)
			return;
		root.next = null;
		while (root != null) {
			TreeLinkNode parent = root;
			while (parent != null) {

				if (parent.left != null) {
					if (parent.right != null) {
						parent.left.next = parent.right;
						// now set for right
						parent.right.next = getNextFromNextParent(parent);
					} else
						parent.left.next = getNextFromNextParent(parent);

				}

				if (parent.right != null) {
					parent.right.next = getNextFromNextParent(parent);

				}
				parent = parent.next;

			}
			// till now we are done at current level we need to move to next below level
			if (root.left != null)
				root = root.left;
			else if (root.right != null)
				root = root.right;
			else
				root = getNextFromNextParent(root);
		}
	}

	public TreeLinkNode getNextFromNextParent(TreeLinkNode parent) {
		// now we need to traverse in parent
		TreeLinkNode nextParent = parent.next;

		// case when reached to end of line
		if (nextParent == null)
			return null;

		TreeLinkNode next = null;
		while (nextParent != null) {

			// tough case when there is a parent

			if (nextParent.left != null)
				return nextParent.left;
			else if (nextParent.right != null)
				return nextParent.right;
			else
				nextParent = nextParent.next;

		}
		return next;
	}
}
