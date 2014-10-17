/**
 * Best Time to Buy and Sell Stock III
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * @author huangxin
 *
 */
public class Solution110 {
	/**
	 * Solution 1: 
	 * Time Complexity: O(n^2)
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit_1(int[] prices) {
		if (prices.length <= 1) return 0;
		
		int maxProfit = 0;
		for (int partition = 0; partition < prices.length; partition++) {
			int newProfit = maxProfit_helper(prices, 0, partition) + maxProfit_helper(prices, partition + 1, prices.length - 1);
			if (newProfit > maxProfit) {
				maxProfit = newProfit;
			}
		}
		
		return maxProfit;
	}
	
	
	 private int maxProfit_helper(int[] prices, int start, int end) {
	    	if(end - start < 1) {
	    		return 0;
	    	}
	    	
	    	int low = prices[start];
	    	int result = 0;
	    	
	    	for (int i = start + 1; i <= end; i++){
	    		if (prices[i] <= low) {
	    			low = prices[i];
	    		} else {
	    			int temp = prices[i] - low;
	    			if (temp > result) {
	    				result = temp;
	    			}
	    		}	
	    	}
	    	return result;
	}
	 
	 /**
	  * Solution 2: Dynamic Programming 
	  * Use two array storing maximum profit from prices[0, k] and prices[k, n]
	  * 
	  * @param prices
	  * @return
	  */
	 public static int maxProfit(int[] prices) {
		 if (prices == null || prices.length <= 1) return 0;
		 
		 // define array to store maxProfit from 0 - k
		 int min = prices[0];
		 int maxProfit = Integer.MIN_VALUE;
		 int[] left = new int[prices.length];
		 for (int i = 1; i < prices.length; i++) {
			 int temp = prices[i] - min;
			 if (temp > maxProfit) maxProfit = temp;
			 left[i] = maxProfit;
			 min = Math.min(min, prices[i]);
		 }
		 
		 // define array to store maxProfit from k - n
		 int max = prices[prices.length - 1];
		 maxProfit = Integer.MIN_VALUE;
		 int[] right = new int[prices.length];
		 for (int j = prices.length - 2; j >= 0; j--) {
			 int temp = max - prices[j];
			 if (temp > maxProfit) maxProfit = temp;
			 right[j] = maxProfit;
			 max = Math.max(max, prices[j]);
			 
		 }
		 
		 maxProfit = Integer.MIN_VALUE;
		 for (int partition = 0; partition < prices.length; partition++) {
			int newProfit = left[partition] + right[partition];
			if (newProfit > maxProfit) {
				maxProfit = newProfit;
			}
		 }
		 return maxProfit > 0 ? maxProfit : 0; 
	 }
	 
	 public static void main(String[] args) {
		 int[] test = {2,1,2,0,1};
		 System.out.println(maxProfit(test));
	 }
}
