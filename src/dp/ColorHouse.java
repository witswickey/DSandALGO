package dp;

import java.util.Arrays;

public class ColorHouse {

	private static final int RED = 0, GREEN = 2, BLUE = 1;

	public static void main(String[] args) {

		int[][] cost = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 9 } };
		int[][] cache=new int[cost.length][cost.length];
		for (int i=0;i<cost.length;i++) {
			Arrays.fill(cache[i],-1);
		}
		int mincost = minimumcost(cost, 0, RED,cache);
		int mincost2 = minimumcost(cost, 0, BLUE,cache);
		int mincost3 = minimumcost(cost, 0, GREEN,cache);
		int costy=Math.min(mincost,mincost2);
		costy=Math.min(costy,mincost3);
		System.out.println(costy);
		System.out.println("bottom up sol->"+minimumcostpureDp(cost));
	}

	private static int minimumcost(int[][] cost, int i, int color,int[][] cache) {

		if (i == cost.length) {
			return 0;
		}
		
		if(cache[i][color]!=-1) {
			return cache[i][color];
		}
		//int mincost = 0;
		switch (color) {
		case RED: {
			int bluec = minimumcost(cost, i + 1, BLUE,cache);
			int greenc = minimumcost(cost, i + 1, GREEN,cache);
			cache[i][color]=cost[i][RED] + Math.min(bluec, greenc);
			return cache[i][color];
		}
		case BLUE: {
			int redc = minimumcost(cost, i + 1, RED,cache);
			int greenc1 = minimumcost(cost, i + 1, GREEN,cache);
			cache[i][color]=  cost[i][BLUE] + Math.min(redc, greenc1);
			return cache[i][color];
		}
		case GREEN: {
			int bluec1 = minimumcost(cost, i + 1, RED,cache);
			int REDnc = minimumcost(cost, i + 1, BLUE,cache);
			cache[i][color]=cost[i][GREEN] + Math.min(bluec1, REDnc);
			return cache[i][color];
		}
		}
		return 0;
	}
// bottom up slution'
	private static int minimumcostpureDp(int[][] cost) {

		
		int[][] dp =new int[cost.length+1][3];
		
		
		for(int j=1;j<4;j++) {
			
			dp[j][RED]=cost[j-1][RED]+Math.min(dp[j-1][BLUE],dp[j-1][GREEN]);
			dp[j][BLUE]=cost[j-1][BLUE]+Math.min(dp[j-1][GREEN],dp[j-1][RED]);
			dp[j][GREEN]=cost[j-1][GREEN]+Math.min(dp[j-1][RED],dp[j-1][BLUE]);
			
		}
		int n=cost.length;
		return Math.min(dp[n][RED],Math.min(dp[n][BLUE],dp[n][GREEN]));
		//return 0;
	}
}
