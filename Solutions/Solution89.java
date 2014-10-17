/**
 * Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 */
import Others.Interval;
import java.util.*;

public class Solution89 {
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
        		newInt.end = Math.max(newInt.end, curInt.end);
        		result.add(newInt);
        	}
        }
        
        return result;
    }
}

