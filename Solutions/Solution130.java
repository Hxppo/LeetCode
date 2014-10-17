/**
 * 4Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution130 {
	// Solution 1: DFS求Combination的方法做
	// 递归时间负责度太高，无法通过LeetCode的大数组测试
	public static ArrayList<ArrayList<Integer>> fourSum_recursive(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4) return res;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		
		sumHelper(num, target, res, list, 0, 0);
		
		return  res;
    }
	
	private static void sumHelper(int[] num, int target, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int index, int sum) {
		// base condition
		if (sum > target || list.size() > 4) return;
		if (list.size() == 4) {
			if (sum == target) {
				res.add(new ArrayList<Integer>(list));
			} else {
				return;
			}
		}
		
		for (int i = index; i < num.length; i++) {
			sum += num[i];
			list.add(num[i]);
			sumHelper(num, target, res, list, i + 1, sum);
			sum -= num[i];
			list.remove(list.size() - 1);
			// skip duplicates
			while (i < num.length - 1 && num[i + 1] == num[i]) i++;
		}
		
	}
	
	// Solution2: Four pointers
	// The same way of solving 3Sum problem
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4) return resSet;
		
		Arrays.sort(num);
		
		// Four pointers
		for (int i = 0; i < num.length - 3; i++) {
			// skip duplicates
			if (i > 0 && num[i] == num[i - 1]) continue;
			for (int j = i + 1; j < num.length - 2; j++) {
				if (j > i + 1 && num[j] == num[j - 1]) continue;
				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						ArrayList<Integer> list = new ArrayList<Integer>(4);
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[left]);
						list.add(num[right]);
						resSet.add(list);
						
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) left++;
						while (left < right && num[right] == num[right + 1]) right--;
					}
				}
			}
		}
		
		return resSet;
	}
	
	
	public static void main(String[] args) {
		int[] S = {1, 0, -1, 0, -2, 2};
		ArrayList<ArrayList<Integer>> res = fourSum(S, 0);
		
		for (ArrayList<Integer> list : res) {
			System.out.println(list);
		}
		/*
		int[] num = {1, 1, 1, 2, 2, 2};
		int left = 1; 
		int right = num.length - 1;
		//do {left++;} while (left < right && num[left] == num[left - 1]);  
		while (left < right && num[left] == num[left - 1]) left++;
		System.out.println(left);
		//do {right--;} while (left < right && num[right] == num[right + 1]); 
		while (left < right && num[right] == num[right + 1]) right--;
		System.out.println(right);
		*/
		
	}
	
}
