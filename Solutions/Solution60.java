import java.util.*;
/**
 * 
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author huangxin
 */
public class Solution60 {
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (rowIndex < 0) {
        	return res;
        } else if (rowIndex == 0) {
        	res.add(1);
        	return res;
        } else if (rowIndex == 1) {
        	res.add(1);
        	res.add(1);
        	return res;
        } else {
        	int level = 1;
        	ArrayList<Integer> pre = new ArrayList<Integer>();
        	pre.add(1);
        	pre.add(1);
        	
        	while(level <= rowIndex) {
        		level++;
        		res.add(1);
        		for (int i = 1; i < level - 1; i++) {
        			int left = pre.get(i - 1);
        			int right = pre.get(i);
        			res.add(left + right);				
        		}
        		res.add(1);
        		pre = res;
        		res = new ArrayList<Integer>();
        	}
        	return pre;
        }
    }
    
    public static void main(String[] args) {
    	System.out.print(getRow(0));
    }
}
