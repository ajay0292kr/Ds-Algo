package String;

public class PalindromicSubSeqCountRecr {
    static int n;
    static int[][] dp = new int[1000][1000];

    static String str = "abcb";
    static int countPS(int i, int j) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == j)
            return dp[i][j] = 1;
        if(str.charAt(i) == str.charAt(j))
            return dp[i][j] = countPS(i+1, j) + countPS(i, j-1) + 1;
        else
          return   dp[i][j] = countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < 1000; j++)
                dp[i][j] = -1;

        n = str.length();
        System.out.println("Total palindromic subsequence"
                + "are : " + countPS(0, n - 1));
    }
}
