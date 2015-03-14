package ojTest;

import java.util.ArrayList;
import java.util.List;

public class PostorderBinaryTree {
	public static List<Integer> list = new ArrayList<Integer>();
	public static List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }
	public static void postorder(TreeNode root){
		if(root == null)return;
		postorder(root.left);
		postorder(root.right);
		if(root != null)
		list.add(new Integer(root.val));
	}
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		//TreeNode right = new TreeNode(3);
		root.left = left;
		//root.right = right;
		
		postorderTraversal(root);
		
		System.out.print(list);
	}
}
