import trees.TreeNode;

/**
 * Balanced Binary Tree 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * @author huangxin
 *
 */
public class Solution37 {
	
    public boolean isBalanced(TreeNode root) {
       return isBalanced_Helper(root).isBalanced;
    }
    
    private TreeResult isBalanced_Helper(TreeNode root) {
    	TreeResult result = new TreeResult();
    	//base condition
    	if (root == null) {
    		result.hight = 0;
    		result.isBalanced = true;
    		return result;
    	}
    	
    	TreeResult left = isBalanced_Helper(root.left);
    	TreeResult right = isBalanced_Helper(root.right);
    	
    	if (left.isBalanced && right.isBalanced) {
    		double diff = Math.abs(left.hight - right.hight);
    		result.isBalanced = diff > 1 ?  false : true;
    	} else {
    		result.isBalanced = false;
    	}
    	result.hight = Math.max(left.hight, right.hight) + 1;
    	
    	return result;
    }
    
    class TreeResult {
        int hight;
        boolean isBalanced;
        
        TreeResult() {
        	hight = 0;
        	isBalanced = true;
        }
        
        TreeResult(int hight, boolean isBalanced) {
            this.hight = hight;
            this.isBalanced = isBalanced;
        }
    } 
}
