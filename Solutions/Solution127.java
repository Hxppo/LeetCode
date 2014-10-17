/**
 * Valid Palindrome 
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases
 * @author huangxin
 *
 */

public class Solution127 {
    public static boolean isPalindrome(String s) {
        // base condition 
    	if (s == null) return false;
    	if (s.length() == 0) return true;
    	
    	StringBuffer buffer = new StringBuffer();
    	for (int i = 0; i < s.length(); i++) {
    		char chr = s.charAt(i);
    		if (chr >= '0' && chr <= '9') {
    			buffer.append(chr);
    		}
    		if (chr >= 'A' && chr <= 'Z') {
    			buffer.append(Character.toLowerCase(chr));
    		}
    		if (chr >= 'a' && chr <= 'z') {
    			buffer.append(chr);
    		}
    	}
    	
    	return isPalindrome(buffer.toString(), 0, buffer.length() - 1);
    }
    
	private static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
    
    
    
    public static void main(String[] args) {
    	String test = "A man, a plan, a canal: Panama";
    	System.out.println(isPalindrome(test));
    	
    	String test1 = "race a car";
    	System.out.println(isPalindrome(test1));
    }
}
