/**
 * Letter Combinations of a Phone Number 
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * @author huangxin
 *
 */

import java.util.*;

public class Solution111 {
	public static List<String> letterCombinations(String digits) {
        if (digits == null) return null;
        
        ArrayList<String> res = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        
        // construct all possible arrays
        String[] trans = {"", " ", "abc", "def", "ghi", "jkl",  "mno", "pqrs", "tuv", "wxyz"};
        letterHelper(digits, 0, trans, res, buffer);
        return res;
    }
	
	private static void letterHelper(String digits, int deep, String[] trans, ArrayList<String> res, StringBuffer buffer) {
		if (deep == digits.length()) {
			res.add(buffer.toString());
			return;
		}
		
		int index = digits.charAt(deep) - 48;
		char[] current = trans[index].toCharArray();
		for (int i = 0; i < current.length; i++) {
			buffer.append(current[i]);
			letterHelper(digits, deep + 1, trans, res, buffer);
			buffer.deleteCharAt(buffer.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		String str = "23";
		List<String> res = letterCombinations(str);
		for (String x : res) {
			System.out.println(x);
		}
		
		
	}
}
