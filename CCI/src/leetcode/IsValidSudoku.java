package leetcode;

import java.util.HashSet;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) return false;
        for (int i = 0; i < 9; i++) {
            HashSet<String> set = new HashSet<String>();
            for (int j = 0; j < 9; j++) {
                if (!String.valueOf(board[i][j]).equals(".")) {
                    if (!set.contains(String.valueOf(board[i][j]))) {
                        set.add(String.valueOf(board[i][j]));
                    } else {
                        return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            HashSet<String> set = new HashSet<String>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] <= 57 && board[j][i] >= 49) {
                    if (!set.contains(String.valueOf(board[j][i]))) {
                        set.add(String.valueOf(board[j][i]));
                    } else {
                        return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<String> set = new HashSet<String>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i+k][j+l] <= 57 && board[i+k][j+l] >= 49) {
                            if (!set.contains(String.valueOf(board[i+k][j+l]))) {
                                set.add(String.valueOf(board[i+k][j+l]));
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}