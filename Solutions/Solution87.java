import java.util.*;
import trees.TreeNode;

/**
 * Unique Binary Search Trees II 
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * @author huangxin
 *
 */
public class Solution87 {
	public ArrayList<TreeNode> generateTrees(int n) {
        return generateHelper(1, n);
    }
	
	private ArrayList<TreeNode> generateHelper(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}
		
		for (int k = start; k <= end; k++) {
			ArrayList<TreeNode> leftTrees = generateHelper(start, k - 1);
			ArrayList<TreeNode> rightTrees = generateHelper(k + 1, end);
			// compute all the combinations
			TreeNode root = new TreeNode(k);
			for (TreeNode leftRoot: leftTrees) {
				for (TreeNode rightRoot: rightTrees) {
					root.left = leftRoot;
					root.right = rightRoot;
					result.add(root);
				}
			}
		} 
		return result;
 	}
}
