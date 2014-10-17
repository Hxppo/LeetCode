import LinkedList.ListNode;

/**
 * Reverse Linked List II 
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * @author huangxin
 *
 */
public class Solution81 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode pre = dummy;
    	ListNode cur = dummy.next;
    	int pos = 1;
    	//find beginning position 
    	while (pos < m && cur != null) {
    		pre = cur;
    		cur = cur.next;
    		pos++;
    	}
    	
    	//reverse the linked list
    	while (pos < n && cur != null) {
    		ListNode boundary = cur.next.next;
    		cur.next.next = pre.next;
    		pre.next = cur.next;
    		cur.next = boundary;
    		pos++;
    	}
    	return dummy.next;
    }
}
