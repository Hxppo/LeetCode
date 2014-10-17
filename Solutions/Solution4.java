
/**
 * Single Number I
 * 
 * Given an array of integers, every element appears twice except for one
 * @author huangxin
 */

public class Solution4 {
	
	/** 没有考虑到integer的范围。当为负数时，不能作为数组的index*/
    public int singleNumber_1(int[] A) {
    	// check whether the array is empty or not
    	if (A.length == 0) {
    		return -1;
    	}
    	
        // find the maximum number of the array
    	int max = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] > max) {
        		max = A[i];
        	}
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
        	count[A[i]]++;
        }

        for (int i = 0; i < A.length; i++) {
        	if (count[i] == 2){
        		return A[i];
        	}
        }
        return -1;
    }	
    
    public static int singleNumber(int[] A) {
    	int res = 0;
    	for (int i = 0; i < A.length; i++) {
    		res = res ^ A[i];
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] test = {1, 1, 2, 3, 3};
    	//System.out.println(singleNumber(test));
    	System.out.println(singleNumber(test));
    }
}

