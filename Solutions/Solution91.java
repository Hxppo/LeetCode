/**
 *  Divide Two Integers
 * 
 *  Divide two integers without using multiplication, division and mod operator.
 */

import java.util.*;

public class Solution91 {
	/**
	 * Solution：
	 * 
	 * 我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，即num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
	 * 基于以上这个公式以及左移一位相当于乘以2，我们先让除数左移直到大于被除数之前得到一个最大的基。
	 * 然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
	 * 因为这个方法的迭代次数是按2的幂知道超过结果，所以时间复杂度为O(logn)。
	 * 
	 * Time Complexity: O(logn)
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public int divide(int dividend, int divisor) {   
    	if (dividend == 0 || divisor == 1) return dividend;  
    	if (divisor == -1) return 0 - dividend;
    	   
    	// convert data type of two inputs
    	long dividendLong = (long)Math.abs(dividend);
    	long divisorLong = (long)Math.abs(divisor);
    	
    	// construct a list of divisors. Each time we double divisor until it is larger than the dividend
    	ArrayList<Long> divisors = new ArrayList<Long>();
    	while (divisorLong <= dividendLong) {
    		divisors.add(divisorLong);
    		divisorLong = (long)Math.pow(divisorLong,2);
    	}
    	
    	int result = 0;
    	int cur = divisors.size() - 1;
    	// iterate the list to find the value of each base according to the given equation
    	while (cur >= 0 && dividendLong > 0) {
    		while (dividendLong >= divisors.get(cur)) {
    			dividendLong -= divisors.get(cur);
    			result += 1 << cur;
    		}
    		--cur;
    	}
    	return (((dividend > 0) ^ (divisor > 0)) ? -result : result);
    }
    
    public int divide_better(int dividend, int divisor) {
        int sign = 1;  
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        
        long a = dividend;  
        long b = divisor;  
        //must cast to long here for dealing with the Integer.MIN_VALUE  
        //because Math.abs(-2147483648) > Integer.MAX_VALUE  
        a = Math.abs(a);  
        b = Math.abs(b);

        int count = 0;  
        while(a >= b){  
            long temp = b;  
            int multi = 1;  
            while(a >= temp){  
                count += multi;  
                a -= temp;  
                temp += temp;  
                multi += multi;  
            }  
        }  
        return count * sign;  
    }  
}
