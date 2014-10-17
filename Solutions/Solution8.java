import LinkedList.ListNode;

/**
 * Linked List Cycle II 
 * 
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null
 * 
 */

public class Solution8 {
	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode fastNode = head;
		ListNode slowNode = head;
		
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if(slowNode == fastNode) {
				break;
			}
		}
		
	    // error check
	    if (fastNode == null || fastNode.next == null) {
            return null;
	    }
	    
	    slowNode = head;
	    while (slowNode != fastNode) {
	        slowNode = slowNode.next;
	        fastNode = fastNode.next;
	    }
	    return fastNode;
	}
}