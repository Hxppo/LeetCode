/**
 * Validate Binary Search Tree 
 * 
 * @author huangxin
 *
 */
import trees.TreeNode;

public class Solution119 {
	public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        
        return vaildBST_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean vaildBST_helper(TreeNode root, int min, int max) {
		if (root == null) return true;
		
		if (root.val <= min || root.val >= max) {
			return false;
		} else {
			return vaildBST_helper(root.left, min, root.val) &&
					vaildBST_helper(root.right, root.val, max);
		}
		
	}
}
