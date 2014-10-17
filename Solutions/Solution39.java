import java.util.*;
/**
 * Gray Code
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * @author huangxin
 *
 */
public class Solution39 {
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int bound = 1 << n;
        for (int i = 0; i < bound; i++) {
        	result.add(i ^ (i >> 1));
        }
        return result;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list = grayCode(3);
    	for (int i = 0; i < list.size(); i++) {
    		System.out.println(list.get(i));
    	}
    	
    }
}
