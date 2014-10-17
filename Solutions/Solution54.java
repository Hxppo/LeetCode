/**
 * Search in Rotated Sorted Array II
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * @author huangxin
 *
 */
public class Solution54 {
	 public boolean search(int[] A, int target) {
	        return searchHelper(A, target, 0, A.length - 1);
	 }
	 
	 public boolean searchHelper(int[] A, int target, int low, int high) {
		 if (low > high) {
			 return false;
		 }
		 int mid = (low + high) >> 1;
		 if (A[mid] == target) {
			 return true;
		 } else {
			 if(searchHelper(A, target, low, mid - 1)) {
				 return true;
			 } else {
				 return searchHelper(A, target, mid + 1, high);
			 }
		 } 
	 }
    
    
    public static int findPivot(int[] arr) {
    	int low = 0;
    	int high = arr.length - 1;
    	while (arr[low] > arr[high]) {
    		int mid = (low + high) / 2;
    		if (arr[mid] < arr[high]) {
    			high = mid;
    		} else {
    			low = mid + 1;
    		}
    	}
    	return low;
    }
    
    public boolean binarySearch(int[] arr, int target) {
    	return binarySearch_helper(arr, target, 0, arr.length - 1);
    }
    
    public boolean binarySearch_helper(int[] arr, int target, int low, int high) {
    	if (low > high) {
    		return false;
    	} else {
    		int mid = (low + high) / 2;
    		if (arr[mid] == target) {
    			return true;
    		} else if (arr[mid] > target) {
    			return binarySearch_helper(arr, target, low, mid - 1);
    		} else {
    			return binarySearch_helper(arr, target, mid + 1, high);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	int[] test = {3, 1};
    	System.out.print(findPivot(test));
    }
}
