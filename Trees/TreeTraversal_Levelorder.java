package trees;

import java.util.*;

public class TreeTraversal_Levelorder {
	public static void levelorderTraverse(TreeNode node) {
		Queue_TreeNode queue = new Queue_TreeNode();
		if (node == null) {
			return;
		}
		queue.enqueue(node);
		while (!queue.isEmpty()){
			TreeNode current = queue.dequeue();
			current.visit();
			if (current.left != null) {
				queue.enqueue(current.left);
			}
			if (current.right != null) {
				queue.enqueue(current.right);
			}	
		}
	}
}

class Queue_TreeNode {
	LinkedList<TreeNode> list;
	int size;
	// constructor 
	Queue_TreeNode() {
		list = new LinkedList<TreeNode>();
		size = list.size();
	}
	
	void enqueue(TreeNode node){
		list.addLast(node);
	}
	
	TreeNode dequeue() {
		return list.removeFirst();
	}
	
	TreeNode front() {
		return list.peek();
	}
	
	boolean isEmpty(){
		return list.isEmpty();
	}
}
