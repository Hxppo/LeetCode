import java.util.LinkedList;
import trees.TreeLinkNode;

/**
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * @author huangxin
 *
 */

public class Solution28 {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		// do level order traverse
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int oldCount = 1;
		int newCount = 1;
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			oldCount = newCount;
			newCount = 0;
			TreeLinkNode lastNode = null;
			for (int i = 0; i < oldCount; i++) {
				TreeLinkNode node = queue.removeFirst();
				if (i == 0) {
					//first node: there is no last node
					lastNode = node;
				} else if (i == oldCount -1) {
					//we have reach the end
					lastNode.next  = node;
					node.next = null;
				} else {
					lastNode.next = node;
				    lastNode = node;
				}
				if (node.left != null) {
					queue.addLast(node.left);
					newCount++;
				}
				if (node.right != null) {
					queue.addLast(node.right);
					newCount++;
				}			
			}	
		}	
	}
}

