/**
 * Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution140 {
	/*
	 * 同solution64, 通过维护一个栈用来保存左括号。
	 * 左括号入栈，遇右括号出栈
	 * Key Point: 维护一个栈，每次维护上一个可能的左括号。
	 * 
	 * 个人觉得几个tricky和边界条件容易出问题的地方：
	 * 1 这里栈中并不直接存放右括号，而是存放此右括号对应的index。目的在于方便回溯有效字符串的长度
	 * 2 当遇见右括号的时候可能发生两种情况：hit the match (stack is not empty) or not (stack is empty)
	 * 	 每次遇到match的时候都需要更新当前最长有效字符串的长度。更新时也会遇到两种情况，弹出匹配左括号之后当前栈是否为空。
	 */
    public int longestValidParentheses(String s) {
    	// corner case
    	if (s == null) return 0;
    	
    	Stack<Integer> lefts = new Stack<Integer>();
    	int maxLength = 0; int pre = -1;
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			// push it into stack
    			lefts.push(i);
    		} else {
    			// if stack is empty, we have hit the end of current valid parentheses string
    			if (lefts.isEmpty()) {
    				pre = i;
    			} else {
    				// In this case, we have hit an pair
    				lefts.pop();
    				// We have to update the maxLength if needed
    				// There are two cases: the stack is empty after popping current peak
    				if (lefts.isEmpty()) {
    					maxLength = Math.max(maxLength, i - pre);
    				} else {
    					maxLength = Math.max(maxLength, i - lefts.peek());
    				}
    			}
    		}
    	}
    	
    	return maxLength;
    }
}
