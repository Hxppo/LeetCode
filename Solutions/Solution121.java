/**
 * Gas Station
 * 
 * @author huangxin
 *
 */
public class Solution121 {
	/*
	 * Solution1: 暴力算法
	 * 时间负责度: O(n^2)
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
        int[] delta = new int[gas.length];
        
        for (int i = 0; i < n; i++) {
        	delta[i] = gas[i] - cost[i];
        }
		
        int leftGas = 0;
        int sum = 0;
        int startNode = 0;
        
        for (int i = 0; i < n; i++) {
        	leftGas += delta[i];
        	sum += delta[i];
        	if (sum < 0) {
        		startNode = i + 1;
        		sum = 0;
        	}
        }
		
        return (leftGas < 0) ? -1 : startNode; 
    }
	
}
