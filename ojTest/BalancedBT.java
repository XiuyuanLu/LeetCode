package ojTest;

import java.util.HashMap;

public class BalancedBT {
//	public static boolean isBalanced(TreeNode root) {
//		if(root == null)return true;		
//		boolean t = false;
//		boolean left = isBalanced(root.left);
//		boolean right = isBalanced(root.right);
//		
//		int diff = maxDepth(root.left)-maxDepth(root.right);
//		if(diff>1 || diff<-1)t = false;
//		else t = true;
//		
//        return t&&left&&right;
//    }
//	
//	public static int maxDepth(TreeNode root) {
//        if(root == null)return 0;
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        return (left<right?right+1:left+1);
//    }
	public static HashMap<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
	public static boolean isBalanced(TreeNode root){
		
		
		if(root == null)
		{
			map.put(null, 0);
			return true;
		}
		
		if(isBalanced(root.left) && isBalanced(root.right)){
			if(map.get(root.left)-map.get(root.right)>1 || 
					map.get(root.left)-map.get(root.right)>1)
				return false;
			else{
				int height = map.get(root.left)>map.get(root.right)?map.get(root.left):map.get(root.right);
				map.put(root, height);
				return true;
			}
		}else{
			return false;
		}
		
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(3);
		TreeNode root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		node3.right = node6;
		node6.left = node7;
		System.out.println(isBalanced(root));
	}
}
