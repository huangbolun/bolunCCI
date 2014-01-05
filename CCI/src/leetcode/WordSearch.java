package leetcode;

public class WordSearch {
    // DFS+backtracking: http://discuss.leetcode.com/questions/254/word-search
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0 || board.length == 0) return false;
        if (board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (visited[i][j] || board[i][j] != word.charAt(index)) return false;
        if (index == word.length()-1) return true;
        visited[i][j] = true;
        if (i > 0 && dfs(board, i-1, j, word, index+1,visited)) return true;
        if (i < board.length-1 && dfs(board, i+1, j, word, index+1, visited)) return true;
        if (j > 0 && dfs(board, i, j-1, word, index+1, visited)) return true;
        if (j < board[0].length-1 && dfs(board, i, j+1, word, index+1, visited)) return true;
        visited[i][j] = false;
        return false;
    }
}