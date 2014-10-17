/**
 * Container With Most Water
 * 
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, 
 * such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * @author huangxin
 */
public class Solution56 {
	
	/*
	 * Solution1:
	 * Time Complexity: O(n^2)
	 * 计算有所可能的container的容量，取最大值
	 * 
	 */	
    public int maxArea_slow(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
        	for (int j = i + 1; j < height.length; j++) {
        		int h = Math.min(height[i], height[j]);
        		int l = j - i;
        		int temp = h * l;
        		if (max < temp) {
        			max = temp;
        		}
        	}
        }
        return max;
    }
    
    /*
     * Solution2:
     * Greedy Algorithm:
     * Use two pointers, one from the start and one from the end of height array
     * Compute the current area, move the smaller pointer to its direction, 
     * until two pointers meet.
     * 其实是保证每个固定间距的两index对应的是第一以及第二高的边界 
     * Time Complexity: O(n) linear time algorithm
     */
    public int maxArea(int[] height) {
    	int max = 0;
    	if (height.length < 2) {
    		return max;
    	}
    	int left = 0;
    	int right = height.length - 1;
    	
    	while(left < right) {
    		int temp = (right - left) * Math.min(height[left], height[right]);
    		if (temp > max) {
    			max = temp;
    		}
    		if (height[left] < height[right]) {
    			left++;
    		} else {
    			right--;
    		}
    	}
    	return max; 			
    }
}
