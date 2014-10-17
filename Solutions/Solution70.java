import java.util.*;

/**
 * Longest Consecutive Sequence 
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * @author huangxin
 *
 */
public class Solution70 {
	/*
	 * 常规思路：
	 * 对数组排序。从头向尾扫描：
	 * 1. A[i] == A[i -1] 
	 * 特殊情况，需要跳过重复元素。当前连续递增数组长度不变
	 * 2. A[i] == A[i -1] + 1
	 * 可以加入当前连续序列中，当前从序列长度加1
	 * 3. A[i] > A[i - 1] + 1
	 * 说明前一连续序列已计算完，与maxLength比较，确定是否需要更新最长连续数组长度
	 * 
	 * 编程时应该注意：
	 * 1. 对首元素单独考虑以免数组越界
	 * 2. 对最后一个连续序列长度无法更新，因为更新出现在A[i] > A[i - 1] + 1
	 * 所以应对最后一个连续序列的长度，补一次比较
	 * 
	 * Solution的解题方法：Hashtable
	 * Note：牢记在数组类型题目内对于需要减少查找的时间常用hashtable空间换时间
	 * 
	 * 解题思路2：
	 * Since it requires O(n) solution, normal sort won't be work here. Hash probably is the best choice.
     * 3 Steps:
     * 1. create the hashmap to hold <num, index>
	 * 2. scan the num vector from left to right, for each num
     *         i, check whether num -1 is in the map  (loop)
     *        ii, check whether num+1 is in the map  (loop)
	 * 3. track the sequence length during scanning. 
	 *
	 * 向上增长，增加序列长度
	 * 向下增长，增加序列长度
	 * 
	 * 存贮isVisited[n]数组避免反复计算同一序列的长度，从而降低时间复杂度
	 * 
	 *
	 */
    public static int longestConsecutive(int[] num) {
        boolean isVisited[] = new boolean[num.length];
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>(num.length); 
        
        //store data into table
        for(int i = 0; i < num.length; i++) {
        	table.put(num[i], i); 
        }
        
        int maxLength = Integer.MIN_VALUE;

        
        for(int i = 0; i < num.length; i++) {
        	if(isVisited[i]) {
        		continue;
        	}
        	int curLength = 1;
        	
        	int current = num[i] + 1;
        	//scan from upper level
        	while(table.containsKey(current)) {
        		isVisited[table.get(current)] = true;
        		current++;
        		curLength++;
        	}  
        	
        	current = num[i] - 1;
         	//scan down to lower level
        	while(table.containsKey(current)) {
        		isVisited[table.get(current)] = true;
        		current--;
        		curLength++;
        	}
        	//Update the maxLength
        	if(curLength > maxLength) {
        		maxLength = curLength;
        	}
        } 
    	return maxLength;
    }
    
    public static void main(String[] args) {
    	int[] test = {4, 3, 2, 1};
    	System.out.println(longestConsecutive(test));
    }
}
