import java.util.*;

/**
 * Two Sum
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target
 * , where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @author huangxin
 *
 */

public class Solution2 {
    public int[] twoSum(int[] numbers, int targets) {
    	int[] result = new int[2];
    	Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    	
    	for (int i = 0; i < numbers.length; i++) {
    		Integer n = table.get(numbers[i]);
    		if (n == null) table.put(numbers[i], i);
    		n = table.get(targets - numbers[i]);
    		// to avoid choose the same elements two times
    		if (n != null && n < i) {
    			result[0] = n + 1;
    			result[1] = i + 1;
    			return result;
    		}
    	}
    	return result;
    }
    
    public int[] twoSum_1(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] test = {2, 7, 11, 15};
    	int[] answer = sol.twoSum(test, 9);
    	System.out.println(answer);
    }
}