/**
 * Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author huangxin
 *
 */
public class Solution69 {
	/*
	 * 解法一：一维动态规划
	 * 时间复杂度：O(n^2)
	 * 空间负责度：O(n^2)
	 * 
	 * 定义boolean[] res = TRUE，如果能够调到第i个index
	 * 计算完res数组，从头到尾扫描检查是否均为TRUE
	 * 
	 * LeetCode 超时
	 */
	
    public static boolean canJump_slow(int[] A) {
        boolean[] res = new boolean[A.length];
    
        if(A[0] == 0) {
        	return false;
        } else {
        	for(int i = 0; i < A.length; i++) {
	        	for(int j = A[i]; j > 0; j--) {
	        		if(i + j < A.length){
	        			res[i + j] = true;
	        		}
	         	}
	        }
        }
        
        for(int i = 1; i < A.length; i++) {
        	if(res[i] == false) {
        		return false;
        	}
        }
    	return true;
    }
    
    /*
     * 解法二：
     * 时间复杂度: O(n)
     * 空间负责度：O(n)
     * 
     * 一维DP动态规划，定义：
     * jump[i] = 从index为0走到当前第i步时，剩余的最大步数
     * 
     */
    public static boolean canJump_better(int[] A) {
    	//Array for one-dimension DP 
    	int[] jump = new int[A.length];
    	//initialize the jump
    	jump[0] = 0;
    	for(int i = 1; i < A.length; i++) {
    		jump[i] = Math.max(jump[i - 1], A[i - 1]) - 1;
    		if(jump[i] < 0) {
    			return false;
    		}
    	}
    	return jump[A.length - 1] >= 0;
    }
    
    /*
     * 解法三：
     * 时间复杂度: O(n)
     * 空间负责度：O(1)
     * 
     * 对于一维的DP，此题没有必要记录整个jump[i] 
     * 定义一个maxCover为从当前位置所能够覆盖到的最大位置
     * 
     */
    public static boolean canJump(int[] A) {
    	int maxCover = 0;
    	for (int pos = 0; pos < A.length && pos <= maxCover; pos++) {
    		if(A[pos] + pos > maxCover) {
    			maxCover = A[pos] + pos;
    		}
    		if(A[pos] + pos >= A.length - 1) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	int[] test = {2, 3, 1, 1, 4};
    	int[] test2 = {3,2,1,0,4};
    	System.out.println(canJump_slow(test));
    	System.out.println(canJump_better(test2));
    }
}
