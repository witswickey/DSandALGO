/**
 * 
 */
package dp;

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
		int[] memo = new int[n];
		//memo[0]=1;
		//memo[1]=1;

		System.out.println(fibo(n, memo));
	}

	private static int fibo(int n,int memo[]) {
	
		if(n==0)
			return 0;
		if(n==1 || n==2) {
			return 1;
			
		}
		else
		{
			memo[n-1]=fibo(n-1, memo)+fibo(n-2, memo);
			
		}
		return memo[n-1];
		
	}
}
