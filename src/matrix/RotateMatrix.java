package matrix;

import java.io.IOException;

public class RotateMatrix {
	public static void printM(int a[][]) {
		for (int[] row : a) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rotate(int a[][]) {
		
		int temp;
		int row = 0;
		int col = a[0].length-1;
		System.out.println("Row and colums are " + a.length + " *" + col);
		while (row < col) {
			int broken = a[row][row];
			for (int i = row; i < col; i++) {
				temp = a[row][i + 1];
				a[row][i + 1] = broken;
				broken = temp;
			}
			printM(a);
			for (int i = row; i < col; i++) {
				temp = a[i + 1][col];
				a[i + 1][col] = broken;
				broken = temp;
			}
			printM(a);
			for (int i = col; i >row; i--) {
				temp = a[col][i - 1];
				a[col][i - 1] = broken;
				broken = temp;
			}
			printM(a);
			for (int i = col; i > row; i--) {
				temp = a[i - 1][row];
				a[i - 1][row] = broken;
				broken = temp;
			}
			row++;
			col--;
			printM(a);

		}

	}

	public static void main(String args[]) throws IOException {

		//int mat[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printM(mat);
		rotate(mat);
	}
}
