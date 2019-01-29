package interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		LevelOrderTraversal lt = new LevelOrderTraversal();
		TreeNode root = lt.addNode(3);
		root.left = lt.addNode(9);
		TreeNode right = lt.addNode(20);
		right.left = lt.addNode(15);
		right.right = lt.addNode(7);
		root.right = right;
		ArrayList<ArrayList<Integer>> lord = lt.levelOrder(root);
		System.out.println(lord);
	}

	// Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public TreeNode addNode(int x) {
		return new TreeNode(x);
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> sub = new LinkedList<TreeNode>();
		sub.add(A);

		createLevelorder(sub, returnList);
		return returnList;
	}

	public void createLevelorder(Queue<TreeNode> q, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> subList = new ArrayList<Integer>();
		ArrayList<Integer> depthList = new ArrayList<Integer>();
		int depth = 0;
		while (!q.isEmpty()) {
			TreeNode B = q.poll();
			subList.add(B.val);
			// result.add(subList);
			depthList.add(depth);
			// enqueue left and right
			if (q.isEmpty())
				depth++;
			if (B.left != null)
				q.add(B.left);
			if (B.right != null)
				q.add(B.right);

		}
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(subList.get(0));
		for (int i = 1; i < subList.size(); i++) {

			if (depthList.get(i) != depthList.get(i - 1)) {
				result.add(one);
				one = new ArrayList<Integer>();

			}

			one.add(subList.get(i));
		}
		result.add(one);
	}

}
