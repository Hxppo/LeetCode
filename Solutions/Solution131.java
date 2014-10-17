/**
 * Sudoku Solver
 * @author huangxin
 *
 */
public class Solution131 {
	public void solveSudoku(char[][] board) {
        helper(board);
    }
	
    public boolean helper(char[][] board){
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]=='.'){
                    for(int k=1;k<10;k++){
                        board[i][j]=(char)(k+'0');
                        if(isValid(board,i,j)&&helper(board))
                            return true;
                    }
                    board[i][j]='.';
                    return false;
                }
        return true;
                    
    }
    
    public boolean isValid(char[][] board, int row,int col){
        //check row
        char num=board[row][col];
        for(int i=0;i<9;i++){
            if(i==row) continue;
            if(num==board[i][col])
                return false;
        }
        //check column
        for(int j=0;j<9;j++){
            if(j==col) continue;
            if(num==board[row][j])
                return false;
        }
        //check cubic
        int a=row/3*3;
        int b=col/3*3;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(a+i==row&&b+j==col) continue;
                if(num==board[a+i][b+j])
                    return false;
        }
        return true;
    }
}
