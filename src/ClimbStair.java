import java.util.Arrays;

public class ClimbStair {

	
	
	public static void main(String[] args) {
		
		System.out.println(new ClimbStair().climbstarcase(45));

	}

	private int climbstarcase(int n) {
		
		int[] dp=new int[n+1];
		

		Arrays.fill(dp, -1);
		
		dp[0]=1;
		dp[1]=1;
		return climbstareUtil(n,dp);
		
	}

	private int climbstareUtil(int n, int[] dp) {
		
		
		if(n<0)
			return 0;
		
		if(dp[n]!=-1)
			return dp[n];
		
		//dp[n-1]=climbstareUtil(n-1, dp);
		//dp[n-2]=climbstareUtil(n-1, dp);
		
		dp[n]=climbstareUtil(n-1, dp)+climbstareUtil(n-2, dp);
		
		return dp[n];
		
		
	}



}
