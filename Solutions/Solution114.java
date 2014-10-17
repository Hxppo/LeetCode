/**
 * Partition List 
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author huangxin
 *
 */
import LinkedList.ListNode;

public class Solution114 {
	public ListNode partition(ListNode head, int x) {
		if (head == null) return head;
		
		ListNode dummy1 = new ListNode(0);
		ListNode pointer1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode pointer2 = dummy2;
		
		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				pointer1.next = new ListNode(node.val);
				pointer1 = pointer1.next;
			} else {
				pointer2.next = new ListNode(node.val);
				pointer2 = pointer2.next;
			}
			node = node.next;
		}
		
		// merge two linked list into one
		pointer1.next = dummy2.next;
		
		return dummy1.next;
		
    }
}
