package backtracing;

public class NQueen {

	static class Position {
		int row, col;

		public Position(int r, int c) {
			// TODO Auto-generated constructor stub
			this.row = r;
			this.col = c;
		}
	}

	public static Position[] solveNQueenProblem() {

		int n = 4;
		Position[] position = new Position[n];
		boolean hasSolution = NqueenRecur(n, position, 0);
		if(hasSolution)
			return position;
		else
			return new Position[0];
	}

	static boolean NqueenRecur(int n, Position[] position, int row) {

		if (row == n)
			return true;

		for (int col = 0; col < n; col++) {
			boolean safe = true;
			for (int queen = 0; queen < row; queen++) {

				if (position[queen].col == col || 
						 (position[queen].row - position[queen].col ==row-col)
						|| (position[queen].col + position[queen].row == col + row)) {

					safe = false;
					break;
				}

			}
			if (safe) {
				position[row] = new Position(row, col);
				//safe = false;
				if(NqueenRecur(n, position, row + 1))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Position[] pos=solveNQueenProblem();
		
		for(Position po:pos) {
			if(po!=null)
				System.out.println(" "+po.row+" "+po.col);
		}
	}
}
