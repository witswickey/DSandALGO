package dp;

public class MinCoinChange {
	public static void main(String args[]) {
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is " + minCoins(coins, V));
	}

	private static int minCoins(int[] coins, int V) {
		
		int sum = Integer.MAX_VALUE;
		if(V==0) {
			
			return 0;
		}
		if( V<0) {
			return 0;
		}
		
		for(int i=0;i<coins.length;i++) {
			 sum=Math.min(sum,1+minCoins(coins, V-coins[i]));
			 //return sum;
		}
		return sum;
		
		
		
		
		
		
	}
}
