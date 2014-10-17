import java.util.*;

/**
 * Combinations 
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * @author huangxin
 *
 */
public class Solution55 {
	
    public static ArrayList<ArrayList<Integer>> combine2(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	if (k > n) {
    		return res;
    	} else {
    		combine_helper2(res, list, 1, n, k);
    		return res;
    	}
    }
    
    public static void combine_helper2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
    		int start, int n, int k) {
    	if (k == 0) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int i = start; i <= n; i++) {
    		list.add(i);
    		i++;
    		k--;
    		combine_helper2(res, list, i, n, k);
    		list.remove(list.size() - 1);
    		k++;
    		i--;
    	}
    }
    
    private void combine_helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> solution,
    		int start, int n, int k) {
    	if (solution.size() == k) {
    		res.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	
    	for (int i = start; i < n + 1; i++) {
    		solution.add(i);
    		combine_helper(res, solution, start + 1, n, k);
    		solution.remove(solution.size()- 1);
    	}
    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	if (k <= n) {
    		combine_helper(res, solution, 1, n, k);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> res = combine2(4, 2);
    	System.out.println(res);
    }
    
}
