import java.util.*;
import trees.TreeNode;

/**
 * Binary Tree Inorder Traversal
 * 
 * @author huangxin
 *
 */
public class Solution12 {
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null) {
        	while (current != null) {
        		// push the right node into stack
        		if (current.right != null) {
        			stack.push(current.right);
        		}
        		// push the current node
        		stack.push(current);
        		current = current.left;
        	}
        	current = stack.pop();
        	// if current node doesn't have right child and stack is not empty, visit current node
        	while (current.right == null && !stack.isEmpty()) {
        		result.add(current.val);
        		current = stack.pop();
        	}
        	result.add(current.val); // visit current node
        	if (!stack.isEmpty()) {
        		current = stack.pop(); // begin to visit the right subtree
        	} else {
        		current  = null;
        	}
        	
        }
        return result;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	ArrayList<Integer> result = inorderTraversal(root);
    	System.out.println(result.get(0));
    	
    }
    
    
}
