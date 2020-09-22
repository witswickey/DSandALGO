package dp;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n, n));
        int[][] dp=new int[val.length+1][W+1];
        
        System.out.println(knapSackTopDown(W,wt,val,n,dp));
    }

    private static int knapSack(int w, int[] wt, int[] val, int n, int i) {
        // TODO Auto-generated method stub
        if (w == 0)
            return 0;
        if (i == 0)
            return 0;
        if (wt[i - 1] > w)
            return knapSack(w, wt, val, n, i - 1);
        else {
            int include = val[i - 1] + knapSack(w - wt[i - 1], wt, val, n, i - 1);
            int exclude = knapSack(w, wt, val, n, i - 1);
            return Math.max(include, exclude);
        }
    }
    // top down approach 
    private static int knapSackTopDown(int w, int[] wt, int[] val, int n,int[][] dp) {
        
        int[][]K=dp;
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <=w; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][w];
    }
    
}
