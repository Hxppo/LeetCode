/**
 * Pow(x, n)
 * 
 * @author huangxin
 *
 */
public class Solution96 {
	/*
	 * solution 1: iterate 
	 * Time Complexity: O(n)
	 * 
	 * Notice n can be: zero, positive, negative
	 */
	public double pow_slow(double x, int n) {
        double result = 1.0;
        if (n == 0) return 1;
        
        for (int i = Math.abs(n); i >= 1; i--) {
        	result *= x;
        }
            
        return (n > 0 ? result : 1.0 / result);
    }
	
	/*
	 * solution 2: binary search 
	 * Time Complexity: O(logn)
	 * 
	 * return 1, if n == 0;
     * return 1/pow(x, -n), if n < 0;
     * return x^(n/2) * x^(n/2), if n is even;
     * return x * x^(n/2) * x^(n/2), if n is odd.
	 * 
	 */
	public double pow(double x, int n) {  
        if (n == 0) return 1;  
        int exp = Math.abs(n);  
        double half = pow(x, exp >> 1);  
        double res = half * half;  
        if ((exp & 1) == 1) res *= x;  
        return (n > 0) ? res : 1.0 / res;  
    }  
}
