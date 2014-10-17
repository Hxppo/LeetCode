
/**
 * Set Matrix Zeroes 
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * @author huangxin
 *
 */

public class Solution43 {
	public void setZeroes(int[][] matrix) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		
		int[] row = new int[rowSize];
		int[] col = new int[colSize];
		
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		for (int i = 0; i < rowSize; i++) {
			if (row[i] == 1) {
				for (int j = 0; j < colSize; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int j = 0; j < colSize; j++) {
			if (col[j] == 1) {
				for (int i = 0; i < rowSize; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
