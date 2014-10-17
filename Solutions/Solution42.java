/**
 * Single Number II
 * 
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * @author huangxin
 *
 */
public class Solution42 {
	public static int singleNumber(int[] A) {
		int result = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			if (countBits(A, i) % 3 == 1) {
				//将输出的ith位置1
				int mask = 1 << i;
				result ^= mask;
			}
		}
		return result;
	}
	
	public static int countBits(int[] array, int i) {
		int mask = 1 << i;
		int sum = 0;
		for (int j = 0; j < array.length; j++) {
			 if ((array[j] & mask) != 0) {
				 sum++;
			 }
		}
		return sum;
	}
	
	public static int singleNUmber_version2(int[] A) {
		int result = 0;      
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += ((A[j] >> i) & 1); //统计每一位的个数
            }
            result |= ((count % 3) << i);   //取余放回result
        } 
        return result;
	}
	
	public static void main(String[] args) {
		int[] test = {1, 1, 1, 2};
		//System.out.println(countBits(test, 1));
		System.out.println(singleNumber(test));
	}
}
