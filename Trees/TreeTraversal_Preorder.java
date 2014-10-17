package trees;

import java.util.*;
public class TreeTraversal_Preorder {
	public static void preorderTraverse_recursive (TreeNode node) {
		if (node != null) {
			// 前序遍历： 首先访问根节点
			node.visit();
			// 访问左子树
			preorderTraverse_recursive(node.left);
			// 访问右子树
			preorderTraverse_recursive(node.right);
		}
	}
	
	/**
	 * 前序遍历：
	 * 先压结点，再压右子树，最后压入左子树
	 * 
	 */

	public static void postorderTraverse_nonrecursive (TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (node == null) {
			return;
		}
		TreeNode current = node;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.pop();
			current.visit();
			if(current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

}
