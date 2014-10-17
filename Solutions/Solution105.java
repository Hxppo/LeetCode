/**
 * Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * @author huangxin
 *
 */

public class Solution105 {
	/**
	 * 直接使用Java自带的spli函数进行正则分割
	 * 其中要注意两点：
	 * 1> spli(" ") 若被分割的字符串已空格开头，" 1" -> "" + "1"
	 * 2> 对于输入字符串为空的情况特殊处理
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        String[] strArray = s.split(" ");
        
        for (int i = strArray.length - 1; i >= 0; i--) {
        	if (!strArray[i].equals("")) {
        		res.append(strArray[i] + " ");
        	}
        }
        
        return res.length() == 0 ? "" : res.substring(0, res.length() - 1);
    }
	
	public static void main(String[] args) {
		//String s = "the sky is blue";
		String s = " 1";
		System.out.println(reverseWords(s));
	}
}
