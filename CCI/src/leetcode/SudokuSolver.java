package leetcode;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudoku_backtrack(board);
        return;
    }
    
    public boolean solveSudoku_backtrack(char[][] board) {
        // 1) using back tracking filling the empty cell
        // 2) back tracking to the last valid cell if not (refill '.')
        if (board == null || board.length == 0) return false;
        if (board[0].length != 9 || board.length != 9) return false;
        
        // check cell by cell & number by number
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char) ('0'+k); // try..
                        if (isValid(board, i, j) && solveSudoku_backtrack(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int x, int y) {
        boolean[] flags = new boolean[9]; // all initiated to be false
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[x][i] >= '1' && board[x][i] <= '9') {
                if (!flags[board[x][i]-'1'])
                    flags[board[x][i]-'1'] = true;
                else
                    return false;
            }
        }
        // check column
        flags = new boolean[9]; // reset
        for (int i = 0; i < 9; i++) {
            if (board[i][y] >= '1' && board[i][y] <= '9') {
                if (!flags[board[i][y]-'1'])
                    flags[board[i][y]-'1'] = true;
                else
                    return false;
            }
        }
        
        // check 3x3 block
        flags = new boolean[9]; // reset
        // determine which 3x3 block
        int xx = x/3*3;
        int yy = y/3*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i+xx][j+yy] >= '1' && board[i+xx][j+yy] <= '9') {
                    if (!flags[board[i+xx][j+yy]-'1'])
                        flags[board[i+xx][j+yy]-'1'] = true;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}