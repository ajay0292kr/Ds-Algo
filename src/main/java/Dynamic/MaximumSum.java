package Dynamic;

public class MaximumSum {
   /* static int breakSum(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return Math.max(breakSum(n/2)+breakSum(n/3)+breakSum(n/4), n);
    }*/
    // Using dynamic programming
    static int breakSum(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i<=n; i++) {
            dp[i] = Math.max(dp[i/2]+dp[i/3]+dp[i/4], i);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 12;
        System.out.println(breakSum(n));
    }
}
