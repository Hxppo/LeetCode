/**
 * Search in a Sorted Array I
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author huangxin
 *
 */

public class Solution1 {
    public static int search(int[] A, int target) {
    	int rotationPoint = findPivot(A);
        //decide the partition
    	if (rotationPoint != 0) {
    		int index =  binarySearchHelper(A, 0, rotationPoint - 1, target);
    		if (index != -1) {
    			return index;
    		} else {
    			return binarySearchHelper(A, rotationPoint, A.length - 1, target);
    		}
    	}
    	return binarySearchHelper(A, 0, A.length - 1, target);
    }
    
    public static int findPivot(int[] arr) {
    	int low = 0;
    	int high = arr.length - 1;
    	while (arr[low] > arr[high]) {
    		int mid = (low + high) / 2;
    		if (arr[mid] > arr[high]) {
    			low = mid + 1;
    		} else {
    			high = mid;
    		}
    	}
    	return low;
    }
    
    public static int binarySearch(int[] arr, int value) {
    	return binarySearchHelper(arr, 0, arr.length, value);
    }
    
    
    public static int binarySearchHelper(int[] arr, int low, int high, int value) {
    	if (low > high) return -1;
		int mid = (low + high) / 2;
			if(arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				return binarySearchHelper(arr, mid + 1, high, value);
			} else {
				return binarySearchHelper(arr, low, mid - 1, value);
			}
    }  	
    
    public int search2(int[] A, int target) {  
        return rec(A, target, 0, A.length-1);  
    }  
      
    public int rec(int[] A, int target, int low, int high){  
        if(low > high){  
            return -1;  
        }  
          
        int mid = low + (high-low)/2;  
        if(A[mid] == target){  
            return mid;  
        }  
        int pos = rec(A, target, mid+1, high);  
        if(pos != -1){  
            return pos;  
        }else{  
            return rec(A, target, low, mid-1);  
        }  
    }
    
    
    public static void main(String[] args) {
    	int[] array = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(search(array,1));
    	int[] test = {3, 1};
    	System.out.println(search(test, 1));
    	//System.out.println(binarySearchHelper(test, 0, 0, 1));
    }
    
}
