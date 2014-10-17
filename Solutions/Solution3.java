import java.lang.Math;

/**
 * Find the median of two sorted arrays
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author huangxin
 *
 */

public class Solution3 {
	/*
	 * 思路： Find the kth element of two sorted array (二分法搜索)
	 * */
	public static int findKth(int[] A, int[] B, int k, int low, int high) {
		int m = A.length;
		int n = B.length;
		
		if (m == 0) {
			return B[k - 1];
		}
		if (n == 0) {
			return A[k - 1];
		}
		if (k == 1){
			return Math.min(A[0], B[0]);
		}
		
		// we have traverse all elements in array A, the answer is in array B
		if (low > high) {
			return findKth(B, A, k, 0, n -1);
		}
		
		// find the kth element within the tow arrays
		int i = low + (high - low) / 2;
		int j = k - 1 - i - 1;
		
		if ((j < 0 || (j < n && A[i] >= B[j])) 
		        && (j + 1 >= n || (j + 1 >= 0 && A[i] <= B[j + 1]))) {
		        return A[i];
		} else if ((j < 0) || (j + 1 < n && A[i] > B[j + 1])) {
			return findKth(A, B, k, low, i - 1);
		} else {
			return findKth(A, B, k, i + 1, high);
		}
	}

    
	static double findMedianSortedArrays(int[] a,int[] b) {
		int m = a.length;
		int n = b.length;
		
		if ((m + n) % 2 == 0) {
			return ((findKth(a, b, (m + n) / 2, 0, m -1) + 
					findKth(a, b, (m + n) / 2 + 1, 0, m - 1)) / 2.0); 
		} else {
			return findKth(a, b, (m + n) / 2 + 1, 0, m - 1);
		}
	}
	
    public static void main(String[] args) {
    	int[] a = {1, 3};
    	int[] b = {2};
    
    	System.out.println(findMedianSortedArrays(a, b));
    }
}
