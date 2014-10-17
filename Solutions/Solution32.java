import trees.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author huangxin
 *
 */

public class Solution32 {
    public static TreeNode sortedArrayToBST(int[] num) {
    	if (num == null || num.length == 0) {
    		return null;
    	}
    	
        return sortedArrayToBST_Helper(num, 0, num.length - 1);
    }
    
    private static TreeNode sortedArrayToBST_Helper(int[] num, int low, int high) {
    	if (low > high) {
    		return null;
    	}
    	int mid = (low + high) / 2;
    	TreeNode node = new TreeNode(num[mid]);
    	node.left = sortedArrayToBST_Helper(num, low, mid - 1);
    	node.right = sortedArrayToBST_Helper(num, mid + 1, high);
    	return node;
    }
    
    public static void main(String[] args) {
    	int[] test = {1, 2, 3};
		TreeNode node = sortedArrayToBST(test);
    	System.out.println(node);
    }
    
}
