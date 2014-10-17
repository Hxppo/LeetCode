import LinkedList.ListNode;
/**
 * Merge two sorted linkedlist
 * 
 * @author huangxin
 *
 */
public class Solution29 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) {
    		return null;
    	}
    	if (l1 == null && l2 != null) {
    		return l2;
    	}
    	if (l1 != null && l2 == null) {
    		return l1;
    	}
    	ListNode head;
    	ListNode pointer1;
    	ListNode pointer2;
    	if (l1.val < l2.val) {
    		head = new ListNode(l1.val);
    		pointer1 = l1.next;
    		pointer2 = l2;
    	} else {
    		head = new ListNode(l2.val);
    		pointer1 = l1;
    		pointer2 = l2.next;
    	}
        ListNode newList = head;
        while(pointer1 != null && pointer2 != null) {
        		ListNode node;
        	if (pointer1.val < pointer2.val) {
        		node = new ListNode(pointer1.val);		
        		pointer1 = pointer1.next;
        	} else {
        		node = new ListNode(pointer2.val);
        		pointer2 = pointer2.next;
        	}
    		newList.next = node;
    		newList = node;
        }
        
        if (pointer1 == null) {
        	newList.next = pointer2;
        }
        if (pointer2 == null) {
        	newList.next = pointer1;
        }    
        return head;
    }
}
