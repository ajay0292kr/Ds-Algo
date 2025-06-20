package String.substring;

public class MinDeletionsToPalindrome {
    public static int minDeletionsToMakePalindrome(String str) {
        String revString  = new StringBuilder(str).reverse().toString();
        int len = longestCommonSubsequence(str, revString);
        return str.length() - len;
    }
    private static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j =1; j <=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public static void main(String[] args) {
        String str = "abcda";
        System.out.println("Minimum deletions to make palindrome: " + minDeletionsToMakePalindrome(str));
    }
}
