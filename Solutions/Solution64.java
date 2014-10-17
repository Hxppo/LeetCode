import java.util.Stack;
/**
 * Valid Parentheses 
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author huangxin
 *
 */
public class Solution64 {
	/* 解题思路： 
	 * 经典的栈匹配问题。左括号入栈，右括号出栈。比较是否匹配，最后并检查栈是否为空；
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		
		for(int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
				continue;
			}
			if(stack.empty()){
				return false;
			}
			char top = stack.peek();
			if(ch == '}' && top != '{') {
				return false;
			}
			if(ch == ']' && top != '[') {
				return false;
			}
			if(ch == ')' && top != '(') {
				return false;
			}
			stack.pop();
		}
		if(!stack.empty()) {
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isValid("[])"));
	}
}
