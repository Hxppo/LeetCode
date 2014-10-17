/**
 * Word Ladder
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
 * such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution143 {
	/**
	 * Solution: BFS 
	 * 看见查找path、查找可能的路径，应该想到利用DFS & BFS。由于这里要求的是求得最短路径，因此选择BFS。
	 * 除了BFS所需要的一个Queue之外，这里我们还需要另外一个额外的Queue存储距离，也就是从源节点开始算起的层数
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Corner Case: dict is empty
    	if (dict.isEmpty()) return 0;
    	
    	// update dict & add end string into dict (treat it as the destination node
    	dict.add(end);
    	
    	// define queues for BFS
    	LinkedList<String> wordQueue = new LinkedList<String>();
    	LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
    	
    	wordQueue.add(start);
    	distanceQueue.add(1);
    	while (!wordQueue.isEmpty()) {
    		String curWord = wordQueue.pop();
    		int curDistance = distanceQueue.pop();
    		
    		// check if we have hit the destination 
    		if (curWord.equals(end)) {
    			return curDistance;
    		}
    		
    		// push adjacency string into wordQueue
    		for (int i = 0; i < curWord.length(); i++) {
    			char[] curCharArray = curWord.toCharArray();
    			for (char digit = 'a'; digit <= 'z'; digit++) {
    				curCharArray[i] = digit;
    				String newWord = new String(curCharArray);
    				// if dict contains it, then it is valid 
    				if (dict.contains(newWord)) {
    					wordQueue.add(newWord);
    					distanceQueue.add(curDistance + 1);
    					dict.remove(newWord);
    				}
    			}
    		}
    	}
    	
    	return 0;
    	
    }
    
    
}
