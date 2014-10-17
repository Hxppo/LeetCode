/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * @author huangxin
 *
 */
import trees.TreeNode;
import java.util.*;

public class Solution115 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0 || postorder.length <= 0) return  null;
        
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
        	inorderMap.put(inorder[i], i);
        }
        
        return buildTree_Helper(inorder, 0, postorder.length - 1, postorder, postorder.length - 1, inorderMap);
    }
	
	private TreeNode buildTree_Helper(int[] inorder, int start, int end, int[] postorder, int cur,
			HashMap<Integer, Integer> inorderMap) {
		TreeNode root = new TreeNode(postorder[cur]);
		
		if (start < end) {
			int mid = inorderMap.get(postorder[cur]);
			if (start < mid) {
				root.left = buildTree_Helper(inorder, start, mid - 1, postorder, cur - (end - mid + 1), inorderMap);
			}
			if (end > mid) {
				root.right = buildTree_Helper(inorder, mid + 1, end, postorder, cur - 1, inorderMap);
			}
		}
		
		return root;
	}
}
