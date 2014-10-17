/**
 * Plus One 
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * @author huangxin
 *
 */

public class Solution49 {
	public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
        	int[] result = {1};
        	return result;
        }
        
        int cin = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
        	int val = cin + digits[i];
        	digits[i] = val % 10;
        	cin = val / 10;
        }
        if (cin == 0) {
        	return digits;
        } else {
        	int[] result = new int[digits.length + 1];
        	result[0] = cin;
        	for (int i = 1; i < result.length; i++) {
        		result[i] = digits[i - 1];
        	}
        	return result;
        }  
    }
}
