package interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {

	public static void main(String[] args) {
		TreeNode root= SpiralOrder.createTree();
		new Inorder().inorderTraversal(root);
	}
	
	
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
        // we will use a stack to reach till the dead end left side and push everything till there
        ArrayList<Integer> result= new ArrayList<Integer>();
        Stack<TreeNode> s= new Stack<TreeNode>();
        TreeNode curr=A;
        while(curr !=null || s.size()>0)
        {
            //now reach till the left most
            while(curr !=null)
            {
                s.push(curr);
                curr=curr.left;
            }
            //now reached till the left most of this tree
            // time to print
            curr=s.pop();
            result.add(curr.val);
            curr=curr.right;
        }
        return result;
    }
}
