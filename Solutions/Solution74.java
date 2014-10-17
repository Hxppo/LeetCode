import java.util.*;
/**
 * 3Sum 
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * @author huangxin
 *
 */
public class Solution74 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	//check base condition
        if (num.length < 3) {
        	return res;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
        	//avoid duplicated solutions
        	if (i == 0 || num[i] > num[i - 1]) {
        		int target = -num[i];
        		int j = i + 1;
        		int k = num.length - 1;
        		while (j < k) {		
        			//case1
        			if (num[j] + num[k] == target) {
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[j]);
        				list.add(num[k]);
        				res.add(list);
        				j++;
        				k--;
        				//skip duplicates
        				while (j < k && num[j] == num[j - 1]) {
        					j++;
        				}
        				while (j < k && num[k] == num[k + 1]) {
        					k--;
        				}
        			} else if (num[j] + num[k] > target) {
        				k--;
        			} else {
        				j++;
        			}
        		}		
        	}
        } 
    	return res;
    }
}
