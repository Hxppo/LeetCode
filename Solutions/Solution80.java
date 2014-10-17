import LinkedList.ListNode;
/**
 * Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author huangxin
 *
 */
public class Solution80 {
	public static ListNode deleteDuplicates(ListNode head) {
	    if(head == null)
	        return head;
	    ListNode helper = new ListNode(0);
	    helper.next = head;
	    ListNode pre = helper;
	    ListNode cur = head;
	    while(cur!=null)
	    {
	        while(cur.next!=null && pre.next.val==cur.next.val)
	        {
	            cur = cur.next;
	        }
	        if(pre.next==cur)
	        {
	            pre = pre.next;
	        }
	        else
	        {
	            pre.next = cur.next;
	        }
	        cur = cur.next;
	    }
	    
	    return helper.next;
	}
    
    public static void main(String args[]) {
    	ListNode n0 = new ListNode(1);
    	ListNode n1 = new ListNode(2);
    	ListNode n2 = new ListNode(3);
    	
    	n0.next = n1;
    	n1.next = n2;
    	
    	ListNode res = deleteDuplicates(n0);
    	
    	System.out.println(res);
    	
    }



}
