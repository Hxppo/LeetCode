import java.util.*;

/**
 * Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * @author huangxin
 *
 */
public class Solution40 {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
        	return result;
        }
        
    	ArrayList<Integer> row = new ArrayList<Integer>();
    	row.add(1);
    	result.add(row);
    	
        if (numRows == 1) {
        	return result;
        } else if (numRows == 2) {
        	row = new ArrayList<Integer>();
        	row.add(1);
        	row.add(1);
        	result.add(row);
        	return result;
        } else {
        	row = new ArrayList<Integer>();
        	row.add(1);
        	row.add(1);
        	result.add(row);   	
        	
        	for (int level = 2; level < numRows; level++) {
        		row = new ArrayList<Integer>();
            	row.add(1);
        		for (int i = 1; i < level; i++) {
        			int left = result.get(level - 1).get(i - 1);
        			int right = result.get(level- 1).get(i);
        			row.add(left + right);
        		}
        		row.add(1);       		
        		result.add(row);
        	}
        	
        	return result;
        }
    }
    
    public static void main(String[] args) {
    	generate(4);
    }
}
