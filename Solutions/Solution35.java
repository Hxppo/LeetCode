import java.util.*;

/**
 * Search for a Range
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * @author huangxin
 *
 */
public class Solution35 {
	
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static int[] searchRange_own(int[] A, int target) {
		if (A == null) {
			return null;
		}
		
		if (A.length == 0) {
			int[] temp = {-1, -1};
			return temp;
		}
		
		searchHelper(A, 0, A.length - 1, target);
		if (result.size() == 0) {
			int[] temp = {-1, -1};
			return temp;
		} else {
			int[] temp = {result.get(0), result.get(result.size() - 1)};
			return temp;
		}
    }
	
	private static void searchHelper(int[] A, int low, int high, int target) {
		if (low > high){
			return;
		}
		int mid = (low + high) / 2;
		if (A[mid] < target) {
			searchHelper(A, mid + 1, high, target);
		} else if (A[mid] > target) {
			searchHelper(A, low, mid - 1, target);
		} else {
			searchHelper(A, low, mid - 1, target);
			result.add(mid);
			searchHelper(A, mid + 1, high, target);
		}
	}
	
    public static int[] searchRange(int[] A, int target) {  
        int[] ret = {Integer.MAX_VALUE, Integer.MIN_VALUE};  
        rec(A, target, ret, 0, A.length-1);  
        if(ret[0] == Integer.MAX_VALUE){  
            ret[0] = -1;  
        }  
        if(ret[1] == Integer.MIN_VALUE){  
            ret[1] = -1;  
        }  
        return ret;  
    }  
      
    // 先用二分法找到满足条件，然后对两边分别二分法继续寻找  
    public static void rec(int[] A, int target, int[] ret, int low, int high){  
        if(low > high){  
            return;  
        }  
          
        int mid = low + (high-low)/2;  
        if(target == A[mid]){  
            ret[0] = Math.min(ret[0], mid);     // 保存最小下限  
            ret[1] = Math.max(ret[1], mid);     // 保存最大上限  
            rec(A, target, ret, low, mid-1);        // 继续找满足条件的下限  
            rec(A, target, ret, mid+1, high);       // 继续找满足条件的上限  
        }else if(target < A[mid]){  
            rec(A, target, ret, low, mid-1);  
        }else{  
            rec(A, target, ret, mid+1, high);  
        }  
    } 
	
	
	public static void main(String[] args) {
		int[] test = {2, 2};
		int[] result = searchRange_own(test, 1);
		for (int x : result) {
			System.out.println(x);
		}
		//System.out.print(result);
	}
}
