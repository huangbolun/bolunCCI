package microsoftCodeChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sudoku {
	
	public static void main(String[] args) throws IOException {
		Sudoku mySolver = new Sudoku();
		BufferedReader br = new BufferedReader(new FileReader("C://Users//Bolun//Downloads//ScoringInputs//Sudoku//ActualInput.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C://Users//Bolun//Desktop//jobhunting//microsoft//CodeCompetitionForStudents//SampleOutputs//SudokuOutput.txt"));
		char[][] board = new char[9][9];
		int linenum = 0;
		String line;
		while ((line = br.readLine()) != null) {
			if (line.equals("")) {
				board = new char[9][9]; // reset
				linenum = 0; // reset
				continue;
			}
			// read from file
			String[] cells = line.split(" ");
			for (int j = 0; j < cells.length; j++) {
				//System.out.println(cells[j]);
				board[linenum][j] = cells[j].charAt(0);
				//System.out.print(cells[j]+" ");
			}
			//System.out.println();
			linenum += 1;
			if (linenum == 9) {
				System.out.println("!");
				// done with reading the sudoku
				// solve it and write to file
				// solve sudoku
				mySolver.solveSudoku(board);
				// write to file
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (j == 0) bw.append(board[i][j]);
						else bw.append(" "+board[i][j]);
						//System.out.print(board[i][j]+" ");
					}
					bw.append("\r\n"); // space line
				}
				bw.append("\r\n");
			}
		}
		br.close();
		bw.close();
	}
	
	
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
                if (board[i][j] == 'x') {
                    for (int k = 1; k <= 9; k++) {
                        board[i][j] = (char) ('0'+k); // try..
                        if (isValid(board, i, j) && solveSudoku_backtrack(board)) {
                            return true;
                        }
                        board[i][j] = 'x';
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