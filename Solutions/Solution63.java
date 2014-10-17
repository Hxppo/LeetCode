/**
 * Length of Last Word 
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0
 * 
 * @author huangxin
 *
 */

public class Solution63 {
    public static int lengthOfLastWord(String s) {
        StringBuffer str = new StringBuffer(s);
        int n = str.length();
        //找出第一个不为连续space的位置
        int index = n - 1;
        for(index = n - 1; index >= 0; index--) {
        	if(str.charAt(index) != ' ') {
        		break;
        	}
        }
        //检查是否整个字符串的字符都是空格
        if(index == -1) {
        	return 0;
        }
        //计算最后一个有效字符串的长度
        System.out.println(index);
        char ch = str.charAt(index);
        int length = 0;
        while(ch != ' ') {
        	if(index == 0){
        		return length + 1;
        	} else {
        		index--;
        		ch = str.charAt(index);
        		length++;
        	}    	
        }
        return length;            
    }
    
    public static void main(String[] args) {
    	System.out.println(lengthOfLastWord(" 1"));
    }
}
