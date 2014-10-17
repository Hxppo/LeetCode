/**
 * Implement strStr()
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 
 * @author huangxin
 *
 */
public class Solution78 {
    public static String strStr(String haystack, String needle) {
    	//special condition
    	if (haystack.length() < needle.length()) {
    		return null;
    	} else if (haystack == "" && needle == "") {
    		return haystack;
    	} else if (haystack == "" && needle != "") {
    		return null;
    	} else if (haystack != "" && needle == "") {
    		return haystack;
    	}
    	
        char[] needleArray = needle.toCharArray();
        char[] haystackArray = haystack.toCharArray();
        
        char needlePointer;
        char head;
        char tail;
        
        for (int i = 0; i <= haystackArray.length - needleArray.length; i++) {
        	needlePointer = needleArray[0];
        	head = haystackArray[i];
        	if (needlePointer == head) {
        		//check the if second loop is needed
        		if (needleArray.length == 1) {
        			return haystack.substring(i);
        		}
        		for (int j = 1; j <= needleArray.length - 1; j++) {
        			tail = haystackArray[i + j];
        			needlePointer = needleArray[j];
        			if (tail != needlePointer) {
        				break;
        			} else if (j == needleArray.length - 1) {
        				return haystack.substring(i);
        			}
            	}  	
        	}
        }
        return null;
    }
    
    public static void main(String args[]) {
    	String haystack = "a";
    	String needle = "a";
    	
    	System.out.print(strStr(haystack, needle));
    }
}
