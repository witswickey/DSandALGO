/**
 * 
 */
package matrix;

import java.io.IOException;

/**
 * @author limca
 *
 */
public class Rotate90 {

	/**
	 * @param args
	 */
	public static void printM(int a[][]) {
		for (int[] row : a) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void rotate90(int mat[][]) {
		
		int temp;
		int row = 0;
		int N = mat[0].length;
		System.out.println("Row and colums are " + row + " *" + N);
		for (int x = 0; x < N / 2; x++) 
        { 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++) 
            { 
                // store current cell in temp variable 
                temp = mat[x][y]; 
       
                // move values from right to top 
                mat[x][y] = mat[y][N-1-x]; 
       
                // move values from bottom to right 
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                // move values from left to bottom 
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                // assign temp to left 
                mat[N-1-y][x] = temp; 
            } 
        } 
		printM(mat);

	}

	public static void main(String args[]) throws IOException {

		int mat[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

		//int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printM(mat);
		rotate90(mat);
	}
}
