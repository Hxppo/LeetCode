import java.util.*;
/**
 * Triangle 
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 *	[
 *	     [2],
 *	    [3,4],
 * 	   [6,5,7],
 *	  [4,1,8,3]
 *	]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author huangxin
 *
 */
public class Solution77 {
	/*
	 * 解题思路：一维动态规划DP
	 * 
	 */
	public static int  minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int row = triangle.size();
		int col = triangle.get(row - 1).size();
		//define a dimension array 
		int D[] = new int[col];
		//initialize the array
		for (int i = 0; i < col; i++) {
			D[i] = triangle.get(row - 1).get(i);
		}
		
		//Scan the triangle bottom up 
		for (int i = row - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				D[j] = Math.min(D[j], D[j + 1]) + triangle.get(i).get(j);
			}
		}
	    return D[0];
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<Integer>());
		triangle.add(new ArrayList<Integer>());
		triangle.get(0).add(2);
		triangle.get(1).add(3);
		triangle.get(1).add(4);
		
		System.out.println(minimumTotal(triangle));
	}
}
