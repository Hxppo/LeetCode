/**
 * Valid Sudoku 
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * 
 */
public class Solution67 {
	   public boolean isValidSudoku(char[][] board) {
	    	if(!checkColumn(board)) {
	    		return false;
	    	}
	    	if(!checkRow(board)) {
	    		return false;
	    	}
	    	for(int x = 0; x <= 6;) {
	    		for(int y = 0; y <= 6;) {
	    			if(!checkSquare(board, x, y)) {
	    				return false;
	    			}
	    			y += 3;
	    		}
	    		x += 3;
	    	}
	    	
	    	
	    	return true;
	    }
	    
	    private boolean checkColumn(char[][] arr) {
	    	for(int i = 0; i < arr.length; i++) {
	    		boolean[] count = new boolean[arr.length + 1];
	    		for(int j = 0; j < arr.length; j++) {
	    			if(arr[i][j] != '.') {
	    				if(count[Integer.parseInt("" + arr[i][j])]) {
		    				return false;
		    			} else {
		    				count[Integer.parseInt("" + arr[i][j])] = true;
		    			}
	    			}
	    			
	    		}
	    	}
	    	return true;
	    }
	    
	    private boolean checkRow(char[][] arr) {
	    	for(int j = 0; j < arr.length; j++) {
	    		boolean[] count = new boolean[arr.length + 1];
	    		for(int i = 0; i < arr.length; i++) {
	    			if(arr[i][j] != '.') {
	    				if(count[Integer.parseInt("" + arr[i][j])]) {
		    				return false;
		    			} else {
		    				count[Integer.parseInt("" + arr[i][j])] = true;
		    			}
	    			}
	    		}
	    	}
	    	return true;
	    }
	    
	    private boolean checkSquare(char[][] arr, int x, int y) {
	    	boolean[] count = new boolean[arr.length + 1];
	    	for(int i = x; i < 3 + x; i++) {
	    		for(int j = y; j < 3 + y; j++) {
	    			if(arr[i][j] != '.') {
	    				if(count[Integer.parseInt("" + arr[i][j])]) {
		    				return false;
		    			} else {
		    				count[Integer.parseInt("" + arr[i][j])] = true;
		    			}
	    			}
	    		}
	    	}
	    	return true;
	    }
}
