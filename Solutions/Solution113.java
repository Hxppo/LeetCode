/**
 * Binary Tree Zigzag Level Order Traversal 
 * 
 * 
 * @author huangxin
 *
 */
import java.util.*;
import trees.TreeNode;

public class Solution113 {
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// corner case
		if (root == null) return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode node;
		int level = 0;
		
		while (!stack.isEmpty()) {
			Stack<TreeNode> tempStack = new Stack<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			while (!stack.isEmpty()) {
				node = stack.pop();
				list.add(node.val);
				
				if (level % 2 == 0) {
					// push left than push right
					if (node.left != null) tempStack.push(node.left);
					if (node.right != null) tempStack.push(node.right);
				} else {
					if (node.right != null) tempStack.push(node.right);
					if (node.left != null) tempStack.push(node.left);
				}
			}
				
			level++;
			res.add(new ArrayList<Integer>(list));
			stack = tempStack;
		}
		
	    return res;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		
		zigzagLevelOrder(n1);
		
	}
		
}
