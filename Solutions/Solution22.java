import java.util.LinkedList;
/**
 * Populating Next Right Pointers in Each Node
 * 
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * @author huangxin
 *
 */
public class Solution22 {
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

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		this.val = x;
	}
}