package greedy;

public class MaxStockPrice {
	public int maxProfit(int[] prices) {
		return calculate(prices);
	}



	private int calculate(int[] prices) {
		
		int profit=0;
		for(int i=0;i<prices.length;i++) {
			
			while(i<prices.length-1 && prices[i]>prices[i+1]) {
				i++;
			}
			int valley=prices[i];
			
			while(i<prices.length-1 && prices[i]<prices[i+1]) {
				i++;
			}
			int peak=prices[i];
		    profit=profit+peak-valley;
			
		}
		return profit;
		
	}



	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(new MaxStockPrice().maxProfit(prices));
	}

	
}
