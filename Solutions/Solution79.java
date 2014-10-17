import java.util.Hashtable;
/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author huangxin
 *
 */
public class Solution79 {
	/*
	 * 时间复杂度：O(n^2)
	 */
	public int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
    
        for (int i = 0; i < s.length(); i++) {
        	Hashtable<Character, Character> table = new Hashtable<Character, Character>();
        	table.put(s.charAt(i), s.charAt(i));
        	int length = 1;
        	for (int j = i + 1; j < s.length(); j++) {
        		if (table.containsKey(s.charAt(j))) {
        			break;
        		} else {
        			table.put(s.charAt(j), s.charAt(j));
        			length++;
        			maxLength = Math.max(maxLength, length);
        		}
        	}
        }  
		return maxLength;
    }
	/*
	 * 时间复杂度：O(n)
	 * Solution: 
	 */
	public int lengthOfLongestSubstring_faster(String s) {
		boolean[] flag = new boolean[256];
	 
		int result = 0;
		int j = 0;
		char[] arr = s.toCharArray();
	 
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (flag[c]) {
				result = Math.max(result, i - j);
				for (int k = j; k < i; k++) {
					if (arr[k] == c) {
						j = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}	
			} else {
				flag[c] = true;
			}
		}
	 
		result=Math.max(arr.length-j,result);
	 
		return result;
	}
}
