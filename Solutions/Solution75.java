import LinkedList.ListNode;
import trees.TreeNode;
import java.util.*;
/**
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author huangxin
 *
 */
public class Solution75 {
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        //convert linkedlist into array
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode pointer = head;
        while (pointer != null) {
        	arr.add(pointer.val);
        	pointer = pointer.next;
        }	
        //construct BST from sorted array
        return arrToBST(arr, 0, arr.size() - 1);
		
    }
	
	private TreeNode arrToBST(ArrayList<Integer> arr, int start, int end) {
		if (start > end) {
			return null;
		}

		int index = (start + end) / 2;
		int val = arr.get(index);
		TreeNode root = new TreeNode(val);
		root.left = arrToBST(arr, start, index - 1);
		root.right = arrToBST(arr, index + 1, end);
		
		return root;	
	}
}
