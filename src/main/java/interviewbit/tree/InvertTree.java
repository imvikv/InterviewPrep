package interviewbit.tree;

public class InvertTree {

	public static void main(String[] args) {
		TreeNode root= SpiralOrder.createTree();
		new InvertTree().invertTree(root);
		System.out.println(root);
	}
	
	
	  public TreeNode invertTree(TreeNode A) {
	       if(A==null)
	    	   return A;
	       TreeNode left=invertTree(A.left);
	       TreeNode right=invertTree(A.right);
	       A.left=right;
	       A.right=left;
	       return A;
	    }
	   
}
