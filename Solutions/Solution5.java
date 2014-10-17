import java.lang.StringBuffer;

/**
 * Reverse digits of an integer
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Notice: Overflow is not considered here!
 * @author huangxin
 *
 */
public class Solution5 {
    public static int reverse(int x) {
    	StringBuffer str = new StringBuffer();
    	if (x >= 0){
    		str.append(x);
	    	str.reverse();
	    	return Integer.valueOf(str.toString());
    	} else {
    		str.append(-1 * x);
    		str.reverse();
    		return -1 * Integer.valueOf(str.toString());
    	}
    	
    }
    
    public static void main(String[] args) {
    	int test = -123;
    	System.out.println(reverse(test));
    }
    
    
}
