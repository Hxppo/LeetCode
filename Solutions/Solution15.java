import java.util.LinkedList;
import trees.*;

/**
 * Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author huangxin
 *
 */


public class Solution15 {
	
	public int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int depth = 0; //默认根结点的深度为零
        int newCount = 1;
        int oldCount = 1;
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        
        // do breadth first search
        q.addLast(root);
        
        while(!q.isEmpty()) {
        	oldCount = newCount;
        	newCount = 0;
        	for (int i = 0; i < oldCount; i++) {
        		TreeNode current = q.removeFirst();
        		if (current.left != null) {
        			q.addLast(current.left);
        			newCount++;
        		}
        		if (current.right != null) {
        			q.addLast(current.right);
        			newCount++;
        		}
        	}
        	depth++;
        }
        return depth;
    }
}
