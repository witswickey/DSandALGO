package dp;

public class SubsetSum {

	public static void main(String[] args) {
		 int arr[] = {3, 1, 5, 9, 12}; 
	        int n = arr.length; 
	        if (findPartition(arr, n) == true) 
	            System.out.println("Can be divided into two "+ 
	                                "subsets of equal sum"); 
	        else
	            System.out.println("Can not be divided into " + 
	                                "two subsets of equal sum"); 
	}

	private static boolean findPartition(int[] arr, int n) {
		int sum=0;
		for(int i:arr) {
			sum+=i;
		}
		if(sum%2!=0) {
			return false;
		}
		sum/=2;
		boolean[][] dp =new boolean[arr.length+1][sum+1];
		
		for(int i=0;i<=arr.length;i++) {
			dp[i][0]=true;
		}
		
		printMatrix(dp);

		
		
		for(int i=1;i<=arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(j-arr[i-1]>=0) {
					dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		System.out.println();
		printMatrix(dp);
		return dp[arr.length][sum];
	}

	private static void printMatrix(boolean[][] dp) {
		String str = "|\t";
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				str += dp[i][j] + "\t";
			}

			System.out.println(str + "|");
			str = "|\t";
		}
		
	}

}
