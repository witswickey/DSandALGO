package arrays;

import java.util.ArrayList;

class interval{
	int buy,sell;
}
public class StockBuySell {
// Driver code 
public static void main(String[] args) 
{ 
    int price[] = { 100, 180, 260, 310, 
                    40, 535, 695 }; 
    int n = price.length; 
  
    maxProfit(price, n); 
}

private static void maxProfit(int[] price, int n) {
	
	int i=0;
	ArrayList<interval> sol=new ArrayList<interval>();
	int count=0;
	while(i<n-1) {
		
		interval e=new interval();
		while(i<n-1 && price[i+1]<=price[i]) {
			i++;
		}
		if (i == n - 1) 
			break; 

		e.buy=i++;
		while(i<n && price[i]>=price[i-1]) {
			i++;
		}
		e.sell=i-1;
		
		sol.add(e);
		count++;
	
	}
	for(int j=0;j<count;j++) {
		interval e=sol.get(j);
		System.out.println("buy "+e.buy+" sell"+e.sell);
	}
	
} 
} 