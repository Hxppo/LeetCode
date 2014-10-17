 package trees;

import java.util.*;

public class TreeTraversal_Postorder {
	public static void postorderTraverse_recursive (TreeNode node) {
		if (node != null) {
			// 访问左子树
			postorderTraverse_recursive(node.left);
			// 访问右子树
			postorderTraverse_recursive(node.right);
			// 访问结点
			node.visit();
		}
	}
	
	
	/** 
	 *  采用stack缓存方式实现：
	 *  
	 *  除了最左的一个左子结点，把其它所以的左子结点相继入栈（是一个循环过程）
	 *  这时p指向最左的一个左子结点
	 *  重复：若p没有右子结点（或者p的右子结点已经输出），则输出p，同时出栈。将值赋给q
	 *  若p有右子节点，或者其右子结点不是最近访问的一个结点，则将p重新压入栈，同时指向其右子结点
	 *  重复以上步骤，重复以上步骤，直到p为空
	 */
	public static void preorderTraverse_nonrecursive(TreeNode node) {	
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode lastVisitedNode = node;
		TreeNode currentNode = node;
		while (currentNode != null) {
			// 将左子树依次压栈，除却最左的一个左子结点
			// 访问树的深度逐渐加深，直至左子树的最左子结点
			while (currentNode.left != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			
			// 当前节点没有右子结点，或者已经访问过
			// 则此时可以将栈弹出一层（树的访问的深度减一）
			while(currentNode.right == null || currentNode.right == lastVisitedNode) {
				currentNode.visit();
				lastVisitedNode = currentNode;
				// 检查当前stack是否为空；
				// 为空则表示已访问完所有结点
				if (stack.isEmpty()){
					return;
				}
				currentNode = stack.pop(); // 弹出当前结点的父节点
			}
			
			// 处理右子结点
			stack.push(currentNode);
			currentNode = currentNode.right;
			
				
		}
		
	}
	
	
}