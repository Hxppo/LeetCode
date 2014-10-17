import trees.TreeNode;

/**
 * Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * @author huangxin
 *
 */

public class Solution16 {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		
		if(sum == root.val && root.left == null 
				&& root.right == null) {
			return true;
		}
		if(root.left != null) {
			if(hasPathSum(root.left, sum - root.val)) {
				return true;
			}
		}
		if(root.right != null) {
			if(hasPathSum(root.right, sum - root.val)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {}
	
}
