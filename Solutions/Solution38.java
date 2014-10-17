/**
 * Search a 2D Matrix 
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * @author huangxin
 *
 */
public class Solution38 {
	/*
	 * 改进版： 不需要额外的一位数组储存输入。通过坐标变换，一次二分搜索
	 * 时间复杂度： O(log(mn))
	 * 循环版的二分法搜索，非递归
	 */
	public static boolean searchMatrix(int[][] matrix, int target) { 
		int row = matrix.length;
		int col = matrix[0].length;
		int low = 0;
		int high = row * col - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (matrix[mid / col][mid % col] == target) {
				return true;
			} else if (matrix[mid / col][mid % col] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
    }
	
	/*
	 * 解题思路： 两次二分法。先确定行号，然后在已经确定的行内第二次二分法搜索。
	 * 确定行号边界条件过多，可以先行将二维数组转为一位数组，一次二分法搜索即可。
	 * 时间复杂度： O(m + n + log(mn))
	 * 空间复杂度： O(mn)
	 */
	public static boolean searchMatrix_version2(int[][] matrix, int target) {
		int[] temp = new int[matrix.length * matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp[i * j] = matrix[i][j];
			}
		}
		return binarySearch(temp, 0, temp.length - 1, target);
	}
	
	private static boolean binarySearch(int[] a, int low, int high, int target) {
		//base condition
		if (low > high) return false;
		
		int mid = (low + high) / 2;
		if (a[mid] == target) {
			return true;
		} else if (a[mid] > target) {
			return binarySearch(a, low, mid - 1, target);
		} else {
			return binarySearch(a, mid + 1, high, target);
		}
	}
	
	static int binarySearch_index(int[] a, int low, int high, int target) {
		if (low > high) {
			return low;
		}
		int mid = (low + high) / 2;
		
		if (a[mid] == target) {
			return mid;
		} else if (a[mid] > target) {
			return binarySearch_index(a, low, mid - 1, target);
		} else {
			return binarySearch_index(a, mid + 1, high, target);
		}
	}
	
	public static void main(String[] args) {
		int[][] test = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[] test1 = {1,3};
		System.out.println(binarySearch_index(test1,0, test1.length - 1, 4));
		System.out.print(searchMatrix(test, 3));
	}
}
