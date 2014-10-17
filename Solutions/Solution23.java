//import java.util.ArrayList;

/**
 * Maximum Subarray 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * Requirement: O(n) running time; recursive and non-recursive version
 * @author huangxin
 *
 */
public class Solution23 {
	/*
	 * 采用动态规划求解。
	 * 定义最大值的数组Max[i] = 以ith元素结尾的连续数租的最大值
	 * 一维动态规划可以省略动态规划数组
	 * 在每个i + 1元素有两种选择：
	 * 1） Max[i] + A[i] >= 0 则当前元素可以加入连续数列中
	 * 2） Max[i] + A[i] < 0; 则A[i + 1]必为负数，没有保留的必要，舍去，重新计算最大值
	 */
    public int maxSubArray(int[] A) {
        if (A.length < 0) {
        	return 0;
        }
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
      
        for (int i = 1; i < A.length; i++) {
        	sum[i] = Math.max(sum[i - 1] + A[i], A[i]);
        	max = Math.max(sum[i], max);
        }    
        return max;
    }
    
    /*
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * Divide conquer approach:
     * 将数组分成左右两部分，递归求两部分的最大连续子数组。由于最大连续
     * 数组可能横跨左右，因此需要对此种情况进行处理
     * 假设数组A[left, right]中存在最大值区间[i,j],以mid = (left+right)/2
     * 为界，分为以下三种情况：
     * 1) 最大连续子数组完全在左区间 entirely in A[left, mid - 1]
     * 2) 最大连续子数组完全在右区间 entirely in A[mid + 1, right]
     * 3) across mid point
     * 对于1、2两种情况，直接递归求解
     * 对于第三种情况以mid为中心，分别向左及向右扫描求最大值。并求和得最大值
     * 比较以上三种情况下得到的子数组和，取其最大值
     */
    
    public static int maxSubArray_recursive(int[] A) {
    	int max = Integer.MIN_VALUE;
    	return maxArray(A, 0, A.length - 1, max);
    }
    
    private static int maxArray(int[] A, int left, int right, int max) {
    	//base condition
    	if (left > right) {
    		return Integer.MIN_VALUE;
    	}
    	//computing the max subarray from left and right partition
    	int mid = (left + right) / 2;
    	int leftMax = maxArray(A, left, mid - 1, max);
    	int rightMax = maxArray(A, mid + 1, right, max);
    	
    	max = Math.max(max, leftMax);
    	max = Math.max(max, rightMax);
    	//scan through the left and right partition
    	
    	int sum = 0;
    	int mlmax = 0; //注意这里不是负无穷，因为如果为负数，则没有意义相加
    	for (int i = mid - 1; i >= left; i--) {
    		sum += A[i];
    		if (sum > mlmax) {
    			mlmax = sum;
    		}
    	}
    	
    	sum = 0;
    	int mrmax = 0;
    	for (int i = mid + 1; i <= right; i++) {
    		sum += A[i];
    		if (sum > mrmax) {
    			mrmax = sum;
    		}
    	}
    	
    	//find the new max subarray
    	max = Math.max(max, A[mid] + mrmax + mlmax);
    	
    	return max;
    }
}
