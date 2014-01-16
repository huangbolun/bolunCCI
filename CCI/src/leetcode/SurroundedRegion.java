package leetcode;

public class SurroundedRegion {
    public void solve(char[][] board) {
        int width = board.length;
        if (width <= 2) return;
        int length = board[0].length;
        if (length <= 2) return;
        // recolor the 'O's on the border
        for (int i = 0; i < width; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#'; // on the border
            }
            if (board[i][board[i].length-1] == 'O') {
                board[i][board[i].length-1] = '#'; // on the border
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '#'; // on the border
            }
            if (board[board.length-1][i] == 'O') {
                board[board.length-1][i] = '#'; // on the border
            }
        }
        // dfs from #
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '#') {
                    if (i+1<width && board[i+1][j] == 'O') {
                        dfs(board, i+1, j);
                    }
                    if (i-1>= 0 && board[i-1][j] == 'O') {
                        dfs(board, i-1, j);
                    }
                    if (j+1<length && board[i][j+1] == 'O') {
                        dfs(board, i, j+1);
                    }
                    if (j-1>=0 && board[i][j-1] == 'O') {
                        dfs(board, i, j-1);
                    }
                }
            }
        }
        // re-color
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '#' || board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = 'B'; // re-color
            if (x+1<board.length && board[x+1][y] == 'O') {
                dfs(board, x+1, y);
            }
            if (x-1>=0 && board[x-1][y] == 'O') {
                dfs(board, x-1, y);
            }
            if (y-1>=0 && board[x][y-1] == 'O') {
                dfs(board,x,y-1);
            }
            if (y+1<board[0].length && board[x][y+1] == 'O') {
                dfs(board,x,y+1);
            }
            return;
        } else { // need not to expand
            return;
        }
    }
}