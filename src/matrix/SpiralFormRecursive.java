package matrix;

public class SpiralFormRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int N = 4; 
         
	        // Test Case 1 
	        /*int mat[][] = 
	        { 
	            {1, 2, 3, 4}, 
	            {5, 6, 7, 8}, 
	            {9, 10, 11, 12}, 
	            {13, 14, 15, 16} 
	        }; */
	       
	       
	        // Tese Case 2 
	        /* int mat[][] = { 
	                            {1, 2, 3}, 
	                            {4, 5, 6}, 
	                            {7, 8, 9} 
	                        }; */
	         
	       
	        // Tese Case 3 
	        int mat[][] = { 
	                        {1, 2}, 
	                        {4, 5} 
	                    };
	       
	        // displayMatrix(mat); 
	       
	        //displayMatrix(N,mat); 
	        
	        spiralform(0,mat[0].length-1,mat.length-1,mat[0].length-1,mat); 
	       
	        // Print rotated matrix 
	        //displayMatrix(N,mat); 

	}

	private static void displayMatrix(int n, int[][] mat) {
		// TODO Auto-generated method stub
		for (int[] row : mat) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void spiralform(int r,int c,int row,int col, int[][] mat) {
	
		//System.out.println("row * col->"+row+" * "+col);
		//System.out.println("r * c->"+r+" * "+c);
		if(r<=c) {
			for (int i=r;i<=c;i++) {
				System.out.print(" "+mat[r][i]);
			}
			for (int i=r+1;i<=c;i++) {
				System.out.print(" "+mat[i][c]);
			}
			for (int i=c-1;i>=r;i--) {
				System.out.print(" "+mat[c][i]);
			}
			for (int i=row-1;i>r;i--) {
				System.out.print(" "+mat[i][r]);
			}
			spiralform(r+1,c-1,row-1,col-1,mat);
		}
		else
			return;

		
	}

}
