package dp;

import java.util.Arrays;

//A Naive recursive Java program to find minimum number 
//operations to convert str1 to str2 
public class EDIST {
	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	static int editDist(String str1, String str2, int m, int n) {
		// If first string is empty, the only option is to
		// insert all characters of second string into first
		if (m == 0)
			return n;

		// If second string is empty, the only option is to
		// remove all characters of first string
		if (n == 0)
			return m;

		// If last characters of two strings are same, nothing
		// much to do. Ignore last characters and get count for
		// remaining strings.
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return editDist(str1, str2, m - 1, n - 1);

		// If last characters are not same, consider all three
		// operations on last character of first string, recursively
		// compute minimum cost for all three operations and take
		// minimum of three values.
		return 1 + min(editDist(str1, str2, m, n - 1), // Insert
				editDist(str1, str2, m - 1, n), // Remove
				editDist(str1, str2, m - 1, n - 1) // Replace
		);
	}

	public static void editditancedynamic(String str1, String str2, int m, int n) {
		int dp[][]=new int[n+1][m+1];
		
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i]=i;
			//dp[i][0]=i;
		}
		for(int i=0;i<n+1;i++) {
			//dp[0][i]=i;
			 dp[i][0]=i;
		}

		PrintMatrix.printMatrix(dp);
		System.out.println();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				
				if(str2.charAt(i-1)==str1.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}
				else
				{
					dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
				}
				
			}
		}
		PrintMatrix.printMatrix(dp);
	}

	public static void main(String args[]) {
		String str1 = "abcdef";
		String str2 = "azced";

		System.out.println(editDist(str1, str2, str1.length(), str2.length()));
		editditancedynamic(str1, str2, str1.length(), str2.length());
	}
}
