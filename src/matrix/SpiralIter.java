package matrix;

import java.util.LinkedList;

public class SpiralIter {

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
	        int mat[][] = { 
	                            {1, 2, 3}, 
	                            {4, 5, 6}, 
	                            {7, 8, 9} 
	                        }; 
	        
	        //*/
	         
	       
	        // Tese Case 3 
	       /* int mat[][] = { 
	                        {1, 2}, 
	                        {4, 5} 
	                    };*/
	       
	        // displayMatrix(mat); 
	       
	        //displayMatrix(N,mat); 
	        
	        spiralInterative(mat.length-1,mat[0].length-1,mat); 
	       
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

	private static void spiralInterative(int row,int col, int[][] mat) {
	
		int i=0;
		int j=col;
		System.out.println(String.format("starting row %s and col are %s",i,j));
		int k=0;
		LinkedList<Integer> ls=new LinkedList<Integer>();
		while(i<=j) {
			
			for( k=i;k<=j;k++) {
			ls.add(mat[i][k]);
				
			}
			for( k=i+1;k<j;k++) {
			ls.add(mat[k][j]);
				
			}
			for( k=j;k>=i;k--) {
			ls.add(mat[j][k]);
				
			}
			for( k=j-1;k>0;k--) {
			ls.add(mat[k][i]);
				
			}
			i++;
			j--;
			//row--;
			
		}
		
		for(int n:ls) {
			System.out.print(" "+n);
		}
		
		
	}

}