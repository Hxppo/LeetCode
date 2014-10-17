import LinkedList.ListNode;
/**
 * Remove Duplicates from Sorted List
 * 
 * @author huangxin
 *
 */
public class Solution19 {
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
        ListNode newHead = new ListNode(head.val);
        ListNode tail = newHead;
        ListNode pointerSource = head.next;
        while(pointerSource != null) {
        	if (tail.val < pointerSource.val) {
        		ListNode node = new ListNode(pointerSource.val);
        		tail.next = node;
        		tail = tail.next;
        	}
        	pointerSource = pointerSource.next;
        }
        return newHead;
    }
    
    
}
