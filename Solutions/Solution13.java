
import java.util.LinkedList;
import trees.TreeNode;
import java.util.*;

/**
 * Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @author huangxin
 *
 */
public class Solution13 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        LQueue<TreeNode> queue = new LQueue<TreeNode>();
        
        queue.enqueue(root);
        int oldCount = 1;
        int newCount = 1;
        
        while(!queue.isEmpty()) {
        	oldCount = newCount;
        	newCount = 0;
        	for (int i = 0; i < oldCount; i++) {
        		TreeNode current = queue.dequeue();
        		level.add(current.val);
        		if (current.left != null) {
        			queue.enqueue(current.left);
        			newCount++;
        		}
        		if (current.right != null) {
        			queue.enqueue(current.right);
        			newCount++;
        		}
        	}
        	result.add(level);
        	level = new ArrayList<Integer>();
        }  
        return result;
    }
}

class LQueue<T> {
	LinkedList<T> list;
	int size;
	// constructor 
	LQueue() {
		list = new LinkedList<T>();
		size = list.size();
	}
	
	void enqueue(T node){
		list.addLast(node);
	}
	
	T dequeue() {
		return list.removeFirst();
	}
	
	T front() {
		return list.peek();
	}
	
	boolean isEmpty(){
		return list.isEmpty();
	}
}