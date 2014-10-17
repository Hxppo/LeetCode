package trees;

import java.util.*;

public class TreeTraversal_Inorder {
	public static void inorder_recursive(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder_recursive(node.left);
		node.visit();
		inorder_recursive(node.right);
	}
	
	public static void inorder_nonrecursive(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = node;
		
		while (currentNode != null) {
			//将左子树完全压入栈中。
			//中序遍历，先压右子树，再压当前结点
			while (currentNode != null) {				
				if (currentNode.right != null) {
					stack.push(currentNode.right);
				}
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			
			currentNode = stack.pop();
			//若当前结点没有右结点，则沿着左子树逐渐上升一层
			while (!stack.isEmpty() && currentNode.right == null) {
				currentNode.visit(); // 访问左结点
				currentNode = stack.pop();
			}
			//否则表明当前结点有右子树。访问右子树
			currentNode.visit(); // 访问根结点
			//开始访问右子树
			if (!stack.isEmpty()) {
				currentNode = stack.pop();
			} else {
				currentNode = null;
			}
		}	
	}
}
