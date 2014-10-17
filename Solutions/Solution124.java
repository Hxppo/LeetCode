/**
 * ZigZag Conversion
 * 
 * @author huangxin
 */
public class Solution124 {
	public String convert(String s, int nRows) {
        if (nRows <= 1) return s;
        if (s.length() < nRows) return s;
        
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < nRows; i++) {
        	for (int j = i; j < s.length(); j += 2 * (nRows - 1)) {
        		result.append(s.charAt(j));
        		if (i > 0 && i < nRows - 1) {
        			if (j + 2 * (nRows - i - 1) < s.length()) {
        				result.append(s.charAt(j + 2 * (nRows - i - 1)));
        			}
        		}
        	}
        }
        
        return result.toString();
    }
}
