/**
 * Integer to Roman
 * 
 * Given an integer, convert it to a Roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author huangxin
 *
 */
public class Solution53 {
	/*
	 * 解题思路：
	 * I = 1;
	 * V = 5;
	 * X = 10;
	 * L = 50;
	 * C = 100;
	 * D = 500;
	 * M = 1000;
     * 其中每两个阶段的之间有一个减法的表示，比如900=CM， C写在M前面表示M-C。
     * 范围给到3999，感觉情况不多直接打表其实更快，用代码判断表示估计比较繁琐。
     * 然后就是贪心的做法，每次选择能表示的最大值，把对应的字符串连起来。 
	 */
    public String intToRoman(int num) {
    	String str = "";
    	String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
    			"X", "IX", "V", "IV", "I"};
    	int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	//greedy algorithm
    	for (int i = 0; num != 0; ++i) {
    		while (num >= val[i]) {
    			num -= val[i];
    			str += symbol[i];
    		}
    	}
    	return str;
    }	
}
