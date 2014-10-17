/**
 * Reverse Nodes in k-Group
 * 
 * @author huangxin
 *
 */
import LinkedList.ListNode;

public class Solution120 {
	public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode runner = dummy.next;
        
        int pos = 1;
        while (runner != null) {
        	while (pos < k && runner != null) {
        		pos++;
        		runner = runner.next;
        	}
        	if (runner != null) {
        		if (runner.next != null) {
        			runner = runner.next;
        			reverseLinkedList(pre, k);
        			for (int i = 0; i < k; i++) {
        				pre = pre.next;
        			}
	        		pos = 1;
        		} else {
        			reverseLinkedList(pre, k - 1);
        			ListNode node = pre;
        			for (int i = 1; i <= k - 1; i++) {
        				node = node.next;
        			}
        			runner.next = pre.next;
        			node.next = null;
        			pre.next = runner;
        			break;
        		}
        		
        	} 
        }
        
        return dummy.next;
    }
	
	// Using the same algorithm from solution81
	// In-Place solution 
	private static void reverseLinkedList(ListNode pre, int k) {
		ListNode cur = pre.next;
		
		int pos = 1;
		while (pos < k && cur != null) {
			ListNode boundary = cur.next.next;
			cur.next.next = pre.next;
			pre.next = cur.next;
			cur.next = boundary;
			pos++;
		}
		
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		
		ListNode node = reverseKGroup(n1, 3);
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
