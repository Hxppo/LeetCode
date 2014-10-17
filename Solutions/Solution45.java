import java.util.*;

/**
 * Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author huangxin
 *
 */

public class Solution45 {
	/*
	 * 解题思路1：计数排序算法
	 * 需要扫描两遍数组 two pass
	 * 时间复杂度和空间复杂度都是 O(n)
	 */
    public void sortColors1(int[] A) {
        ArrayList<ArrayList<Integer>> count =  new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 3; i++) {
        	count.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < A.length; i++) {
        	if (A[i] == 0) {
        		count.get(0).add(0);
        	} else if (A[i] == 1) {
        		count.get(1).add(1);
        	} else {
        		count.get(2).add(2);
        	}
        }
        int size0 = count.get(0).size();
        int size1 = count.get(1).size();
        int size2 = count.get(2).size();
        
        for (int i = 0; i < size0; i++) {
        	A[i] = 0;
        }
        for (int i = size0; i < size0 + size1; i++) {
        	A[i] = 1;
        }
        for (int i = size0 + size1; i < size0 + size1 + size2; i++) {
        	A[i] = 2;
        }
    }
    
    /*
     * 解法2：考虑题目要求one pass，这意味着类似于链表的双指针问题。
     * 需要track两个index：
     * 1） index1 记录1元素的开始
     * 2） index2 记录1元素的结束
     * 如果p3指向的元素为0，那么交换p3和p1位置的元素。因为刚刚的定义，所以我们总是能够保证交换过来的元素是1，那这样的话我们就p1++,p3++。
     * 如果p3指向的元素是2，那么我们交换p2和p3指向的元素，p2--，但是p3不变，因为我们不知道交换过来的是什么元素。
	 * 这样遍历一边数组之后，就能够得到我们想要的结果了。
     */
    
    public static void sortColors(int[] A) {
    	int index1 = 0;
    	int index2 = A.length - 1;
    	int index3 = 0;
    	
    	for (index3 = 0; index3 <= index2;) {
    		if (A[index3] == 1) {
    			index3++;
    		} else if (A[index3] == 2) {
    			A[index3] = A[index2];
    			A[index2--] = 2;
    		} else if (A[index3] == 0) {
    			A[index3++] = 1;
    			A[index1++] = 0;
    		}
    	}	
    }
    
    public static void main(String[] args) {
    }
}
