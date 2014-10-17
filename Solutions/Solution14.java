import LinkedList.ListNode;

/**
 * Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 * @author huangxin
 *
 */
public class Solution14 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode result = new ListNode(head.val);
		ListNode pointerResult = new ListNode(head.val); // pointer for traverse the result list
		ListNode pointerSource = head.next;	// pointer for traverse the source list
		
		while (pointerSource != null) {
			// traverse the result to find the insertion position 
			pointerResult = result;
			while (pointerResult != null) {
				if (pointerSource.val <= pointerResult.val && pointerResult == result) {
					// insertion before the head
					ListNode node = new ListNode(pointerSource.val);
					node.next = pointerResult;
					result= node;
					break;
				} else if (pointerSource.val > pointerResult.val && pointerResult.next == null) {
					// 
					ListNode node = new ListNode(pointerSource.val);
					pointerResult.next = node;
					break;		
				} else if (pointerResult.val < pointerSource.val && pointerSource.val <= pointerResult.next.val) {
					// 
					ListNode node = new ListNode(pointerSource.val);
					node.next = pointerResult.next;
					pointerResult.next = node;
					//pointerSource = pointerSource.next;
					break;
				} else {
					pointerResult = pointerResult.next;
				}
			}
			pointerSource = pointerSource.next;
		}	
		return result;
	}
}
