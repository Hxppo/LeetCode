import java.util.*;
/**
 * Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author huangxin
 *
 */
public class Solution26 {
    public int romanToInt(String s) {
    	int sum;
    	int pre, cur;
    	
    	sum = charToInt(s.charAt(0));
    	
    	for (int i = 1; i < s.length(); i++) {
    		pre = charToInt(s.charAt(i - 1));
    		cur = charToInt(s.charAt(i));
    		
    		if (cur <= pre) {
    			sum += cur;
    		} else {
    			sum = sum - pre * 2 + cur;
    		}
    	}
    	return sum;
    }
    
    private static int charToInt(char c) {
    	int data = 0;
    	switch(c) {
    	case 'I':
    		data = 1;
    		break;
    	case 'V':
    		data = 5;
    		break;
    	case 'X': 
    		data = 10;
    		break;
    	case 'L':
    		data = 50;
    		break;
    	case 'C':
    		data = 100;
    		break;
    	case 'D':
    		data = 500;
    		break;
    	case 'M':
    		data = 1000;
    		break;
    	}
    	return data;
    }
}
