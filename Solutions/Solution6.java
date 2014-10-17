import LinkedList.ListNode;

/**
 * Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution6 {
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		ListNode fastNode = head;
		ListNode slowNode = head;
		
		// 注意边界条件: 比较到能比较到的最后一个为止
		// fastNode == null 正好比较到链表的倒数第二个个元素，并完成了比较
		// fastNode.next == null 上一次的比较已经走到哦链表的最后一个元素，并完成了比较
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if(slowNode == fastNode) {
				return true;
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		System.out.println(hasCycle(head));
	}
	
}
