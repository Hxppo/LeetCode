import java.util.*;

@SuppressWarnings("unused")
/**
 * N-Queens II
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author huangxin
 *
 */

public class Solution58 {
	/*
	 * 解题思路： 位运算（见EverNote）
	 */
	public static int totalNQueens(int n) {
		int upper = (1 << n) - 1;
		return Queens(upper,0, 0, 0);
	}
	
	private static int Queens(int upper, int row, int ld, int rd ) {
		int solution = 0;
		if (row == upper) {
			solution = 1;
		} else {
			int position = upper & (~(row | ld | rd)); //valid position for current row 
			while (position != 0) {
				int p = position & (-position); //most right valid position for current row
				position -= p;
				solution += Queens(upper, row + p, (ld + p) << 1, (rd + p) >> 1);
			}
		}
		return solution;
	}
	
	
	
	
    public static int totalNQueens_slow(int n) {
    	if (n <= 0) {
    		return 0;
    	}
    	boolean isVisited[] = new boolean[n];
    	int[] input = new int[n];
    	for (int i = 0; i < n; i++) {
    		input[i] = i;
    	}
    	int[] res = {0};
    	int list = 0;
    	queensHelper(input, res, list, isVisited);
    	return res[0];
    }
    
    private static void queensHelper(int[] input, int[] res,
    		int list, boolean[] isVisited) {
    	if (list == input.length) {
    		res[0]++;
    		return;
    	}
    	
    	for (int i = 0; i < input.length; i++) {
    		if (!isVisited[i]) {
    			isVisited[i] = true;
    			if(i == 0) {
    				isVisited[1] = true;
    			} else if (i == input.length - 1) {
    				isVisited[input.length - 2] = true;
    			} else {
    				isVisited[i - 1] = true;
    				isVisited[i + 1] = true;
    			}	
    			list++;
    			queensHelper(input, res, list, isVisited);
    			list--;
    			isVisited[i] = false;
    			if(i == 0) {
    				isVisited[1] = false;
    			} else if (i == input.length - 1) {
    				isVisited[input.length - 2] = false;
    			} else {
    				isVisited[i - 1] = false;
    				isVisited[i + 1] = false;
    			}	
    		}
    	}
    }
   
    
    public static void main(String[] args) {
    	System.out.println(totalNQueens_slow(4));
    	System.out.println(totalNQueens(5));
    }
}
