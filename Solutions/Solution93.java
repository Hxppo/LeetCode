/**
 * Minimum Window Substring 
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * @author huangxin
 *
 */

public class Solution93 {
	/*
	 * Solution: 
	 * Two Pointer Method
	 * 基本思路类似Longest Substring Without Repeating Characters
	 * 
	 * Use two pointers to maintain a dynamic interval or window.
	 * Tail continues scanning the input from left to right.
	 * When window contains all the characters of the substring, 
	 * we begin to shrink the window by moving the head pointer to the right until
	 * we cannot move it anymore.
	 * Store the minimum window among all the valid window
	 * 
	 * Time Complexity: O(n) 
	 * 
	 */
	public static String minWindow(String S, String T) {
		// case condition 
		if (S.equals("") || T.equals("")) return "";
		
        // store the input as an array
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		
		// Define two flag array 
		int[] appearCount = new int[256];
		int[] expectCount = new int[256];
		// initialize expectCount 
		for (int i = 0; i < t.length; i++) {
			// System.out.println(t[i]);
			expectCount[t[i]]++;
		}
		
		// Define the pointers for the window 
		int winStart = 0;
		int winEnd = 0;
		int minWindowStart = 0;
		int minWindowLength = Integer.MAX_VALUE;
		int curWindowLength = 0;
		
		// The winEnd begin to scan the array
		for(winEnd = 0; winEnd < s.length; winEnd++) {
			// check weather the character is part of the substring
			if (expectCount[s[winEnd]] > 0) {
				appearCount[s[winEnd]]++;
				if (appearCount[s[winEnd]] <= expectCount[s[winEnd]]) {
					curWindowLength++;
				}
			}
			
			// we can now try to shrink the size of the window
			if (curWindowLength == t.length) {
				while (appearCount[s[winStart]] > expectCount[s[winStart]]
						|| expectCount[s[winStart]] == 0) {
					appearCount[s[winStart]]--;
					winStart++;	// the length of current window is not changed
				}
				// check if we should update the length of the window
				if (minWindowLength > (winEnd - winStart + 1)) {
					minWindowLength = winEnd - winStart + 1;
					minWindowStart = winStart;
					
				}
			}	
		}
        
		return (minWindowLength == Integer.MAX_VALUE ? "" : S.substring(minWindowStart, minWindowStart + minWindowLength));
    }
	
	public static void main(String[] args) {
		String S = "ab";
		String T = "b";
		
		System.out.println(minWindow(S, T));
	}
}
