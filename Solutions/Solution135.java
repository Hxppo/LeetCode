/**
 * Restore IP Addresses
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * @author huangxin
 *
 */
import java.util.*;

public class Solution135 {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> resSet = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) return resSet;
        dfs(s, "", resSet, 0);
        return resSet;
    }
    
    private static void dfs(String s, String buffer, ArrayList<String> resSet, int count) {
    	// base condition 
    	if (count == 3 && isValid(s)) {
    		resSet.add(buffer + s);
    		return;
    	}
    	
    	// Recursive call function
    	for (int i = 1; i < 4 && i < s.length(); i++) {
    		String subStr = s.substring(0, i);
    		if (isValid(subStr)) {
    			// add it to buffer and recursive call 
    			dfs(s.substring(i), buffer + subStr + '.', resSet, count + 1);
    		}
    	}
    }
    
    private static boolean isValid(String s) {
    	if (s.charAt(0) == '0') return s.equals("0");
    	int num = Integer.parseInt(s);
    	return num <= 255 && num > 0;
    }
}
