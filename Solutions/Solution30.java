import trees.TreeNode;
//import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * Bonus points if you could solve it both recursively and iteratively.
 * @author huangxin
 *
 */
public class Solution30 {
	/*
	 * 解法1： 采用递归的方式
	 * 其实质依旧是按照不同的题目要求进行递归遍历树。在这里由于要求比较是否对称，则按照左右子树
	 * 的对应顺序进行遍历。（类似前序遍历）
	 */
    public static boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	return isSymmetric_Helper(root.left, root.right);
    }
    
    private static boolean isSymmetric_Helper(TreeNode node1, TreeNode node2){
    	//base condition
    	if (node1 == null && node2 != null) {
    		return false;
    	}
    	if (node1 != null && node2 == null) {
    		return false;
    	}
    	if (node1 == null && node2 == null) {
    		return true;
    	}
    	
    	
    	if (node1.val != node2.val) {
    		return false;
    	}
    	return isSymmetric_Helper(node1.left, node2.right) && 
    			isSymmetric_Helper(node1.right, node2.left);
    }
    
    /*
     * 解法2: 采用循环的方式实现
     * 将左侧与右侧结点结点值分别存入两个链表，并比较是否相同。
     * 这里需要注意认为的调整顺序
     */
    
    public static boolean isSymmetric_iterative(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
    	LinkedList<TreeNode> left = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> right = new LinkedList<TreeNode>();
    	
    	left.addLast(root.left);
    	right.addLast(root.right);
    	
    	while(!left.isEmpty() && !right.isEmpty()) {
    		TreeNode leftNode = left.removeFirst();
    		TreeNode rightNode = right.removeFirst();
    		
    		if ((leftNode == null && rightNode != null) ||
    				(leftNode != null && rightNode == null)) {
    			return false;
    		}
    		if (leftNode != null && rightNode != null) {
    			if (leftNode.val != rightNode.val) {
    				return false;
    			} else {
    				left.addLast(leftNode.left);
    				left.addLast(leftNode.right);
    				right.addLast(rightNode.right);
    				right.addLast(rightNode.left);
    			}
    		}
    	}
    	return true;
    	
    }
    
}
