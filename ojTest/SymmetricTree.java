package ojTest;

import java.util.ArrayList;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return scan(root.left,root.right);
    }
	public boolean scan(TreeNode left,TreeNode right){
		if(left == null && right == null)return true;
		if(left == null && right != null)return false;
		if(right == null && left != null)return false;
		return left.val == right.val && scan(left.left,right.right) && scan(left.right,right.left);
	}
	public void reorder(int[] a){
		
	}
	public static void main(String args[]){
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(2);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(4);

		tn1.left = tn2;
		tn2.left = tn3;
		tn3.left = tn4;
		tn3.right = tn5;
		
		SymmetricTree s = new SymmetricTree();
		System.out.println(s.isSymmetric(tn1));
	}
}
