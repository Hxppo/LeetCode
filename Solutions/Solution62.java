/**
 * Trapping Rain Water 
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * 
 * @author huangxin
 *
 */
public class Solution62 {
	/*
	 * 解题思路 1:
	 * 
	 * 对于任意位置的A[i], 能够trap到的对多的water取决在i之前最高的值leftMostHeight[i]
	 * 和在i右边的最高的值rightMostHeight[i]。如果min(left, right) > A[i],
	 * 则当前位置能够trap的water的值就是min(left, right) - A[i].
	 * 
	 * 伪代码思路：
	 * 
	 * 1）从左到右扫描一遍，求得每个位置的左侧最高值存在数组中
	 * 2）从右到至左扫描一遍数组，求得当前位置右侧最高值。并同时计算当前
	 * 位置所存的水量
	 *
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * 
	 */
	public int trap(int[] A) {
		//No way to store any water 
		if(A.length <= 2) {
			return 0;
		}
		//1. Scan from left to right and find the highest bar on the left of each bar
		int[] lmh = new int[A.length];
		lmh[0] = 0;
		int tempMax = A[0];
		for(int i = 1; i < A.length; i++) {
			lmh[i] = tempMax;
			if(A[i] > tempMax) {
				tempMax = A[i];
			}
		}
		
		int trap = 0;
		//2. Scan from the right to left
		//calculate the highest bar on the right of each bar
		//and calculate the trapped water simultaneously
		int rmh = A[A.length - 1];
		for(int i = A.length - 2; i > 0; i--) {
			int left = lmh[i];
			int right = rmh;
			int container = Math.min(left, right);
			if(container > A[i]) {
				trap += container - A[i];
			}
			if(A[i] > rmh) {
				rmh = A[i];
			}
		}
		return trap;
	}
}
