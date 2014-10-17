import LinkedList.ListNode;

/**
 * Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head
 * Your algorithm should only use constant space. 
 * You may not modify the values in the list, only nodes itself can be changed. 
 * @author huangxin
 *
 */

public class Solution33 {
    public ListNode swapPairs(ListNode head) {
    	//boundary condition
    	if (head == null) {
    		return null;
    	}
    	//size is 1
    	if (head.next == null) {
    		return head;
    	}
    	//otherwise the size of the array is more than 2
    	ListNode helperHead = new ListNode(0);
    	helperHead.next = head; //make helperHead always pointing at the head of the list.
    	//As it is singly linked list, we have to define three pointer to memorize the location
    	ListNode n0 = helperHead;
    	ListNode n1 = head;
    	ListNode n2;
    	while (n1 != null && n1.next != null) {
    		n2 = n1.next;
    		
    		n0.next = n2;
    		n1.next = n2.next;
    		n2.next = n1;
    		
    		n0 = n0.next.next;
    		n1 = n2.next.next;	
    	}
    	return helperHead.next;
    }
    
   
}
