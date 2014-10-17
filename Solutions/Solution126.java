/**
 * Copy List with Random Pointer 
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 */
import LinkedList.RandomListNode;
import java.util.*;

public class Solution126 {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) return null;
    	
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode res = new RandomListNode(head.label);
    	map.put(head, res);
    	
    	RandomListNode pointer = head;
    	
    	while (pointer != null) {
    		RandomListNode curNode;
    		if (!map.containsKey(pointer)) {
    			curNode = new RandomListNode(pointer.label);
    		} else {
    			curNode = map.get(pointer);
    		}
    		
    		// update next pointer
    		if (pointer.next != null) {
    			if (!map.containsKey(pointer.next)) {
    				RandomListNode newNode = new RandomListNode(pointer.next.label);
    				map.put(pointer.next, newNode);
    				curNode.next = newNode;
    			} else {
    				curNode.next = map.get(pointer.next);
    			}
    		}
			
			// update random pointer
    		if (pointer.random != null) {
    			if (!map.containsKey(pointer.random)) {
    				RandomListNode newNode = new RandomListNode(pointer.random.label);
    				map.put(pointer.random, newNode);
    				curNode.random = newNode;
    			} else {
    				curNode.random = map.get(pointer.random);
    			}
    		}

    		// update pointer
			pointer = pointer.next;
    	}
    	
    	return res;
    }
}
