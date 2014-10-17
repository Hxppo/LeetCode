import java.util.*;

/**
 * Generate Parenthesis 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author huangxin
 *
 */
public class Solution52 {
	public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) {
        	return res;
        }  
        //construct the input array
        int N = 2 * n;
        String[] input = new String[N];
        for (int i = 0; i < n; i++) {
        	input[i] = "(";
        }
        for (int i = n; i < N; i++) {
        	input[i] = ")";        			
        }
        StringBuffer str = new StringBuffer();
        boolean[] isVisited = new boolean[N];
        int count1 = 0;
        int count2 = 0;
        generate_helper(res, str, input, isVisited, count1, count2);
        return res;
    }
	
	public static void generate_helper(ArrayList<String> res, StringBuffer str, String[] input, 
			boolean[] isVisited, int count1, int count2) {
		//base condition
		if (str.length() == input.length) {
			res.add(str.toString());
		}
		if (count2 > count1) {
			return;
		}
		//depth first search
		String old = null;
		for (int i = 0; i < input.length; i++) {
			if (!isVisited[i] && !input[i].equals(old)) {
				if (input[i].equals("(")) {
					count1++;
				} else {
					count2++;
				} 
				old = input[i];
				str.append(input[i]);
				isVisited[i] = true;
				generate_helper(res, str, input, isVisited, count1, count2);
				isVisited[i] = false;
				str.deleteCharAt(str.length() - 1);
				if (input[i].equals("(")) {
					count1--;
				} else {
					count2--;
				}
			}
		}
	}
	
	public static ArrayList<String> generateParenthesis_recursive(int n) {
		int countLeft = 0;
		int countRight = 0;
		ArrayList<String> res = new ArrayList<String>();
		String str = null;
		generate_recursive_helper(res, str, countLeft, countRight, n);
		return res;
	}
	
	public static void generate_recursive_helper(ArrayList<String> res, String str, 
			int countLeft, int countRight, int n) {
		//base condition
		if (countLeft == n && countRight == n) {
			res.add(str.toString());
			return;
		}

		//three condition
		if (countLeft > countRight) {
			generate_recursive_helper(res, str + "(", countLeft++, countRight, n);
			generate_recursive_helper(res, str + ")", countLeft, countRight++, n);
		} else if (countLeft == countRight) {
			generate_recursive_helper(res, str + "(", countLeft++, countRight, n);
		} else {
			return;
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> res = generateParenthesis(4);
		ArrayList<String> res2 = generateParenthesis(4);
		System.out.println(res);
		System.out.println(res2);
	}
}
