import java.util.*;
import trees.TreeNode;

/**
 * Binary Tree Level Order Traversal II 
 * Given a binary tree, return the bottom-up level order traversal
 * of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * @author huangxin
 *
 */
public class Solution36 {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (root == null) {
			return result;
		}
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		TreeNode node;
		
		int newCount = 1;
		int oldCount = 1;
	
		while(!q.isEmpty()) {
			ArrayList<Integer> buffer = new ArrayList<Integer>();
			oldCount = newCount;
			newCount = 0;
			for (int i = 0; i < oldCount; i++) {
				node = q.removeFirst();
				buffer.add(node.val);
				if (node.left != null) {
					q.addLast(node.left);
					newCount++;
				}
				if (node.right != null) {
					q.addLast(node.right);
					newCount++;
				}
			}
			result.add(buffer);
		}
		Collections.reverse(result);
		return result;
    }
}
