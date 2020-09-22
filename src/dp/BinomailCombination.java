package dp;

import java.util.Arrays;

public class BinomailCombination {

	public static void main(String[] args) {
		BinomailCombination bc = new BinomailCombination();
		System.out.println(bc.calculateBinomailComination(6, 4));
		System.out.println(bc.calcutiltopdown(6, 4));
	}

	// C(n,k)=C(n-1)(k-1) +C(n-1)(k)
	// C(n,k)=n!/(n-k)!k!
	// top down
	private int calculateBinomailComination(int n, int k) {
		int dp[][] = new int[n + 1][k + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 0);
		}

		return calcutil(n, k, dp);
	}

	// C(n,n)=1 , C(n,0)=1
	private int calcutil(int n, int k, int[][] dp) {
		if (n == k || k == 0) {
			return 1;
		} else if (dp[n][k] != 0) {
			return dp[n][k];
		} else {
			dp[n][k] = calcutil(n - 1, k - 1, dp) + calcutil(n - 1, k, dp);
			return dp[n][k];
		}
	}

	// C(n,n)=1 , C(n,0)=1
	private int calcutiltopdown(int n, int k) {
		int dp[][] = new int[n + 1][k + 1];
		for (int i = 0; i <=n; i++) {
			Arrays.fill(dp[i], 0);
			dp[i][0]=1;
			if(i<=k)
				dp[i][i]=1;
		}
		//dp[n][k] = 1;
		PrintMatrix.printMatrix(dp);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j] = dp[i - 1][j - 1]+dp[i - 1][j];
			}
		}
		return dp[n][k];
	}

}
