import trees.*;
import java.util.*;

/**
 * Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * @author huangxin
 *
 */
public class Solution10 {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		stack.push(current);
		
		while (!stack.empty()) {
			current = stack.pop();
			result.add(current.val);
			// push the right child into the stack first
			if (current.right != null){
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
		return result;
    }
}
