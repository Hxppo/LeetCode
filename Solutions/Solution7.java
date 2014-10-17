
/**
 * Search Insertion Point 
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * */
public class Solution7 {
	public static int searchInsert(int[] A, int target) {
		if (A.length == 0) {
			return 0;
		}
		return searchInsert_Helper(A, target, 0, A.length - 1);
	}
	
	public static int searchInsert_Helper(int[] A, int target, int low, int high) {
		// base condition 
		while(low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] == target) {
				return mid;
			} else  if (A[mid] > target) {
				return searchInsert_Helper(A, target, low, mid - 1);
			} else {
				return searchInsert_Helper(A, target, mid + 1, high);
			}
		}
		return low;
	}
    
	public static void main(String[] args) {
		int[] test = {1, 3};
		int index = searchInsert(test, 4);
		System.out.println(index);
		
	}
}