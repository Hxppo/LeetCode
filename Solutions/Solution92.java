/**
 * Sqrt(x)
 * 
 * mplement int sqrt(int x).
 * Compute and return the square root of x.
 */

public class Solution92 {
    public static int sqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        int start = 1;
        int end = (int)(x / 2 < Math.sqrt(Integer.MAX_VALUE) ? x / 2 + 1 : Math.sqrt(Integer.MAX_VALUE));
        int mid = 0;
        
        while (start <= end) {
        	mid = (start + end) / 2;
        	if (mid * mid > x) {
        		end = mid - 1;
        	} else if (mid * mid < x) {
        		start = mid + 1;;
        	} else {
        		return mid;
        	}
        }
        
        return (start + end) / 2;
    }
    
    public static void main(String[] args) {
    	System.out.print(sqrt(4));
    }
}
