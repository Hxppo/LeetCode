/**
 * Substring with Concatenation of All Words
 * 
 * You are given a string, S, and a list of words, L, 
 * that are all of the same length. Find all starting indices of substring(s) in S 
 * that is a concatenation of each word in L exactly once and without any intervening characters.
 */

import java.util.*;

public class Solution95 {
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // Define length of word in string array
        int unitLength = L[0].length();
        int unitSize = L.length;
        
        // Case condition 
        if (S.length() < unitSize * unitLength) {
        	return res;
        }
        
        // Define a hashmap to store input string array
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < unitSize; i++) {
        	if (map.containsKey(L[i])) {
        		map.put(L[i], map.get(L[i]) + 1);
        	} else {
        		map.put(L[i], 1);
        	}
        	
        }
        
        //System.out.println("Main Loop");
        
        // Main Loop; Scan S until the length is too short to hold concatenation of L
        for (int i = 0; i <= S.length() - unitLength * unitSize; i++) {
        	// select a substring with unitlength from S
        	String current = S.substring(i, i + unitLength);
        	// check it is contained in L
        	if (map.containsKey(current)) {
        		// continue to check the following substring
        		Map<String, Integer> mapcopy = new HashMap<String, Integer>(map);
        		int visitedCount = 1;
        		mapcopy.put(current, mapcopy.get(current) - 1);
        		while (visitedCount < unitSize) {
        			String visiting = S.substring(i + visitedCount * unitLength, i + visitedCount * unitLength + unitLength);
        			if (!mapcopy.containsKey(visiting) || mapcopy.get(visiting) == 0) {
        				break;
        			} 
        			mapcopy.put(visiting, mapcopy.get(visiting) - 1);
        			visitedCount++;
        		}
        		if (visitedCount == unitSize) {
        			res.add(i);
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		String S = "aaa";
		String[] L = {"a", "b"};
		ArrayList<Integer> res = findSubstring(S, L);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	
}
