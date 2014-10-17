import java.util.*;

/**
 * N-Queens I
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * @author huangxin
 *
 */
public class Solution59 {
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        return solveNQueensHelper(new long[n], res, 0, 0, 0, 0);
    }
	
	private ArrayList<String[]> convertSolution(long[] rows, ArrayList<String[]> res) {
		String[] temp = new String[rows.length];
		for (int i = 0; i < rows.length; i++) {
			temp[i] = Long.toBinaryString(rows[i])
					.replace('0', '.')
					.replace('1', 'Q');
			while(temp[i].length() < rows.length) {
				temp[i] = "." + temp[i]; 
			}
		}
		res.add(temp);
		return res;
	}
	
	private ArrayList<String[]> solveNQueensHelper(long[] rows, ArrayList<String[]> result, int level,
			long row, long ld, long rd) {
		long upper = (1 << rows.length) - 1;
		if (row == upper) {
			convertSolution(rows, result);
		} else {
			long position = upper & (~(row | ld | rd));
			while (position != 0) {
				long p = position & (-position);
				position -= p;
				rows[level] = p;
				solveNQueensHelper(rows, result, level + 1, row + p, (ld  + p) << 1, (rd + p) >> 1);
			}
		}
		return result;
	}
}
