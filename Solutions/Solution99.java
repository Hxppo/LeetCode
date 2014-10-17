/**
 * Max Points on a Line
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

import java.util.*;
import Others.Point;

public class Solution99 {
	/*
	 * Solution: 
	 * y = ax + c
	 * We know that a line can be represented by its slope and intercept.(Double or Float)
	 * In this case, we also have to consider duplicates points with same coordinates.
	 * 
	 * Step:
	 * 1. Each Time a set one point O as the beginning point. If point A & B has the same slope
	 * to O. Then we know A, B and O are at the same line. So our goal is to compute all the lins that 
	 * O is at. And find the line with most points on it. Name it K(O)
	 * 2. All we have to count the number of duplicates here. Suppose the number is n. 
	 * K(O) = K(O) + n
	 * 
	 * We use hashmap for quick access to the slopes
	 */
	
	public int maxPoints(Point[] points) {
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int maxNumber = 0;
		
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int duplicate = 1; // At least the originate point is on the line
			map.put(Double.POSITIVE_INFINITY, 0);
			for (int j = 0; j < points.length; j++) {
				// skip originate points
				if (j == i) continue;
				// count duplicate
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicate++;
					continue;
				}
				// count slope
				double slope = (points[i].x == points[j].x) ? Double.POSITIVE_INFINITY : (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
				if (map.containsKey(slope)){
					map.put(slope, map.get(slope) + 1);
				} else {
					map.put(slope, 1);
				}
				
			}
			// Find the line with most number of points on it
			for (Double x : map.keySet()) {
				maxNumber = Math.max(maxNumber, map.get(x) + duplicate);
			}
		}
		return maxNumber;
	}
}
