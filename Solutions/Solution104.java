/**
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author huangxin
 *
 */
public class Solution104 {
	/*
	 * Solution1: 
	 * 暴力解法，求取所有可能的子序列，并判断是否回文
	 * 时间复杂度： O(n^3)
	 * 
	 * LeetCode Submission: Time Limit Exceed
	 */
	public String longestPalindrome1(String s) {
		if (s == null) return null;
		
		int maxLength = 1;
		String longestPalidrome = null;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				int len = j - i + 1;
				String cur = s.substring(i, j + 1);
				if (isPalindrome(cur)) {
					if (len > maxLength) {
						maxLength = len;
						longestPalidrome = cur;
					}
				}
			}	
		}
		
		return longestPalidrome;
    }
	
	private boolean isPalindrome(String str) {
		int l = 0;
		int r = str.length() - 1;
		while (l < r) {
			if (str.charAt(l) != str.charAt(l)) {
				return false;
			}
			r--;
			l++;
		}
		return true;
	}
	
	/*
	 * Solution2:
	 * 动态规划。
	 * Define D[i,j] = 1 if substring beginning from index i and ending at index j is palindrome
	 * 
	 * Start Condition:
	 * 注意这里有两步初始化，因为要区分子字符串的字符个数的奇偶
	 * D[i,i] = 1;
	 * D[i,i + 1] = 1, if s.charAt(i) == s.charAt(i + 1)
	 * 
	 * Changing condition 
	 * D[i, j] = 1, if D[i + 1, j - 1] == 1 && s.charAt(i) == s.charAt(j)
	 * 
	 * 时间复杂度：
	 * O(n ^ 2)
	 * 空间复杂度：
	 * O(n ^ 2)
	 * 
	 */
	public static String longestPalindorme2(String s) {
		if (s == null || s.length() <= 1) return null;
		
		int maxLength = 1;
		String longestString = null;
		
		int len = s.length();
		
		// define table for dynamic programming 
		int[][] d = new int[len][len];
		
		// initialize table
		for (int i = 0; i < len; i++) {
			d[i][i] = 1;
		}
		for (int i = 0; i <= len - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				d[i][i + 1] = 1;
			}
		}
		
		// change condition 
		for (int i = len - 3; i >= 0; i--) {
			for (int j = i + 2; j <= len - 1; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					d[i][j] = d[i + 1][j - 1];
					int curLen = j - i + 1;
					if (d[i][j] == 1 && curLen > maxLength) {
						maxLength = curLen;
						longestString = s.substring(i, j + 1);
					}
				} else {
					d[i][j] = 0;
				}
			}
		}	
		// printTable(d);
		return longestString;
	}
		
	public static void printTable(int[][] x){
		for(int [] y : x){
			for(int z: y){
				System.out.print(z + " ");
			}
			System.out.println();
		}
		System.out.println("------");
	}
	
	public static void main(String[] args) {
		String test = "dabcba";
		longestPalindorme2(test);
	}
	
}
