/**
 * Maximal Rectangle
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
import java.util.*;


public class Solution98 {
	private static int maxRectangle(int[] histogram) {
		// Define stack 
		Stack<Integer> stack = new Stack<Integer>();
		int topIndex;
		int areaTop;
		int maxArea = Integer.MIN_VALUE;
		
		// Loop one: scan array from left to right.
		int i = 0;
		while (i < histogram.length) {
			if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
				// push the height in to the stack
				stack.push(i++);
			} else {
				// compute the maximum rect with peek of the stack as the bar 
				topIndex = stack.pop();
				areaTop = histogram[topIndex] * (stack.empty() ? i : i - stack.peek() - 1);
				// update the value
				maxArea = Math.max(maxArea, areaTop);
			}
		}
		
		// Loop two: compute the rect remains in the stack
		while (!stack.isEmpty()) {
			topIndex = stack.pop();
			areaTop = histogram[topIndex] * (stack.isEmpty() ? i : i - stack.peek() -1);
			maxArea = Math.max(maxArea, areaTop);
		}
		
		return maxArea;
	}  
	   
	public static int maximalRectangle(char[][] matrix) {
		int maxArea = 0;
		int rows = matrix.length;
		// corner case
		if (rows == 0) return 0;
		int cols = matrix[0].length;
		
		// Define table D[i,j]
		// D[i,j] = k when matrix[i,j] - matrix[i, j + k -1] are all '1'
		int[][] D = new int[rows][cols];
		// Initialize the table 
		for (int i = 0; i < cols; i++) {
			if (matrix[0][i] == '1') {
				D[0][i] = 1;
			}
		}
		// Compute length table
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == '0') {
					D[i][j] = 0;
				} else {
					D[i][j] = D[i - 1][j] + 1;
				}
			}
		}
		
		// For each row, we call maximalRectangle function to find max rect area
		for (int i = 0; i < rows; i++) {
			maxArea = Math.max(maxArea, maxRectangle(D[i]));
		}
		
		return maxArea;
	}
	
	/*
	 * Solution2: 动态规划
	 * DP用户计算从（i, j)、第i行，从第j开始的连续的1个数。
	 * 循环的方向：从上至下，从右向左
	 * Define D[i,j] = number of 1's begins at the position of (i,j)
	 * D[i, j] = (matrix[i, j] == '1' ? : D[i, j] + 1 : 0
	 * Time Complexity of DP: O(n^2)
	 * 
	 */
	
	public static int maximaRectangle_DP(char[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) return 0;
		int cols = matrix[0].length;
		
		// Define table for dynamic programming 
		int[][] dp = new int[rows][cols];
		// Initialize and compute all results
		for (int i = 0; i < rows; i++) {
			dp[i][cols - 1] = (matrix[i][cols - 1] == '1' ? 1 : 0);
		}
		for (int i = 0; i < rows; i++) {
			for (int j = cols - 2; j >= 0; j--) {
				dp[i][j] = (matrix[i][j] == '1' ? dp[i][j + 1] + 1 : 0);
			}
		}
		
		
		// 以每个点作为矩形的左上角计算所得的最大矩形面积
		int maxArea = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Prune 1: cols - j 是最大宽度， rows - i 是最大高度
				if ((cols - i) * (rows - i) < maxArea) break;
				int width = dp[i][j];
				for (int k = i; k < rows; k++) {
					// Prune 2: row - i是以点（1, j)为左上角的矩形的最大宽度
					if (width * (rows - i) <= maxArea) break;
					// 计算以(i,j)为左上角
					// 矩形宽度要取从第i行到第k行宽度的最小值
					if (width > dp[k][j]) width = dp[k][j];
					maxArea = Math.max(maxArea, width * (k - i + 1)); 
				}
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		char[][] test = {{'1', '0'}};
		System.out.print(maximalRectangle(test));
	}
}
