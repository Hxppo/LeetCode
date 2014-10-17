/**
 * Word Search 
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once
 * @author huangxin
 *
 */
public class Solution138 {
	// Solution1: Recursive Solution
	// We perform DFS at each element and treat the matrix as a graph
	public static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		
		boolean[][]	isVisited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (existDFS(board, word, 0, i, j, isVisited)) return true;
			}
		}
		
        return false;
    }
	
	private static boolean existDFS(char[][] board, String word,int index, int row, int col, boolean[][] isVisited) {
		// base conditions:
		// 1> we hit the result 
		if (index == word.length()) return true;	
		// 2> Boundary of this matrix, we have hit the end of the graph
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
		// 3> This element has been visited, we can not use it another time
		if (isVisited[row][col]) return false;
		// 4> This char doesn't match according char
		if (board[row][col] != word.charAt(index)) return false;
		
		// In all other cases, we can continue our search 
		isVisited[row][col] = true;
		// we can search in four directions
		if (existDFS(board, word, index + 1, row, col - 1, isVisited)) return true;	// left
		if (existDFS(board, word, index + 1, row, col + 1, isVisited)) return true; // right
		if (existDFS(board, word, index + 1, row - 1, col, isVisited)) return true; // up
		if (existDFS(board, word, index + 1, row + 1, col, isVisited)) return true; // down
		
		// clean up site
		isVisited[row][col] = false;
		
		return false;
	}
	

}
