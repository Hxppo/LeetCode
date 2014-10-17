import java.util.*;

/**
 * Combination Sum II
 * 
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * @author huangxin
 *
 */

public class Solution86 {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(candidates);
        getCombinationSum(candidates, target, 0, 0, res, solution);
        return res;
    }
    
    private void getCombinationSum(int[] candidates, int target, int sum, int start,
    		ArrayList<ArrayList<Integer>> res, ArrayList<Integer> solution) {
    	if (sum == target) {
    		res.add(new ArrayList<Integer>(solution));
    		return;
    	} else if (sum > target) {
    	    return;
    	}
    	
    	for (int i = start; i < candidates.length; i++) {
    		solution.add(candidates[i]);
    		sum += candidates[i];
    		getCombinationSum(candidates, target, sum, i + 1, res, solution);
    		solution.remove(solution.size() - 1);
    		sum -= candidates[i];
    		// skip duplicates
    		while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
    		    i++;
    		}
    	}
    }
}
