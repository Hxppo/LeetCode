import trees.TreeNode;
import java.util.LinkedList;
/**
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path 
 * from the root node down to the nearest leaf node.
 * @author huangxin
 *
 */
public class Solution27 {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		//breadth first search
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		
		int level = 1;
		int newCount = 1;
		int oldCount = 1;
		
		while(!q.isEmpty()){
			oldCount = newCount;
			newCount = 0;
			for (int i = 0; i < oldCount; i++) {
				TreeNode node = q.removeFirst();
				if (node.left == null && node.right == null){
					return level;
				}
				if (node.left != null) {
					q.addLast(node.left);
					newCount++;
				} 
				if (node.right != null) {
					q.addLast(node.right);
					newCount++;
				}
			}
			level++;
		}
		return level;
    }
	
}
