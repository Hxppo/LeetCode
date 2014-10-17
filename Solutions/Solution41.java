/**
 * Best Time to Buy and Sell Stock 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * @author huangxin
 *
 */
public class Solution41 {
    public int maxProfit(int[] prices) {
    	if(prices.length == 0 || prices.length == 1) {
    		return 0;
    	}
    	
    	int low = prices[0];
    	int result = 0;
    	
    	for (int i = 1; i < prices.length; i++){
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
}
