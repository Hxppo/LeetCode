/**
 * Merge k Sorted Lists 
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author huangxin
 *
 */

import java.util.*;
import LinkedList.ListNode;

public class Solution88 {
	/*/
	 * 注意时间复杂度的计算:O(klogk)
	 * 同mergesort，应该按数的方式计算时间
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		int end = lists.size() - 1;
		
		while (end > 0) {
			int cur = 0;
			while (cur < end) {
				lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(end--)));
			}
		}
		return lists.get(0);
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if (list1 == null && list2 == null) {
    		return null;
    	}
    	if (list1 == null && list2 != null) {
    		return list2;
    	}
    	if (list1 != null && list2 == null) {
    		return list1;
    	}
        
        ListNode head;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        
        if (list1.val <= list2.val) {
        	head = new ListNode(list1.val);
        	pointer1 = pointer1.next;
        } else {
        	head  = new ListNode(list2.val);
        	pointer2 = pointer2.next;
        }
        
        ListNode pointer = head;
        
        // Main loop 
        while (pointer1 != null && pointer2 != null) {
        	if (pointer1.val <= pointer2.val) {
        		pointer.next = new ListNode(pointer1.val);
        		pointer1 = pointer1.next;
        	} else {
        		pointer.next = new ListNode(pointer2.val);
        		pointer2 = pointer2.next;
        	}
        	pointer = pointer.next;
        }
        
        // check if there is any list unfinished
    	while (pointer1 != null) {
    		pointer.next = new ListNode(pointer1.val);
    		pointer1 = pointer1.next;
    		pointer = pointer.next;
    	}
    	
    	while (pointer2 != null) {
    		pointer.next = new ListNode(pointer2.val);
    		pointer2 = pointer2.next;
    		pointer = pointer.next;
    	}

        return head;
    }
}
