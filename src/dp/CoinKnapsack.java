package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoinKnapsack {
	int count = 0;

	public static void main(String[] args) {
		int amount = 5;
		int coins[] = { 1, 2, 5 };
		System.out.println("final count is->" + new CoinKnapsack().change(amount, coins));
		int[][] dp = new int[coins.length][amount + 1];
		for (int i = 0; i < coins.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println("TOp down solution is" + new CoinKnapsack().coincount(amount, coins, dp, 0));
		LinkedList<Integer> result = new LinkedList<Integer>();
		new CoinKnapsack().printcoinchange(amount, coins, result);
	}

	public int change(int amount, int[] coins) {

		List<Integer> result = new LinkedList<Integer>();
		return changUtil(amount, coins, 0);
		// System.out.println();
		// return count;
	}

	public int changUtil(int amount, int[] coins, int i) {

		int s = 0;

		if (amount < 0 || i == coins.length) {
			return 0;
		}
		if (amount == 0) {

			return 1;
			// return true;
		}

		int count = changUtil(amount - coins[i], coins, i) + changUtil(amount, coins, i + 1);

		return count;

	}

	// top down aaproach

	public int coincount(int amount, int[] coins, int[][] dp, int i) {
		if (amount < 0 || i == coins.length) {
			return 0;
		}
		if (amount == 0) {

			return 1;
			// return true;
		}
		if (dp[i][amount] != -1) {
			return dp[i][amount];
		}
		dp[i][amount] = changUtil(amount - coins[i], coins, i) + changUtil(amount, coins, i + 1);
		return dp[i][amount];
	}

	public void printcoinchange(int amount, int[] coins, LinkedList<Integer> result) {

		if (amount == 0) {
			print(result);
			// return true;
		}
		for (int i = 0; i < coins.length; i++) {
			if (amount > 0) {
				result.add(coins[i]);
				printcoinchange(amount - coins[i], coins, result);
				result.remove(result.size() - 1);
			}
		}

	}

	private void print(LinkedList<Integer> result) {

		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
}
