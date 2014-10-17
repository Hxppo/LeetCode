/**
 * Interleaving String
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * 
 * @author huangxin
 *
 */
public class Solution141 {
	/**
	 * 二维动态规划求解，类似于LCS求解最长公共子序列的算法
	 * Define match[i, j] = true if first i chars from s1 and first j chars from s2 can match first (i+j+1) chars from s3
	 * 
	 * Match[i][j] = (s3.lastChar == s1.lastChar) && Match[i-1][j] ||(s3.lastChar == s2.lastChar) && Match[i][j-1]
     * 初始条件：
     * i=0 && j=0时，Match[0][0] = true;
     * i=0时， s3[j] = s2[j], Match[0][j] |= Match[0][j-1]
     * s3[j] != s2[j], Match[0][j] = false;
     * 
     * j=0时， s3[i] = s1[i], Match[i][0] |= Match[i-1][0]
     *     s3[i] != s1[i], Match[i][0] = false;
	 */
    public static boolean isInterleave(String s1, String s2, String s3) {
    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();
    	// corner case
    	if (len3 != len1 + len2) return false;
    	
    	// define and initialize table 
    	boolean[][] match = new boolean[len1 + 1][len2 + 1];
    	match[0][0] = true;
    	for (int i = 1; i <= len1; i++) {
    		if (s3.charAt(i - 1) == s1.charAt(i- 1)) {
    			match[i][0] |= match[i - 1][0];
    		}
    	}
    	for (int j = 1; j <= len2; j++) {
    		if (s3.charAt(j - 1) == s2.charAt(j - 1)) {
    			match[0][j] |= match[0][j - 1];
    		}
    	}
    	
    	// Base Cases
    	for (int i = 1; i <= len1; i++) {
    		for (int j = 1; j <= len2; j++) {
    			match[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && match[i - 1][j]) ||
    					(s3.charAt(i + j - 1) == s2.charAt(j - 1) && match[i][j - 1]);
    		}
    	}
    	
    	return match[len1][len2];
    }
    
    public static void main(String[] args) {
    	String s1 = "";
    	String s2 = "b";
    	String s3 = "b";
    	
    	System.out.print(isInterleave(s1, s2, s3));
    }
}
