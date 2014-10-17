/**
 * Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author huangxin
 *
 */
public class Solution31 {
	
	/*
	 * 能够获得的最大利润就是整个数组的逆序元素对数
	 * 从头到尾遍历一遍数组
	 * 时间复杂度O(n^2)
	 * 
	 * Scan from left to right. And keep track the minimal price in left. 
	 * So, each step, only calculate the difference between current price and minimal price.
     * If this diff large than the current max difference, replace it.
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null) {
			return 0;
		}
		
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] test = {1,2,2,3};
		System.out.println(maxProfit(test));
	}
}
