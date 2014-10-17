/**
 * First Missing Positive
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * @author huangxin
 *
 */
import java.util.*;

public class Solution129 {
	// Simple Solution: use additional HashMap
    public int firstMissingPositive_bad(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int x : A) {
        	map.put(x,x);
        }
        
        for (int i = 1; ; i++) {
        	if (!map.containsKey(i)) return i;
        }
    }
    
    // Solution2: In place bucket sort
    // 主要思路是将所有的出现的正整数放在桶排序时应该出现的位置。
    public static int firstMissingPositive(int[] A) {
    	// reorder the elements 
    	for (int i = 0; i < A.length; i++) {
    		while (A[i] != i + 1) {
    			// this index has not been placed a right number
    			// this number is larger than the length of this array or a non-positive number, skip it
    			if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) break;
    			// Or, we continuously swap these two elements
    			int temp = A[i];
    			A[i]= A[A[i] - 1];
    			A[temp - 1] = temp; 
    		}
    	}
    	
    	// Scan through the array to find required index
    	int index = 0;
    	for (index = 0; index < A.length; index++) {
    		if (A[index] != index + 1) break;
    	}
    	
    	return index + 1;
    }
    
    public static void main(String[] args) {
    	//int[] a = {3, 4, -1, 1};
    	int[] b = {1, 1};
    	System.out.println(firstMissingPositive(b));
    }
}
