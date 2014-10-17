/**
 * Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * @author huangxin
 *
 */
public class Solution24 {
	/* 解题思路： 双指针，一前一后扫描
	 * */
	public static int removeDuplicates(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[index]) {
				A[++index] = A[i];
			}
		}
		return index + 1;
    }
	
	public static void main(String[] args) {
		int[] test = {};
		System.out.println(removeDuplicates(test));
	}
}
