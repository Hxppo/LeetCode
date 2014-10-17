import LinkedList.ListNode;

/**
 * Remove Nth Node From End of List 
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * @author huangxin
 *
 */
public class Solution57 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) {
    		return null;
    	}
    	//create dummy head
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pointer1 = dummy;
    	ListNode pointer2 = dummy;
    	
    	for (int i = 0; i < n; i++) {
    		if (pointer1 == null) {
    			return null;
    		} else {
    			pointer1 = pointer1.next;
    		}
    	}
    	while (pointer1.next != null) {
    		pointer1 = pointer1.next;
    		pointer2 = pointer2.next;			
    	}
    	ListNode temp = pointer2.next;
    	pointer2.next = temp.next;
    	return dummy.next;
    }
   
    public static void main(String[] args) {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	node1.next = node2;
    	//ListNode temp = findNode(node1, 1);
    	ListNode temp = removeNthFromEnd(node1, 1);
    	System.out.println(temp);
    }
	
}
