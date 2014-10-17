import java.util.*;

/**
 * Combination Sum
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * @author huangxin
 *
 */
public class Solution85 {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
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
    		getCombinationSum(candidates, target, sum, i, res, solution); // Notice we do not have to increment i as each number can been chosen infinite times
    		solution.remove(solution.size() - 1);
    		sum -= candidates[i];
    	}
    }
    
    
}
