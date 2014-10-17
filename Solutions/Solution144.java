/**
 * Word Ladder II
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
 * such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * @author huangxin
 *
 */
import java.util.*;

public class Solution144 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (dict.isEmpty()) return res;
        
        dict.add(new String(end));
        ArrayList<String> buffer = new ArrayList<String>();
        int[] minDis = {Integer.MAX_VALUE};
        
       findDFS(start, end, dict, res, buffer, start, minDis, 0);
       
       // compute output 
       if (res.isEmpty()) return res;
       int minLength = Integer.MAX_VALUE;
       for (ArrayList<String> list : res) {
    	   minLength = Math.min(minLength, list.size());
       }

       ArrayList<ArrayList<String>> resSet = new ArrayList<ArrayList<String>>();
       for (ArrayList<String> list : res) {
    	   if (list.size() == minLength) {
    		   resSet.add(new ArrayList<String>(list));
    	   }
       }

       
       return resSet;
    }
    
    private static void findDFS(String start, String end, HashSet<String> dict,
    		ArrayList<ArrayList<String>> res, ArrayList<String> buffer, String pre, int[] minDis, int distance) {
    	// base condition
    	if (minDis[0] < distance) {
    		return;
    	}
    	
    	if (pre.equals(end)) {
    		res.add(new ArrayList<String>(buffer));
    		minDis[0] = Math.min(minDis[0], distance);
    		return;
    	}
    	
    	// DFS
		for (int i = 0; i < pre.length(); i++) {
			char[] curCharArray = pre.toCharArray();
			for (char digit = 'a'; digit <= 'z'; digit++) {
				curCharArray[i] = digit;
				String newWord = new String(curCharArray);
				// if dict contains it, then it is valid 
				if (dict.contains(newWord)) {
					dict.remove(newWord);
					buffer.add(newWord);
					findDFS(start, end, dict, res, buffer, newWord, minDis, distance + 1);
					dict.add(newWord);
					buffer.remove(buffer.size() - 1);
				}
			}
		}
    }
    
    public static void main(String[] args) {
    	/*
		String start = "hit";
    	String end = "cog";
    	String[] test = {"hot","dot","dog","lot","log"};
    	*/
    }
}
