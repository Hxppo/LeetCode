/**
 * Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * @author huangxin
 *
 */
import java.util.*;

public class Solution82 {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	boolean[] isVisited = new boolean[num.length];
    	Arrays.sort(num);
    	permuteUnique_helper(num, isVisited, res, list);
    	return res;
    }
    
    private static void permuteUnique_helper(int[] num, boolean isVisited[],
    		ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
    	if (list.size() == num.length) {
    		res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	
    	for (int i = 0; i < num.length; i++) {
    		if (!isVisited[i]) {
    			isVisited[i] = true;
    			list.add(num[i]);
    			permuteUnique_helper(num, isVisited, res, list);
    			list.remove(list.size() - 1);
    			isVisited[i] = false;
        		// skip duplicates
        		//while (i + 1 < num.length && num[i + 1] == num[i]) {
    			while (i > 0 && i < num.length && num[i] == num[i -1]) {
        			i++;
        		}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[] test = {1, 1};
    	System.out.println(permuteUnique(test));
    }
}
