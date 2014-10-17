
/**
 * Longest Common Prefix 
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author huangxin
 *
 */
public class Solution72 {
	public static String longestCommonPrefix(String[] strs) {		
		if(strs.length == 0){
			return "";
		}
		
		StringBuffer res = new StringBuffer();
		int maxLength = strs[0].length();
		for(int i = 1; i < strs.length; i++) {
			maxLength = Math.min(strs[i].length(), maxLength);
		}
		
		for(int index = 0; index < maxLength; index++) {
			char current = strs[0].charAt(index);
			for(int i = 1; i < strs.length; i++) {
				if(strs[i].charAt(index) != current) {
					return res.length() == 0 ? "" : res.toString();
				}		
			}
			res.append(current);
		}
		return res.length() == 0 ? "" : res.toString();
    }
	
	public static void main(String[] args) {
		String[] strs = {"a"};
		longestCommonPrefix(strs);
		System.out.print(longestCommonPrefix(strs));
	}
}
