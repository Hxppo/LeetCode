/**
 * Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution139 {
    public static String simplifyPath(String path) {
        // base condition
    	if (path == null || path.charAt(0) != '/') return null;
    	
    	// split the path by slash
    	String[] splits = path.split("/");
    	
    	// go thought splits and push valid subString into stack
    	Stack<String> stack = new Stack<String>();
    	for (String str : splits) {
    		if (str.equals("..") && !stack.isEmpty()){
    			stack.pop();
    		} else if (!str.equals(".") && !str.equals("..") && !str.isEmpty()) {
    			stack.push(str);
    		}
    	}
    	
    	// assemble the substrings in the stack to a path that is the result
	    if (stack.isEmpty()) return "/";  
	    StringBuilder sb = new StringBuilder();  
	    while (!stack.isEmpty()) {  
	    	sb.insert(0, "/" + stack.pop());  
	    }  
	    return sb.toString(); 
    }
    
    public static void main(String[] args) {
    	String path = "/...";
    	System.out.println(simplifyPath(path));
    }
}
