import LinkedList.ListNode;

/**
 * Add Two Numbers 
 * 
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * @author huangxin
 */

public class Solution34 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
        	return null;
        }
        
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int cin = (l1.val + l2.val) / 10;
        
        ListNode pointer = result;
        ListNode pointer1 = l1.next;
        ListNode pointer2 = l2.next;
        
        
        while (pointer1 != null && pointer2 != null) {
        	pointer.next = new ListNode((pointer1.val + pointer2.val + cin) % 10);
        	cin = (pointer1.val + pointer2.val + cin) / 10;
        	pointer = pointer.next;
        	pointer1 = pointer1.next;
        	pointer2 = pointer2.next;
        }
        
        if (pointer1 != null) {
        	while (pointer1 != null) {
        		pointer.next = new ListNode((pointer1.val + cin) % 10);
	        	cin = (pointer1.val + cin) / 10;
	        	pointer = pointer.next;
	        	pointer1 = pointer1.next;
        	}
        	
        }
        
        if (pointer2 != null) {
        	while (pointer2 != null) {
        		pointer.next = new ListNode((pointer2.val + cin) % 10);
	        	cin = (pointer2.val + cin) / 10;
	        	pointer = pointer.next;
	        	pointer2 = pointer2.next;
        	}
        }
        
        if (cin != 0) {
        	pointer.next = new ListNode(cin);
        }  
        return result;
    }
}
