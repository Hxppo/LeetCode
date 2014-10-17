/**
 * Word Break
 * 
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * @author huangxin
 *
 */

import java.util.*;

public class Solution108 {
	
	/*
	 * Recursive Solution: Time Limitation Exceed 
	 */
    public static boolean wordBreak_1(String s, Set<String> dict) {
    	if (s == null) return false;
    	if (dict.isEmpty()) return false;
    	
    	for (int i=0; i<s.length(); ++i) {
    		  if (dict.contains(s.substring(0, i+1)) && wordBreak(s.substring(i+1), dict)){
    		    return true;
    		  }
    	}
        return false;
    }
    
    /*
     * Dynamic Programming:
     * Turn recursive computation into a table to store
     * 
     * Define seg[i][j] = true, iff substring(i, j + 1) can be segmented into words from dict
     * which equals to:
     * seg[i][j] is a word in the given dictionary
	 * or seg[i][k] and seg[k+1][j] can both be segmented, where i<k<j
     * 
     */
    public static boolean wordBreak(String s, Set<String> dict){
    	// base condition 
    	if (s == null) return false;
    	if (dict.isEmpty()) return false;
    	
    	// define table 
    	boolean[][] seg = new boolean[s.length()][s.length()];
    	
    	// initialize table and compute table
    	for (int i = s.length() - 1; i >= 0; i--) {
    		for (int j = i; j < s.length(); j++) {
    			String cur = s.substring(i, j + 1);
				if (dict.contains(cur)) {
    				seg[i][j] = true;
    			} else {
    				for (int k = i; k < j; k++) {
    					if (seg[i][k] && seg[k + 1][j]){
    						seg[i][j] = true;
    					}
    						
    				}
    			}
    		}
    	}
    	
    	
    	return seg[0][s.length() - 1];
    }
    
    
    public static void main(String[] args) {
    	String s = "dogs";
    	Set<String> dict = new HashSet<String>();
    	dict.add("dog");
    	dict.add("s");
    	dict.add("gs");
    	
    	System.out.print(wordBreak(s, dict));
    }
}

