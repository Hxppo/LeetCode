/**
 * Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * @author huangxin
 *
 */
import trees.TreeNode;

public class Solution137 {
	/*
	 * Define helper function, it returns the maximum path that ending at v
	 * 而最大的情况可以发生下一下四种情况之一：
	 * 1> 左子结点加上根节点组成的路径
	 * 2> 右子结点加上根节点组成的路径
	 * 3> 左子结点经过根节点再加上右子结点路径组成的arch
	 * 4> 根节点本身
	 */
	
	public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] max = {Integer.MIN_VALUE};
        rec(root, max);  
        return max[0];  
    }
	
	private static int rec(TreeNode root, int[] max) {
		// base condition 
		if (root == null) return 0;
		
		int leftSubtreeMaxSum = rec(root.left, max);      
        int rightSubtreeMaxSum = rec(root.right, max);  
        int arch = leftSubtreeMaxSum + root.val + rightSubtreeMaxSum;   

		
		// compute return value
        int maxPathAcrossRootToParent = Math.max(root.val, Math.max(leftSubtreeMaxSum, rightSubtreeMaxSum)+root.val);  
		// update max value
        max[0] = Math.max(max[0], Math.max(arch, maxPathAcrossRootToParent));   
		
		return maxPathAcrossRootToParent;
	}
	
}
