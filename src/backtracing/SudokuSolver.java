package backtracing;

public class SudokuSolver {

	static class position {
		int r;
		int c;

		public position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static boolean solveSudoku(int[][] board, int n) {

		int row = 0;
		int col = 0;

		return solveSudokuUtil(board, n);

	}

	private static boolean solveSudokuUtil(int[][] board, int n) {

		position pos = findnextpostion(board, n);
		int ro = pos.r;
		int co = pos.c;
		if (ro == -1 && co == -1)
			return true;
		else {
		

			for (int s = 1; s <= 9; s++) {
				if (isValidSudoku(board, ro, co, s)) {
					board[ro][co] = s;

					if (solveSudokuUtil(board, n)) {
						print(board, n);
						System.out.println();
						return true;
					}
				 else
					board[ro][co] = 0;
				}
			}
		}
			return false;
		

		
	}

	private static boolean isValidSudoku(int[][] board, int row, int col, int num) {

		for (int d = 0; d < board.length; d++) {
			// if the number we are trying to
			// place is already present in
			// that row, return false;
			if (board[row][d] == num) {
				return false;
			}
		}

		// column has the unique numbers (column-clash)
		for (int r = 0; r < board.length; r++) {
			// if the number we are trying to
			// place is already present in
			// that column, return false;

			if (board[r][col] == num) {
				return false;
			}
		}

		// corresponding square has
		// unique number (box-clash)
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

		// if there is no clash, it's safe
		return true;
	}

	private static position findnextpostion(int[][] board, int n) {

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (board[i][j] == 0) {
					return new position(i, j);

				}
			}

		}
		return new position(-1, -1);

	}

	public static void main(String args[]) {

		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int N = board.length;

		if (solveSudoku(board, N)) {
			// print solution
			print(board, N);
		} else {
			System.out.println("No solution");
		}
	}

	public static void print(int[][] board, int N) {
		// we got the answer, just print it
		for (int r = 0; r < N; r++) {
			for (int d = 0; d < N; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

}