import trees.*;

/**
 * Sum Root to Leaf Numbers 
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * @author Huangxin
 *
 */
public class Solution21 {
    public int sumNumbers(TreeNode root) {
    	return sumNumbersHelper(root, 0);
    }
    
    /**
     * 典型的divide and conquer算法，这里递归树就是所给的二叉树
     * 分拆成子问题，在递归调用返回的时候计算最终值； 注意边界条件
     * @param root 当前子树的根节点
     * @param sum 当前已经求得的和
     * @return 当前子树在已有输入sum的情况下最后的求和值
     */
    public int sumNumbersHelper(TreeNode root, int sum) {
    	// base condition
    	if (root == null) {
    		return 0;
    	}
    	
    	if (root.left == null && root.right == null) {
    		// we have reach the leaf. Computation is ended
    		return sum * 10 + root.val;
    	}
    	return sumNumbersHelper (root.left, sum * 10 + root.val) + sumNumbersHelper(root.right, sum * 10 + root.val);
    }
}
