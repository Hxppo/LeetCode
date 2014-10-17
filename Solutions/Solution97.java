/**
 * Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * @author huangxin
 *
 */
import java.util.*;

public class Solution97 {
	/*
	 * 解题思路1：暴力循环算法或者通过分治法实现。时间负责度分别为O(n^2) or O(nlogn)
	 * 解题思路2：通过维护一个递增的栈实现计算。具体步骤如下：
	 * For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle.
	 * If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. 
	 * We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. 
	 * Let us call these indexes as ‘left index’ and ‘right index’ respectively.
	 * 1) Create an empty stack.
	 * 2) Start from first bar, and do following for every bar ‘hist[i]‘ where ‘i’ varies from 0 to n-1.
	 *	  a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
	 *	  b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp].
	 *	     Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
	 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
	 * 
	 * Time Complexity: O(n)
	 */
	
    public static int largestRectangleArea(int[] height) {
        int maxArea = 0;
        // Create a stack to hold indexes of height[] array
        Stack<Integer> stack = new Stack<Integer>();
        int topIndex; // To store top of stack
        int areaWithTop; // To store top bar as the smallest bar 
        
        
        // Scan through all bars of given histograms
        int i = 0;
        for (i = 0; i < height.length;) {
        	if (stack.empty() || height[i] >= height[stack.peek()]) {
        		stack.push(i++);
        	} else {
        		// If this bar is lower than top of stack, then calculate are of rectangle
        		// with stack top as the smallest bar. 'i' is 
        		// the right index for the top and element before top in stack is left index
        		topIndex = stack.pop();
        		areaWithTop = height[topIndex] * (stack.empty()? i + 1: i - stack.peek() - 1);
        		
        		// update max area if needed
        		if (maxArea < areaWithTop) {
        			maxArea = areaWithTop;
        		}
        	}
        }
        
        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
        while (!stack.empty()) {
        	topIndex = stack.pop();
        	areaWithTop = height[topIndex] * (stack.empty() ?  i : topIndex - stack.peek());
        	if (maxArea < areaWithTop) {
    			maxArea = areaWithTop;
    		}
        }
        	
        
    	return maxArea;
    }
	
	public static void main(String[] args) {
		int[] test = {1, 1};
		System.out.println(largestRectangleArea(test));
	}
}
