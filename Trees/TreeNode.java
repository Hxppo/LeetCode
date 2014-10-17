package trees;

/**
 * Definition for binary tree
 * @author huangxin
 *
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int x) {
		this.val = x;
	}
	
	public void visit() {
		System.out.println(val);
	}
}
