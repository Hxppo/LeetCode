/**
 * Merge Intervals
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

import java.util.*;
import Others.Interval;

public class Solution90 {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        result.add(newInterval);
        
        for (int i = 0; i < intervals.size(); i++) {
        	Interval curInt = intervals.get(i);
        	Interval newInt = result.get(result.size() - 1);
        	result.remove(result.size() - 1);
        	// new Interval is at the left side of newInt
        	if (curInt.end < newInt.start) {
        		result.add(curInt);
        		result.add(newInt);
        	} else if (newInt.end < curInt.start) {
        		result.add(newInt);
        		result.add(curInt);
        	} else {
        		// merge operation happens under all other conditions
        		newInt.start = Math.min(newInt.start, curInt.start);
        		newInt.end = Math.max(newInt.end, newInt.end);
        		result.add(newInt);
        	}
        }
        
        return result;
    }
	
	public ArrayList<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
        	return result;
        }
        
        
        for (int i = 0; i < intervals.size(); i++) {
        	//Interval curInt = intervals.get(i);
        	result = insert(result, intervals.get(i));
        }
        
        return result;
    }
	
	public static void main(String args[]) {
		Solution90 test = new Solution90();
		ArrayList<Interval> intervals = new ArrayList<Interval>(2);
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 1));
		test.merge(intervals);
	}
}
