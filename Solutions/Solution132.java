/**
 * Spiral Matrix I
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * @author huangxin
 *
 */
import java.util.*;

public class Solution132 {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // base condition
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;
        // define four boundaries
        int left  = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        
        while (left < right && up < down) {
        	//up side
        	for (int j = left; j < right; j++) {
        		res.add(matrix[up][j]);
        	}
        	// right side 
        	for (int i = up; i < down; i++) {
        		res.add(matrix[i][right]);
        	}
        	// down side 
        	for (int j = right; j > left; j--) {
        		res.add(matrix[down][j]);
        	}
        	// left side 
        	for (int i = down; i > up; i--) {
        		res.add(matrix[i][left]);
        	}
        	
        	up++;
        	down--;
        	left++;
        	right--;
        }
        

        
        if (left == right) {
        	for (int i = up; i <= down; i++) {
        		res.add(matrix[i][left]);
        	}
        } else if (up == down) {
        	for (int j = left; j <= right; j++) {
        		res.add(matrix[up][j]);
        	}
        }
              
        return res;
    }
	
	public static void main(String[] args) {
		int[][] d = {{1,2,3}, {4,5,6}, {7,8,9}};
		ArrayList<Integer> res = spiralOrder(d);
		System.out.println(res);
	}
}
