/**
 * Count and Say
 * 
 * Given an integer n, generate the nth sequence.
 * @author huangxin
 *
 */

public class Solution107 {
	
	public static String countAndSay(int n) {
        if (n <= 0) return null;
        if (n == 1) return "1";
        
        StringBuffer res = new StringBuffer();
        countAndSayHelper("11", res, 2, n);
        return res.toString();
    }
	
	private static void countAndSayHelper(String preStr, StringBuffer res, int level, int n) {
		if (level == n) {
			res.append(preStr);
			return;
		}
		
		StringBuffer buffer = new StringBuffer();
		int preIndex = 0;
		int curIndex = 0;
		for (preIndex = 0; preIndex < preStr.length();) {
			int count = 1;
			for (curIndex = preIndex + 1; curIndex < preStr.length(); curIndex++) {
				if (preStr.charAt(preIndex) == preStr.charAt(curIndex)) {
					count++;
				} else {
					buffer.append(count);
					buffer.append(preStr.charAt(preIndex));
					preIndex = curIndex;
					break;
				}
			}
			if (curIndex == preStr.length()) {
				count = preStr.length() - preIndex;
				buffer.append(count);
				buffer.append(preStr.charAt(preIndex));
				break;
			}
		}
		
		countAndSayHelper(buffer.toString(), res, level + 1, n);
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
