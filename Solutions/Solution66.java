import java.util.*;
/**
 * Subsets 
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * @author huangxin
 *
 */
public class Solution66 {
	/*
	 * 解题思路：
	 * 
	 * 利用典型的DFS算法构建特定长度K的组合，题目要求就是求得所有长度
	 * 可能的Combination结果。
	 * 
	 * 注意区分：此解法的递归实在第一遍向下分解子问题的时候完成计算，
	 * 当递归到底的时候完成结算结果 
	 * 
	 */
	
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        //Add the empty set into the results
        res.add(new ArrayList<Integer>());  
        //为了生成升序排序，因此开始时需要对数组排序
        Arrays.sort(S);
        subsetsHelper(res, list, S, 0);
        return res;
    }
    
    private static void subsetsHelper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list,
    			int[] S, int pos) {
    	for(int i = pos; i <= S.length - 1; i++) {
    		list.add(S[i]);
    		results.add(new ArrayList<Integer>(list));
    		subsetsHelper(results, list, S, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
        
    private ArrayList<ArrayList<Integer>> subsetsHelper_better(int[] S,   
    	     int cur, ArrayList<ArrayList<Integer>> results) {  
    	   // reach end of set -> add [] as a subset  
    	   if (cur >= S.length) {  
    	     results.add(new ArrayList<Integer>());  
    	     return results;  
    	   }  
    	   // generate subsets with remaining elements  
    	   results = subsetsHelper_better(S, cur+1, results);  
    	   // append the current one to all subsets made up with remaining elements  
    	   int curSize = results.size();  
    	   while (curSize-- > 0) {  
    	     ArrayList<Integer> res = new ArrayList<Integer>();  
    	     res.add(S[cur]);  
    	     res.addAll(results.get(curSize));  
    	     results.add(res);  
    	   }  
    	   return results;  
    	 }  
    	   
	 public ArrayList<ArrayList<Integer>> subsets_better(int[] S) {  
	   // sort the given set  
	   Arrays.sort(S);  
	   // generate subsets  
	   return subsetsHelper_better(S, 0, new ArrayList<ArrayList<Integer>>());  
	 } 
	 
	 public static void main(String[] args) {
		int[] test = {1, 2, 3};
		System.out.println(subsets(test));
		
	 }
}
