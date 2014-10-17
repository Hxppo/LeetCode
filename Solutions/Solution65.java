import trees.TreeNode;
import java.util.ArrayList;

/**
 * Path Sum II 
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * @author huangxin
 *
 */
public class Solution65 {
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	pathSumHelper(root, sum, res, list);
    	return res;
    }
    
    private static void pathSumHelper(TreeNode root, int sum, 
    		ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
    	if(root == null) {
    		return;
    	}
    	
    	if(root.val == sum && root.left == null && root.right == null) {
    		list.add(root.val);
    		ArrayList<Integer> temp = new ArrayList<Integer>(list);
    		res.add(temp);
    		return;
    	}
    	
    	list.add(root.val); 
    	
    	if(root.left != null) {
    		pathSumHelper(root.left, sum - root.val, res, list);
    		list.remove(list.size() - 1);
    	}
    	if(root.right != null) {
    		pathSumHelper(root.right, sum - root.val, res, list);
    		list.remove(list.size() - 1);
    	}
    	
    	return; 	    	
    }
    
    public static void main(String[] args) {
    	TreeNode node0 = new TreeNode(1);
    	TreeNode node1 = new TreeNode(2);
    	node0.left = node1;
    	System.out.println(pathSum(node0, 3));
    }
}
