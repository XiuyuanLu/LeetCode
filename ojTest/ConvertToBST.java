package ojTest;

public class ConvertToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num==null)return null;
		int n = num.length;
		
        TreeNode root = bst(num,0,n-1);
        return root;
    }
	
	public TreeNode bst(int[] num,int low, int high){		
		int middle = (low+high)/2;
		
		if(low>high)return null;
		
		TreeNode root = new TreeNode(num[middle]);
        root.left = bst(num,low,middle-1);
        root.right = bst(num,middle+1,high);
        
        return root;
	}
}
