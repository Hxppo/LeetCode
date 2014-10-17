/**
 * Sort List
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author huangxin
 *
 */
import LinkedList.ListNode;

public class Solution133 {
    public static ListNode sortList(ListNode head) {
        // base condition
    	if (head == null) return null;
    	if (head.next == null) return head;
    	
    	ListNode l1 = head;
    	ListNode l2 = divideList(head);
    	ListNode resList1 = sortList(l1);
    	ListNode resList2 = sortList(l2);
    	
    	ListNode newHead = mergeTwoLists(resList1, resList2);
    	
    	return newHead;
    }

    
    private static ListNode divideList(ListNode head) {
    	ListNode runner = head;
    	int length = 0;
    	while (runner != null) {
    		runner = runner.next;
    		length++;
    	}
    	
    	runner = head;
    	for (int i = 0; i < length / 2 - 1; i++) {
    		runner = runner.next;
    	}
    	ListNode res = runner.next;
    	runner.next = null;
    	
    	return res;
    }
    
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(2);
    	ListNode n2 = new ListNode(1);
    	n1.next = n2;
    	sortList(n1);
    }
}
