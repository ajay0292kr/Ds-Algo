package Dynamic;

public class KnapsackWithDuplicate {
    // Unbounded knapsack
    static int knapSack(int N, int W, int[] val, int[] wt)
    {
        int[][] dp = new int [N+1][W+1];
        for(int i = 0; i<=N; i++) {
            for(int j = 0; j<=W; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
    public static void main(String[] args) {
      int N = 2;
      int W = 3;
      int[] val = {1, 1};
      int[] wt = {2, 1};
      System.out.print(knapSack(N, W, val,wt));
    }
}
