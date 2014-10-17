/**
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s. 
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution117 {
	/*
	 * 递归求解, DFS
	 */
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
	
	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "aba";
		
		System.out.println(isPalindrome(s1, 0, s1.length() - 1));
		System.out.println(isPalindrome(s2, 0, s2.length() - 1));
		
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		res = partition("aab");
		for (ArrayList<String> list : res) {
			System.out.println(list);
		}
	}
}
