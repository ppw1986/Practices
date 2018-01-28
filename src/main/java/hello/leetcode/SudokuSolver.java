package hello.leetcode;

/**
 * Created by pandeyu on 17/12/3.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {

        if(board==null || board.length!=9|| board.length!= board[0].length){
            return ;
        }

        help(board,0,0);
    }

    private boolean help(char[][] board, int i, int j) {

        if(j>=9){
            return help(board,i+1,0);
        }

        if(i==9){
            return true;
        }


            if(board[i][j]=='.'){
                for(int k =1 ; k<=9;k++){
                    board[i][j] = (char)(k+48);
                    if(isValid(board,i,j)){
                        if(help(board,i,j+1)){
                            return true;
                        }
                    }
                    board[i][j]='.';
                }
            }else {
                return  help(board,i,j+1);
            }
            return false;
    }

    private boolean isValid(char[][] board, int i, int j) {

        for(int k=0;k<9;k++){
            if(k!=i && board[k][j]==board[i][j]){
                return false;
            }

            if(k!=j && board[i][k]==board[i][j]){
                return false;
            }

        }

        for(int row = i/3*3;row<i/3*3+3;row++){
            for(int col = j/3*3; col<j/3*3+3;col++){
                if(((row!=i)||col!=(j))&&board[row][col]==board[i][j]){
                    return false;
                }
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
                System.out.print(c);
            }
        }
    }
}
