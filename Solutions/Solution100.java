/**
 * Anagrams
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author huangxin
 *
 */

import java.util.*;

public class Solution100 {
	/**
	 * 回文构词法： 单词里的字母种类与数目相同，只是改变了字母的排序顺序
	 * 因此只要将几个单词按照字母顺序排序，就可以比较判断他们是否anagrams
	 * 
	 * step:
	 * 1) select a string from given array, and sort this string in an alphabetical order
	 * 2) check it hash map contains it.
	 * 3) If not, add <string, index> into map
	 * 4）If yes, add previous string into result set, and set the value to be -1 to prevent 
	 * add duplicates into result set. Then add current string into result set.
	 * 5) continues above steps until we have traversed all elements in given array
	 * 
	 * Time Complexity：
	 * O(n * nlog)
	 * 
	 * @param strs
	 * @return
	 */
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // Main Loop
        for (int i = 0; i < strs.length; i++) {
        	char[] currentArray = strs[i].toCharArray();
        	Arrays.sort(currentArray);
        	String currentStr = new String(currentArray);
        	// check if it is already in hash map
        	if (!map.containsKey(currentStr)) {
        		map.put(currentStr, i);
        	} else {
        		if (map.get(currentStr) >= 0) {
        			// put previous one into result
        			result.add(strs[map.get(currentStr)]);
        			map.put(currentStr, -1);
        		}
        		result.add(strs[i]);
        	}
        }
        return result;
    }
}
