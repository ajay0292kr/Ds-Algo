package Amazon;

public class MinimumInsertionsToPalindrome {
    static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int [n+1][m+1];

        for (int i = 0; i<=n; i++) {
            for(int j =0; j<=m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    static boolean isPalindrome(String str) {
        int l = 0;
        int h = str.length()-1;
        while(l < h) {
            if(str.charAt(l) != str.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    static int minInsertions(String str) {
        if(isPalindrome(str)) return 0;
        StringBuilder sb = new StringBuilder(str);
        String reverseString = sb.reverse().toString();
        int lcsLength = lcs(str, reverseString);
        int len = str.length();
        return (len-lcsLength);
    }
    public static void main(String[] args) {
        String str = "aba";
        System.out.print(minInsertions(str));
    }
}
