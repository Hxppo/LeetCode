/**
 * Permutation Sequence
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * @author huangxin
 *
 */
public class Solution84 {
   	int currentLevel = 0;
   	/* Solution1: 
   	 * http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
   	 * Compute it in a mathmetic way
   	 */
   	public static String getPermutation(int n, int k) {
   		StringBuffer res = new StringBuffer(n);
   		// Define two parameter storing the input array and n!
   		int preCount = 1;
   		int[] nums = new int[n];
   		for (int i = 0; i < n; i++) {
   			nums[i] = i + 1;
   			preCount *= (i + 1);
   		}
   		// Notice to update the value of k
   		k--;
   		int index = 0;
   		for (int i = 0; i < n; i++) {
   			preCount = preCount / (n - i);
   			index = k / preCount;
   			k = k % preCount;
   			// append the chosen element into the result
   			res.append(nums[index]);
   			// shift the array to the left
   			for (int j = index; j < n - i - 1; j++) {
   				nums[j] = nums[j + 1];
   			}
   		}
   		return res.toString();
   	}
   	
   	
	/*
	 * Solution2: 
	 * Compute all the input unitl we hit the kth permutations
	 */
	private void getPermutation_helper(int n, int currentLevel, int k, StringBuffer buffer, boolean[] isVisited) {
		if (buffer.length() == n) {
			if (currentLevel < k) {
				currentLevel++;
			} else {
				return;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				buffer.append(i);
				isVisited[i] = true;
				getPermutation_helper(n, currentLevel, k, buffer, isVisited);
				buffer.deleteCharAt(buffer.length() - 1);
				isVisited[i] = false;
			}
		}
			
	}
	
	
    public String getPermutation2(int n, int k) {
        boolean[] isVisited = new boolean[n + 1];
        StringBuffer buffer = new StringBuffer();
        getPermutation_helper(n, currentLevel, k, buffer, isVisited);
        return buffer.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(getPermutation(3, 2));
    }
}
