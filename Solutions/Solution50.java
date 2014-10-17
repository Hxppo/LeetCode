
/**
 * Spiral Matrix II 
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @author huangxin
 *
 */
public class Solution50 {
	/*
	 * 解题思路：对上下左右各设一个bound，按顺序赋值
	 */
	public int[][] generateMatrix(int n) {
		int [][] res = new int[n][n];
        if (n == 0) {
        	return  res;
        }
        //define four bounds
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int value = 1;
        while (top < bottom && left < right) {
        	//top row
        	for (int i = left; i < right; i++) {
        		res[top][i] = value;
        		value++;
        	}
        	//right column 
        	for (int i = top; i < bottom; i++) {
        		res[i][right] = value;
        		value++;
        	}
        	//bottom row
        	for (int i = right; i > left; i--) {
        		res[bottom][i] = value;
        		value++;
        	}
        	//left column
        	for (int i = bottom; i > top; i--) {
        		res[i][left] = value;
        		value++;
        	}
        	top++;
        	bottom--;
        	left++;
        	right--;
        }
        
        if (n % 2 == 1) {
        	res[n / 2][n / 2] = value;
        }	
        return res;   
    }
}
