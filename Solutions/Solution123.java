/**
 * Distinct Subsequences 
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from 
 * the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * @author huangxin
 *
 */
public class Solution123 {
	public static int numDistinct(String S, String T) {
		// base conditions
		if (S.length() < T.length()) return 0;
		if (T.length() == 0) return 1;
		if (T == null || S == null) return 0;
		
		// define D(i, j) = true if we can form substring b0..bj from a0..ai
		int n = S.length();
		int m = T.length();
		int[][] D = new int[n + 1][m + 1];
		
		// initialization
		for (int j = 0; j <= m; j++) {
			D[0][j] = 0;
		}
		for (int i = 0; i <= n; i++) {
			D[i][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				D[i][j] += D[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					D[i][j] += D[i - 1][j - 1];
				}
			}
		}
		return D[n][m];
    }
	
	public static void main(String[] args) {
		
		String S = "rabbbiit";
		String T = "rabit";
		
		/*
		String S = "b";
		String T = "a";
		*/
		System.out.println(numDistinct(S, T));
	}
}
