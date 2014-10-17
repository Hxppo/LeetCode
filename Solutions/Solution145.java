/**
 * Palindrome Partitioning II
 * 
 *  
 * @author huangxin
 *
 */

import java.util.ArrayList;

public class Solution145 {
	public static ArrayList<ArrayList<String>> partition(String s) {
        if (s == null) return null;
        if (s.length() == 0) {
        	ArrayList<String> list = new ArrayList<String>();
        	list.add("");
        	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        	res.add(list);
        	return res;
        }
        
        return subPartition(s, 0, s.length() - 1);
    }
	
	private static ArrayList<ArrayList<String>> subPartition(String s, int start, int end) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start > end) {
			result.add(new ArrayList<String>());
			return result;
		}
		
		// DFS and recursive call
		for (int i = start; i <= end; i++) {
			if (isPalindrome(s, start, i)) {
				// we can compute next level or we skip this substring
				ArrayList<ArrayList<String>> resNext = subPartition(s, i + 1, end);
				for (ArrayList<String> list : resNext) {
					list.add(0, s.substring(start, i + 1));
					//list.add(s.substring(start, i + 1));
					result.add(list);
				}
			}
		}
		
		return result;
	}
	
	private static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	/**
	 * 解法1： 直接利用DFS求得所有符合要求的结果，从结果中找到最小切割数
	 * @param s
	 * @return
	 */
    public static int minCut_recursive(String s) {
        ArrayList<ArrayList<String>> res = partition(s);
        int minCut = Integer.MAX_VALUE;
        for (ArrayList<String> list : res) {
        	minCut = Math.min(minCut, list.size() - 1);
        }
        
        return minCut;
    }
    
    
}
