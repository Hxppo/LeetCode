/**
 * Reorder List
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * 
 * @author huangxin
 *
 */
import LinkedList.ListNode;

public class Solution136 {
	/*
	 * Solution1:
	 * Time Complexity: O(n)
	 * 
	 * 1> break list in the middle to two lists
	 * 2> reverse the order of second list
	 * 3> merge two list back together
	 */
	public static void reorderList(ListNode head) {
		if (head != null && head.next != null) {
			ListNode slow = head;
			ListNode fast = head;
			
			// use fast and slow pointers to break the link into two parts
			while (fast != null && fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			ListNode second = slow.next;
			slow.next = null;
			
			// reverse the second list
			second = reverseOrder(second);
			
			// merge two lists into one
			ListNode p1 = head;
			ListNode p2 = second;
			
			while (p2 != null) {
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;
				
				p1.next = p2;
				p2.next = temp1;
				
				p1 = temp1;
				p2 = temp2;
			}
			
		}
	}
	
	public static ListNode reverseOrder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
 
		ListNode pre = head;
		ListNode curr = head.next;
 
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
			
		}
		
		// set head node's next
		head.next = null;
 
		return pre;
		
	}
	
	/*
	 * 我自己的解法，利用递归。
	 * 时间复杂度O(n^2)
	 * LeetCode 大数据超时
	 */
	
	public static void reorderList_recursive(ListNode head) {
		// base condition
        if (head == null) return;
        if (head.next == null) return;
        
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		reoderHelper(dummy);
    }
	
	private static void reoderHelper(ListNode head) {
		// base condition
        if (head.next == null) return;
        if (head.next.next == null) return;
        
        ListNode newHead = reverse(head);
        reoderHelper(newHead);
	}
	
	private static ListNode reverse(ListNode head) {
		ListNode pre = head;
		ListNode cur = head.next;
		
		while (cur != null && cur.next != null) {
			cur = cur.next;
			pre = pre.next;
		}
		
		// remove cur(last node) from the list
		pre.next = null;
		
		pre = head.next;
		cur.next = pre.next;
		pre.next = cur;
		pre.next = cur;
		
		return cur;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		n1.next = n2;
		n2.next = n3;
		
		//reorderList(n1);
		ListNode pointer = reverseOrder(n1);
		while(pointer != null) {
			System.out.println(pointer.val);
			pointer = pointer.next;
		}
	}

}
