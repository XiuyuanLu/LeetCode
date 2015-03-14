package ojTest;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return sum(root,sum,0);
    }
	public boolean sum(TreeNode root,int sum,int current)
	{
		if(root == null)return false;
		if(root.left == null && root.right == null)
		{
			return current + root.val == sum;
		}
		return sum(root.left,sum,current+root.val)||sum(root.right,sum,current+root.val);
	}
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root,sum,0,list);
        return result;
    }
	
	public void dfs(TreeNode root, int sum, int current ,List<Integer> list)
	{
		if(root == null)return;
		if(root.left == null && root.right == null)
		{
			if(current+root.val == sum)
			{
				list.add(root.val);
				result.add(list);
			}
			return;
		}
		list.add(root.val);
		dfs(root.left,sum,current+root.val,list);
		dfs(root.right,sum,current+root.val,list);
	}
	
	public static void main(String args[]){
		PathSum a = new PathSum();
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		int sum = 7;
		tn1.left = tn2;
		tn2.left = tn3;
		tn2.left = tn4;
		a.pathSum(tn1, sum);
		System.out.println(a.result);
	}
	
}
