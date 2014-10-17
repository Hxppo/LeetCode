import java.util.*;
import trees.TreeNode;

/**
 * Binary Postorder Traversal
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * @author huangxin
 *
 */
public class Solution11 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (root == null) {
    		return result;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode currentNode = root;
    	TreeNode lastNode = root;
    	
    	while (currentNode != null) {
    		//将除了左子树最左结点之外的所有左节点压入stack
    		while (currentNode.left != null) {
    			stack.push(currentNode);
    			currentNode = currentNode.left;
    		}
    		
    		//检查当前结点的右结点是否为空（则沿左子树上升一层）
    		//检查当前结点的右结点是否已经是最后访问的结点（则沿右子树上升一层）
    		while (currentNode.right == null || currentNode.right == lastNode) {
    			result.add(currentNode.val);
    			lastNode = currentNode;
    			if (stack.isEmpty()) {
    				return result;
    			}
    			currentNode = stack.pop();
    		}
    		
    		//如果当前结点右右结点
    		stack.push(currentNode);
    		currentNode = currentNode.right;
    	}
    	return result;  	
    }
}