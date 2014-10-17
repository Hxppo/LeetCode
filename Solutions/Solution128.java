/**
 * Scramble String
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution128 {
	// Recursive Solution
    public static boolean isScramble(String s1, String s2) {
    	// Base Condition 
    	if (s1.length() != s2.length()) return false;
    	if (s1.equals(s2)) return true;
    	
    	if (!stringCount(s1, s2)) return false;
    	
    	// Partition these two strings
    	for (int index = 0; index < s1.length() - 1; index++) {
    		String s11 = s1.substring(0, index + 1);
    		String s12 = s1.substring(index + 1, s1.length());
    		// forward order
    		String s21 = s2.substring(0, index + 1);
    		String s22 = s2.substring(index + 1, s2.length()); 
    		// Check it these two sub-part is scramble or not
    		// Notice each partition from string1 can be mapped to either sub part of string2
    		if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
    		if (isScramble(s11, s22) && isScramble(s12, s21)) return true;
    		
    		// reverse order
    		s21 = s2.substring(0, s2.length() - index - 1);
    		s22 = s2.substring(s2.length() - index - 1, s2.length());
    		if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
    		if (isScramble(s11, s22) && isScramble(s12, s21)) return true;
    		
    	}
    	
    	return false;
    }
    
    // Pruning function: if two string do not contains same amount of characters, there is no way they can be scrambled
    private static boolean stringCount(String s1, String s2) {
    	char[] chr1 = s1.toCharArray();
    	char[] chr2 = s2.toCharArray();
    	
    	Arrays.sort(chr1);
    	Arrays.sort(chr2);
    	
    	String t1 = new String(chr1);
    	String t2 = new String(chr2);
    	
    	return (t1.equals(t2));
    }
    
    // Solution 2
    
    public static void main(String[] args) {
    	String s1 = "abb";
    	String s2 = "bba";
    	
    	System.out.println(isScramble(s1, s2));
    }
}
