/**
 * Word Break II 
 * 
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * @author huangxin
 *
 */

import java.util.*;

public class Solution109 {
	/**
	 * 递归解法：这里剪枝是难点
	 * 添加possible数组，用于记录区间拆分的可能性
	 * define possible[i] = true, if [i, n] has a solution
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	public static List<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> buffer = new ArrayList<String>();
        boolean[] possible = new boolean[s.length() + 1];
        for (int i = 0; i < possible.length; i++) {
        	possible[i] = true;
        }
        
        if (dict.isEmpty()) {
        	return result;
        }
        
        wordBreak_helper(s, dict, buffer, result, possible, 0);
        
        return result;
    }
	
	private static void wordBreak_helper(String s, Set<String> dict, ArrayList<String> buffer, ArrayList<String> result, boolean[] possible, int start) {
		if (start == s.length()) {
			createResult(buffer, result);
			return;
		}
    	for (int i = start; i < s.length(); i++) {
    		  if (dict.contains(s.substring(start, i + 1)) && possible[i + 1]){
				  buffer.add(s.substring(start, i + 1));
				  int beforeChange = result.size();
				  // traverse the next level
    			  wordBreak_helper(s, dict, buffer, result, possible, i + 1);
    			  if (result.size() == beforeChange) {
    				  possible[i + 1] = false;
    			  }
    			  // clear 
    			  buffer.remove(buffer.size() - 1);
    		  }
    	}
    }
	
	private static void createResult(ArrayList<String> buffer, ArrayList<String> result) {
		StringBuffer temp = new StringBuffer();
		
		for (int i = 0; i < buffer.size(); i++) {
			temp.append(buffer.get(i));
			if (i != buffer.size() - 1) {
				temp.append(" ");
			}
		}
		
		result.add(temp.toString());
	}
	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		List<String> result = wordBreak(s, dict);
		
		for (String x : result) {
			System.out.println(x);
		}
		
		
	}
}












