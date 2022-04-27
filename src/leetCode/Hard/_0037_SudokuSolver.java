package leetCode.Hard;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class _0037_SudokuSolver {
	public void solveSudoku(char[][] board) {
		List<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
		List<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
		List<HashSet<Character>> boxes = new ArrayList<HashSet<Character>>();
		
		init(rows, cols, boxes, board); // Use board to initialize rows, cols, boxes
		solveBacktrack(rows, cols, boxes, board, 0, 0);
	}
	
	void init(List<HashSet<Character>> rows, List<HashSet<Character>> cols, List<HashSet<Character>> boxes, char[][] board) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			rows.add(new HashSet<Character>());
			cols.add(new HashSet<Character>());
			boxes.add(new HashSet<Character>());
		}
		
		// Iterate over the board and initialize values in each HashSet
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] == '.') continue; // Ensure not empty
				char val = board[r][c];
				int boxId = getBoxId(r, c);
				
				// Add value to rows, cols, boxes
				rows.get(r).add(val);
				cols.get(c).add(val);
				boxes.get(boxId).add(val);
			}
		}
	}
	
	int getBoxId(int row, int col) {
		int colVal = col / 3; // integer division is intentional
		int rowVal = (row / 3) * 3;
		return colVal + rowVal;
	}
	
	boolean solveBacktrack(List<HashSet<Character>> rows, List<HashSet<Character>> cols, List<HashSet<Character>> boxes, char[][] board, int r, int c) {
		if (r == board.length || c == board.length) return true;

		if (board[r][c] == '.') {
			// Iterate over all possible number values and try adding them into the board
			for (char val = '1'; val <= '9'; val++) {
				board[r][c] = val;
				int boxId = getBoxId(r, c);
				HashSet<Character> row = rows.get(r);
				HashSet<Character> col = cols.get(c);
				HashSet<Character> box = boxes.get(boxId);
				if (isValid(row, col, box, val)) {
					row.add(val);
					col.add(val);
					box.add(val);
					// If at end of column, shift to next row
					if (c == board.length - 1) {
						if (solveBacktrack(rows, cols, boxes, board, r + 1, 0)) {
							return true;
						}
					} else {
						if (solveBacktrack(rows, cols, boxes, board, r, c + 1)) {
							return true;
						}
					}
					row.remove(val);
					col.remove(val);
					box.remove(val);
				}
				board[r][c] = '.';
			}
		} else {
			if (c == board.length - 1) {
				if (solveBacktrack(rows, cols, boxes, board, r + 1, 0)) {
					return true;
				}
			} else {
				if (solveBacktrack(rows, cols, boxes, board, r, c + 1)) {
					return true;
				}
			}
		}

		return false;
	}
	
	boolean isValid(HashSet<Character> row, HashSet<Character> col, HashSet<Character> box, char val) {
		// A value is valid if none of the sets contain the value
		return !(row.contains(val) || col.contains(val) || box.contains(val));
	}
}

// Java Questions
//   How do you declare a 2-D array? An n-D array?
//   How does integer division work?
//   Do both numbers have to be integers in order
//     for integer division to occur?
//   How do you declare and initialize a HashSet
//     in Java?
//   How do you shuffle an array in Java?
//   How do you:
//     - Map
//     - Filter
//     - Reduce
//     - Find
//     in Java?
//   Will Java allow the following declaration? 
//     HashSet<Character>[] rows = new HashSet<Character>[9];
//   Will Java allow the following declaration?
//     HashSet<Character>[] rows;
//   Will Java allow the following declaration?
//     ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
//   Will Java allow the following declaration?
//     HashSet<?>[] rows = new HashSet<?>[9];
//   What is the HashSet method for checking whether it has a value?
//     HashSet.contains(T value)
//   How can we convert an integer to its representative character?
//     Character.forDigit(i, RADIX) -- RADIX is required
//   Can we loop over characters directly?
//     Yes
//     for (char c = '1'; c <= '9'; c++) {...}
//
