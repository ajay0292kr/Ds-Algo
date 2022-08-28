package String;

// Palindrome Partitioning Recursive
public class MinPalPartion {


    static boolean isPalindrome(String str, int i, int j) {
        while (i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static int minPalPartion(String str, int i, int j) {
        /* if already palindrome */
        if (i >= j || isPalindrome(str, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE, count;

        for (int k = i; k < j; k++) {

            count = minPalPartion(str, i, k) + minPalPartion(str, k+1, j) + 1;
            ans = Math.min(ans, count);
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = "ababbbabbababa";

        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalPartion(str, 0, str.length() - 1));
    }
}
