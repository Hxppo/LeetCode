/**
 * Jump GameII
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * @author huangxin
 *
 */
public class Solution122 {
	/*
	 * Solution 1: DP 
	 * Time Complexity: O(n ^ 2)
	 */
	public static int jump_slow(int A[]) {
        if (A[0] == 0) return -1;
        
        int[] d = new int[A.length];
        d[0] = 0;
        for (int i = 1; i < A.length; i++) {
        	d[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < A.length; i++) {
        	for (int j = 1; j <= A[i] && i + j < A.length; j++) {
        		d[i + j] = Math.min(d[i + j], d[i] + 1);
        	}
        }
        
        return d[A.length - 1];
    }
	
	/*
	 * Solution 2: 
	 * Time Complexity: O(n)
	 * 
	 */
	
	public static int jump(int[] A) {
		int step = 0;
		int next = 0;
		int max = 0;
		
		for (int i = 0; i < A.length - 1 && next < A.length - 1; i++) {
			max = Math.max(max, A[i] + i);
			if (i == next) {
				if (max == next) return -1;
				next = max;
				step++;
			}
			
		}
		
		return step;
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,1,1,4};
		System.out.println(jump(a));
	}

}
