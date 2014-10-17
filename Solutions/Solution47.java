/**
 * Remove Duplicates from Sorted Array II 
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * @author huangxin
 *
 */
public class Solution47 {
	/*
	 * 解题思路：双指针 类似快速排序 
	 */
	public static int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		
		int index1 = 1;
		int index2 = 1;
		int count = 1;
		
		for (index2 = 1; index2 < A.length;) {
			if (A[index2] == A[index1 - 1]) {
				if (count >= 2) {
					index2++;
					count++;
				} else {
					A[index1] = A[index2];
					index1++;
					index2++;
					count++;
				}
			} else {
				A[index1] = A[index2];
				index1++;
				index2++;
				count = 1;
			}
		}
		return index1;
	}
	
	public static void main(String[] args) {
		int[] test = {1, 1, 2};
		System.out.println(removeDuplicates(test));
	}
}
