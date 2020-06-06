/**
 * 
 */
package dp;

import java.util.Arrays;

/**
 * @author limca
 *
 */
public class fibo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 6;
		int[] memo = new int[n+1];
		//memo[0]=1;
		//memo[1]=1;
		Arrays.fill(memo,-1);

		System.out.println(fibo(n, memo));
		
		System.out.println(fibo(n, memo)==fibotopdown(n, memo));
	}

	//recursive approach
	private static int fibo(int n,int memo[]) {
	
		if(n<=1) {
			return n;
			
		}
		if(memo[n]!=-1)
			return memo[n];
		else
		{
			memo[n]=fibo(n-1, memo)+fibo(n-2, memo);
			
		}
		return memo[n];
		
	}
	
	// top down approach
	private static int fibotopdown(int n,int memo[]) {
		
		memo[0]=0;
		memo[1]=1;
		for(int i=2;i<=n;i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		return memo[n];
		
	}
}
