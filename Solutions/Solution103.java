/**
 * Evaluate Reverse Polish Notation
 * 
 * 对于逆波兰式，一般都是用栈来处理，依次处理字符串，
 * 如果是数值，则push到栈里面
 * 如果是操作符，则从栈中pop出来两个元素，计算出值以后，再push到栈里面，
 * 则最后栈里面剩下的元素即为所求。
 * @author huangxin
 *
 */
import java.util.*;

public class Solution103 {
	public static int evalRPN(String[] tokens) {  
        Stack<String> stack = new Stack<String>();  
        for(int i=0; i<tokens.length; i++){  
            if(tokens[i].equals("+")){  
                int val = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());  
                stack.push(String.valueOf(val));  
            }else if(tokens[i].equals("-")){  
                int v1 = Integer.parseInt(stack.pop());  
                int v2 = Integer.parseInt(stack.pop());  
                int val = v2 - v1;  
                stack.push(String.valueOf(val));  
            }else if(tokens[i].equals("*")){  
                int val = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());  
                stack.push(String.valueOf(val));  
            }else if(tokens[i].equals("/")){  
                int v1 = Integer.parseInt(stack.pop());  
                int v2 = Integer.parseInt(stack.pop());  
                int val = v2 / v1;  
                stack.push(String.valueOf(val));  
            }else{  
                stack.push(tokens[i]);  
            }  
        }  
          
        return Integer.parseInt(stack.pop());  
    }
	
	public static void main(String[] args) {
		String[] test = {"0","3","/"};
		System.out.println(evalRPN(test));
	}
}
