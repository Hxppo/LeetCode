/**
 * Remove Element 
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author huangxin
 *
 */
public class Solution20 {
    public static int removeElement(int[] A, int elem) {
        int size = A.length;        
    	for (int i = 0; i < size; ) {
    		if (A[i] != elem) {
        		i++;
        	} else {
        		for (int j = i + 1; j < size; j++) {
        			A[j - 1] = A[j];
        		}
        		size--;
        	}
        }
        return size;
    }
    
    public static void main(String[] args) {
    	int[] test = {};
    	System.out.println(removeElement(test, 4));
    }
    
}
