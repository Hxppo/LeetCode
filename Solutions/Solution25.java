/**
 * Climbing Stairs 
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author huangxin
 */


public class Solution25 {
	/*
	 * 采用动态规划解题
	 * Define D[i] 到达第i层的方法
	 * D[i] = D[i - 1] + D[i - 2]
 	 */
    public int climbStairs(int n) {
        //base condition
    	if (n == 1) {
    		return 1;
    	}
    	if (n == 2) {
    		return 2;
    	}
    	//DP 
    	int[] D = new int[n];
    	D[0] = 1;
    	D[1] = 2;
    	for (int i = 2; i < n; i++) {
    		D[i] = D[i -1] + D[i- 2];
    	}
    	return D[n -1];
    }
}
