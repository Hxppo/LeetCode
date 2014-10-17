import trees.TreeNode;
import LinkedList.ListNode;
import java.util.*;
/**
 * Flatten Binary Tree to Linked List 
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * @author huangxin
 *
 */

public class Solution76 {
	//define the list
	ListNode head;
	ListNode pointer;
	/*
	 * Solution1: Recursive Better Solution
	 * Return the last node after recursive (right most node)
	 * 1) Save the right substree
	 * 2) Append the left subtree to the left of the node; Flatten the left subtree
	 * 3) Append the saved right subtree back to newly flatten subtree, and flatten the saved right subtree
	 * 
	 */
	private TreeNode flatten_recursive(TreeNode root) {
		// base condition: root equals to null
		if (root == null) {
			return null;
		}
		// save right subtree
		TreeNode rtree = root.right;
		// append the left subtree to the right if it 
		if (root.left != null) {
			root.right = root.left;
			root.left = null;
			root = flatten_recursive(root.right);
		}
		// append the previous right subtree back if it exists
		if (rtree != null) {
			root.right = rtree;
			root = flatten_recursive(root.right);
		}
		return root;
	}
	
	public void flatten(TreeNode root) {
		flatten_recursive(root);
	}
	
	/*
	 * Solution2: Non-recursive Solution with Stack
	 * Use stack to store right subtree
	 * 1) If it has left subtree, store the right subtree(if not null) to stack. Move the left subtree to right
	 * 2) If not, append back a substree from the stack to the current node's right
	 * 3) continue to the right node until finish
	 */
	public void flatten_nonRecursive(TreeNode root) {
		TreeNode cur = root;
		Stack<TreeNode> rtrees = new Stack<TreeNode>();
		
		while (cur != null) {
			while (cur.left != null) {
				if (cur.right != null) rtrees.push(cur.right);
				root.right = root.left;
				cur = cur.right;
			}
			
			if (cur != null && cur.right == null && !rtrees.isEmpty()) {
				cur.right = rtrees.pop();
			}
			cur = cur.right;
		}
	}
	
	
	/*
	 * Solution3: recursive
	 */
	public void flatten3_(TreeNode root) {
        if (root != null) {
        	convertToLink(root);
        }
    }
    
    private TreeNode convertToLink(TreeNode node) {
    	if(node.left == null && node.right == null) {
    		return node;
    	}
    	//Flatten right subtree if it exists 
    	TreeNode rHead = null;
    	if(node.right != null) {
    		rHead = convertToLink(node.right);
    	}
    	
    	//Flatten the right subtree
    	TreeNode pointer = node;
    	if(node.left != null) {
    		TreeNode lHead = convertToLink(node.left);
    		lHead.left = null;
    		node.right = lHead;
    		node.left = null;
    		//find the deepest node of the left subtree
    		while(pointer.right != null) {
    			pointer = pointer.right;
    		}
    	}
    	
    	//attach the flattened right subtree on to the flattened left subtree
    	if (rHead != null) {
    		pointer.right = rHead;
    		rHead.left = null;
    	}	
    	return node; 	
    }
	
    /*
     * Solution4: Algorithm Not in Place 
     */
	public void flatten4_NotInPlace(TreeNode root) {
		if (root != null) {
			head = new ListNode(root.val);
			pointer = head;
			flatten_helper(root.left);
			flatten_helper(root.right);
		} 
		
	}
	
    public void flatten_helper(TreeNode root) {
    	if (root != null) {
    		ListNode node = new ListNode(root.val);
    		pointer.next = node;
    		pointer = pointer.next;
    		flatten_helper(root.left);
    		flatten_helper(root.right);
    	}
    }
	
    
}
