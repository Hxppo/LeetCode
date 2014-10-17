import java.util.*;
/**
 * Subsets II
 * 
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * @author huangxin
 *
 */
public class Solution68 {
	/*
	 * 解题思路：
	 * 同样采用DFS的办法构造，但是需要注意去重复。
	 * “那么，我们需要做的是，在删去元素后，再取元素的时候，不要取和刚刚取过的元素相等的元素 即加上这么一条语句”
	 */
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		results.add(new ArrayList<Integer>());
		Arrays.sort(num);
		subsetsWithDup_Helper(results, list, num, 0);
        return results;
    }
	
	private static void subsetsWithDup_Helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list,
			int[] num, int pos) {
		
		for(int i = pos; i < num.length; i++) {
			list.add(num[i]);
			results.add(new ArrayList<Integer>(list));
			subsetsWithDup_Helper(results, list, num, i + 1);
			list.remove(list.size() - 1);
			//skip elements with duplicates
			while(i < num.length - 1 && num[i] == num[i + 1]) i++;
		}
	}

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 2};
		int[] arr2 = {1, 1, 2};
		System.out.println(subsetsWithDup(arr1));
		System.out.println(subsetsWithDup(arr2));
	}
	
	
}
