/**
 * Rotate Image 
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * @author huangxin
 *
 */

public class Solution48 {
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
        	return;
        }
        
        int n = matrix.length;
        int low = 0;
        int high = n - 1;
        while(low < high) {
        	for (int j = low; j < high; j++) {
        		//swap the elements 
        		int temp = matrix[n - 1 - j][low];
        		matrix[n - 1 - j][low] = matrix[n - 1 - low][n - 1 - j];
        		matrix[n - 1 - low][n - 1 - j] = matrix[j][high];
        		matrix[j][high] = matrix[low][j];
        		matrix[low][j] = temp;
        	}
        	low++;
        	high--;
        }
    }
    
    public static void main(String[] args) {
    	int[][] test = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
    	rotate(test);
    	System.out.println(test);
    }
}
