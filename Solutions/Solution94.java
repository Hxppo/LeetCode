/**
 * Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 */

import LinkedList.ListNode;

public class Solution94 {
	/*
	 * Solution: 
	 * 首先从head开始跑，直到最后一个节点，这时可以得出链表长度len。
	 * 然后将尾指针指向头指针，将整个圈连起来，接着往前跑len – k%len，从这里断开，就是要求的结果了。
	 * 
	 * Time Complexity: O(n)
	 */
	public ListNode rotateRight(ListNode head, int n) {
        int length = 0;
        ListNode pointer = head;
        while (pointer.next != null) {
        	length++;
        	pointer = pointer.next;
        }
        // connect the tail to the head and construct a circle
        pointer.next = head;
        // recalculate k to avoid n is larger than length
        int k = length - n % length;
        for (int i = 0; i < k; i++) {
        	pointer = pointer.next;
        }
        
        head = pointer.next;
        pointer.next = null;
        return head;
    }
	
	public static void main(String[] args) {
		//System.out.println(0 % )
	}
}
