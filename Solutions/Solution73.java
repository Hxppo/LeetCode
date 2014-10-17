import java.util.Arrays;

/**
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * @author huangxin
 *
 */
public class Solution73 {
	/*
	 * 3Sum & 3Sum Closest Problems
	 */
    public static int threeSumClosest(int[] num, int target) {
    	int min = Integer.MAX_VALUE;
    	int result = 0;
    	Arrays.sort(num); //Time complexity: O(nlogn)
    	
    	for (int i = 0; i < num.length; i++) {
    		int j = i + 1;
    		int k = num.length - 1;
    		while (j < k) {
    			int sum = num[i] + num[j] + num[k];
    			int diff = Math.abs(target - sum);
    			if (diff < min) {
    				min = diff;
    				result = sum;
    			}
    			//update two pointers
    			if (sum <= target) {
    				j++;
    			} else {
    				k--;
    			}	
	        }	
	    }
    	return result;
    }
    

    
    
    public static void main(String[] args) {
    	int[] s = {-1, 2, 1, -4};
    	System.out.println(threeSumClosest(s, 1));
    }
}
