
/**
 * Unique Binary Search Trees 
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * @author huangxin
 *
 */

public class Solution18 {

	public static int numTrees(int n) {
		if (n == 1) return 1;
		
		int[][] countArray = new int[n][n];
		// initiate countArray
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					countArray[i][j] = 1;
				} else {
					countArray[i][j] = 0;
				}		
			}
		}
		// decide the direction of the iteration 
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j <= n - 1; j++) {
				for (int k = i; k <= j; k++){
					int temp = 0;
					if (k == i) {
						temp = countArray[k + 1][j];
					} else if (k == j){
						temp = countArray[i][k - 1];
					} else {
						temp = (countArray[i][k - 1] * countArray[k + 1][j]);
					}
					countArray[i][j] += temp;
				}
			}
		}
		return countArray[0][n - 1];
	}
	
	//recursive version
	public int countHelper(int low, int high) {
		int count = 0;
		//base condition 
		if (low > high) {
			count = 0;
		}
		if (low == high) {
			count = 1;
		}
		if (low < high){
			for (int i = 1; i <= high; i++) {
				int temp = countHelper(low, i - 1) * countHelper(i + 1, high);
				count += temp;
			}
		}
		return count;
	}

	
	public static void main(String[] args) {
		int count = numTrees(5);
		System.out.println(count);
	}
}
