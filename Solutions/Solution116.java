/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * @author huangxin
 *
 */
import java.util.HashMap;

import trees.TreeNode;

public class Solution116 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length <= 0 || preorder.length <= 0) return  null;
        
        HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
        	inorderMap.put(inorder[i], i);
        }
        
        return buildTree_Helper(inorder, 0, preorder.length - 1, preorder, 0, inorderMap);
    }
	
	private TreeNode buildTree_Helper(int[] inorder, int start, int end, int[] preorder, int cur,
			HashMap<Integer, Integer> inorderMap) {
		TreeNode root = new TreeNode(preorder[cur]);
		if (start < end) {
			int mid = inorderMap.get(preorder[cur]);
			if (start < mid) {
				root.left = buildTree_Helper(inorder, start, mid - 1, preorder, cur + 1, inorderMap);
			}
			if (mid < end) {
				root.right = buildTree_Helper(inorder, mid + 1, end, preorder, cur + mid - start + 1, inorderMap);
			}
		}
		
		return root;
	}
}
