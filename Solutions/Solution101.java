/**
 * LRU Cache 
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * 
 * @author huangxin
 *
 */

/*
 * Solution:
 * Use linked list to get quick access to deletion and insertion. 
 * Use hash map for quick search
 * 
 * Method Implemented:
 * get(int key) & set(int key, int value)
 *	
 * Time Complexity for all operations: O(1)
 */
import java.util.*;

public class Solution101 {
	// inner class
	class Entry {
		int key;
		int value;
		
		Entry() {
			this.key = 0;
			this.value = 0;
		}
		Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	class DListNode {
    	DListNode prev;
    	DListNode next;
    	Entry entry = new Entry();
    	
    	DListNode() {
    		this.prev = null;
    		this.next = null;	
    	}
    	
    	DListNode(int key, int value) {
    		this.entry.key = key;
    		this.entry.value = value;
    	}
    }
	
	// use a double linked list to store real entry
	// use a dummyHead to guard the list
	private DListNode dummyHead;
	// use a hash map for quick search
	private Map<Integer, DListNode> map;
	private int capacity;
	private int limitation;
	
	public Solution101(int capacity) {
		this.dummyHead = new DListNode();
		dummyHead.next = dummyHead;
		dummyHead.prev = dummyHead;
		this.map = new HashMap<Integer, DListNode>();
		this.capacity = 0;
		this.limitation = capacity;
    }
	
	// implement operations for a double linked list 
	private void insertFront(DListNode node) {
		if (dummyHead.next == null) {
			dummyHead.next = node;
			dummyHead.prev = node;
			node.next = dummyHead;
			node.prev = dummyHead;
		} else {
			dummyHead.next.prev = node;
			node.next = dummyHead.next;
			dummyHead.next = node;
			node.prev = dummyHead;
		}
	}
	
	private void deleteBack() {
		if (dummyHead.prev != dummyHead) {
			dummyHead.prev.prev.next = dummyHead;
			dummyHead.prev = dummyHead.prev.prev;
		} 
	}
	
	private void delete(DListNode node) {
		if (dummyHead.prev == node) {
			deleteBack();
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
	}
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	DListNode node = map.get(key);
        	delete(node);
        	insertFront(node);
        	return node.entry.value;	
        } else {
        	return -1;
        }
    }
    
    
    
    /* 
     * 链表，每次插入均插入表头，链表尾总是保存least recently used block
     * 注意插入时先确认cache是否已满。
     * 
     * 1> Not in map, insert it into map and list
     * 		a> If cache is full, remove the tail of list and update map
     * 		b> inert the new entry at the head of list, update map again
     * 2> It has been in the map, update the value of this entry
     */
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		DListNode point = map.get(key);
    		// update node in list
    		point.entry.value = value;
    		delete(point);
    		insertFront(point);
    	} else if (capacity < limitation){
    		// add new node at the head of list and update map
    		DListNode newNode = new DListNode(key, value);
    		insertFront(newNode);
    		map.put(key, newNode);
    		capacity++;
    	} else {
    		// delete last node from list
    		// System.out.println(dummyHead.prev.value);
    		map.remove(dummyHead.prev.entry.key);
    		deleteBack();
    		DListNode newNode = new DListNode(key, value);
    		insertFront(newNode);
    		map.put(key, newNode);
    	}
    }
    
    public void print() {
    	DListNode cur = dummyHead.next;
    	while (cur != dummyHead){
    		System.out.print("(" + cur.entry.key + "," + cur.entry.value + ")->");
    		cur = cur.next;
    	}
    	System.out.println("NULL");
    }
    
    public static void main(String[] args) {
    	Solution101 cache = new Solution101(2);
    	/*
    	cache.set(1, 1);
    	cache.print();
    	cache.set(2, 2);
    	cache.print();
    	cache.set(3, 3);
    	cache.print();
    	cache.set(4, 4);
    	cache.print();
    	cache.get(4);
    	cache.print();
    	cache.get(3);
    	cache.get(2);
    	cache.print();
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(2));
    	*/
    	cache.set(2, 1);
    	cache.set(1, 1);
    	cache.print();
    	cache.get(2);
    	cache.print();
    	cache.set(4, 1);
    	cache.print();
    	cache.get(1);
    	cache.print();
    	cache.get(2);
    	cache.print();
    	
    }
    
    
    
}
