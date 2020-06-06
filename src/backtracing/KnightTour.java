package backtracing;

public class KnightTour {

	public static void main(String[] args) {
		new KnightTour().solveKnightTour();
	}

	private void solveKnightTour() {

		int[][] board = new int[8][8];

		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = -1;
			}
		}
		PrintBoard(board, row, col);
		System.out.println();
		/*
		 * xMove[] and yMove[] define next move of Knight. xMove[] is for next value of
		 * x coordinate yMove[] is for next value of y coordinate
		 */
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		
		board[0][0]=0;

		boolean hasSolution = solveKT(board, 0, 0, xMove, yMove, 1);
		if (hasSolution) {
			PrintBoard(board, row, col);
		} else {
			System.out.println("No Solution");
		}

	}

	private boolean solveKT(int[][] board, int row, int col, int[] xMove, int[] yMove, int count) {

		if(count==64)
			return true;

		for (int i = 0; i < 8; i++) {
			int newro = row + xMove[i];
			int newco = col+ yMove[i];

			if (isSafeCordinates(board, newro, newco)) {
				board[newro][newco] = count;
				if (solveKT(board, newro, newco, xMove, yMove, count + 1)) {
					PrintBoard(board, row, col);
					System.out.println();
					return true;
				}
				else
					board[newro][newco] = -1;
			} 
		}
		return false;

	}

	boolean isSafeCordinates(int[][] board, int x, int y) {

		return (x >= 0 && x < 8 && y >= 0 && 
                y < 8 && board[x][y] == -1); 
	}

	boolean isBoardFull(int[][] board) {

		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == -1) {
					return false;
				}
			}
		}
		return true;

	}

	private static void PrintBoard(int[][] board, int row, int col) {
		for (int r = 0; r < row; r++) {
			for (int d = 0; d < col; d++) {
				System.out.print(board[r][d]);
				System.out.print(" ");
			}
			System.out.print("\n");

			if ((r + 1) % (int) Math.sqrt(row) == 0) {
				System.out.print("");
			}
		}

	}

}
