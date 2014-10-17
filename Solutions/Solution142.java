/**
 * Candy
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * @author huangxin
 *
 */
public class Solution142 {
	/**
	 * 算法思路：
	 * 1. 从左往右算一遍，ratings递增时candy也递增，否则只给一块糖(保证了当前糖的个数不会低于左侧糖的个数）
	 * 2. 从右往左扫描一遍，如果座比右ratings高但却没有拿到更多的糖，则修正。(保证了当前糖的个数不会低于右侧糖的个数)
	 * Time Complexity: O(n) 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0; 	// corner case
        // define table to store candy 
        int[] candy = new int[n];
        candy[0] = 1; 	// initialize table
        for (int i = 1; i < n; i++) {
        	if (ratings[i] > ratings[i - 1]) {
        		candy[i] = candy[i - 1] + 1;
        	} else if (ratings[i] == ratings[i -1]) {
        		candy[i] = candy[i - 1];
        	} else {
        		candy[i] = 1;
        	}
        }
        // scan ratings in reversed order
        for (int i = n - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
        		candy[i] = candy[i + 1] + 1;
        	}
        }
        // calculate sum
        int sum = 0;
        for (int val : candy) {
        	sum += val;
        }
        
        return sum;
    }
}
