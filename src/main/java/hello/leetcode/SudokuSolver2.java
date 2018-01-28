package hello.leetcode;

/**
 * Created by pandeyu on 17/12/3.
 */
public class SudokuSolver2 {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)
            return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board, int i, int j)
    {
        if(j>=9)
            return helper(board,i+1,0);
        if(i==9)
        {
            return true;
        }
        if(board[i][j]=='.')
        {
            for(int k=1;k<=9;k++)
            {
                board[i][j] = (char)(k+'0');
                if(isValid(board,i,j))
                {
                    helper(board,i,j+1);
                }
                board[i][j] = '.';
            }
        }
        else
        {
            return helper(board,i,j+1);
        }
        return false;
    }
    private boolean isValid(char[][] board, int i, int j)
    {
        for(int k=0;k<9;k++)
        {
            if(k!=j && board[i][k]==board[i][j])
                return false;
        }
        for(int k=0;k<9;k++)
        {
            if(k!=i && board[k][j]==board[i][j])
                return false;
        }
        for(int row = i/3*3; row<i/3*3+3; row++)
        {
            for(int col=j/3*3; col<j/3*3+3; col++)
            {
                if((row!=i || col!=j) && board[row][col]==board[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(board);
        for(char[] cs : board){
            for(char c : cs){
                System.out.print(c+"|");
            }
            System.out.println();
        }
    }
}
