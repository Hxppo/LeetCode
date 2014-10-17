/**
 * Edit Distance 
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author huangxin
 *
 */
public class Solution106 {
	/*
	 * Solution: Dynamic Programming 
	 * Define d[i,j] =  minimum price of converting a1-ai to b1-bj 
	 */
	public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] d = new int[len1 + 1][len2 + 1];
        // Initialize
        for (int i = 0; i <= len1; i++) {
        	// we can only delete the char
        	d[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
        	// we can only insert the char
        	d[0][j] = j;
        }
        
        // change conditions
        for (int i = 1; i <= len1; i++) {
        	for (int j = 1; j <= len2; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			//  we keep this char
        			d[i][j] = d[i - 1][j - 1];
        		} else {
        			int temp = Math.min(d[i][j - 1] + 1, d[i - 1][j] + 1);
        			d[i][j] = Math.min(temp, d[i - 1][j - 1] + 1);
        		}
        	}
        }
        
        return d[len1][len2];
    }
}
