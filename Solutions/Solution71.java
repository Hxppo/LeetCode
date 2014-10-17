/**
 * Unique Paths II 
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * @author huangxin
 *
 */

public class Solution71 {
	/*
	 * 解题思路： 二位DP动态规划
	 */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int rowLength = obstacleGrid.length;
    	int colLength = obstacleGrid[0].length;
    	int[][] D = new int[rowLength][colLength]; //define table for DP
    	//initialize table
    	if(obstacleGrid[0][0] == 0) {
    		D[0][0] = 1;
    	} else {
    		return 0;
    	}
    	for(int i = 1; i < rowLength; i++) {
    		D[i][0] = (obstacleGrid[i][0] == 1 ? 0 : D[i - 1][0]);
    	}
    	for(int j = 1; j < colLength; j++) {
    		D[0][j] = (obstacleGrid[0][j] == 1 ? 0 : D[0][j - 1]);
    	}
    	
    	for(int i = 1; i < rowLength; i++) {
    		for (int j = 1; j < colLength; j++) {
    			if(obstacleGrid[i][j] == 1) {
    				D[i][j] = 0;
    			} else {
    				D[i][j] = D[i - 1][j] + D[i][j - 1];
    			}
    		}
    	}   	
    	return D[rowLength - 1][colLength - 1];
    }
    
    public static void main(String[] args) {
    	int[][] grid = new int[3][3];
    	grid[1][1] = 1;
    	System.out.print(uniquePathsWithObstacles(grid));
    }
}
