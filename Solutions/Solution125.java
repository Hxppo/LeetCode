/**
 * Recover Binary Search Tree 
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * @author huangxin
 *
 */
import trees.TreeNode;

public class Solution125 {
	private TreeNode first = null;		// first wrong placed node
	private TreeNode second = null;	// second wrong placed node
	private TreeNode pre = null;	// point to the previous visiting node
	
	public void recoverTree(TreeNode root) {
		// Base case
		if (root == null) return;
		findNode(root);
		
		System.out.println(first.val);
		System.out.println(second.val);
		
		if (first != null && second != null){
			swapNode(first, second);
		}
    }
	
	private void swapNode(TreeNode n1, TreeNode n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}
	
	// 利用中序遍历in-order traversal 找到两个错误的结点。
	// 利用递归版的中序遍历
	private void findNode(TreeNode root) {
		if (root == null) return;
		
		// visit left child
		findNode(root.left);
		// visit root 
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val > root.val) {
				if (first == null) {
					// we find the first pair
					first = pre;
				}
				second = root;
			}
			pre = root;
		}
		// visit right child
		findNode(root.right);
	}
}
