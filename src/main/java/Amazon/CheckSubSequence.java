package Amazon;

public class CheckSubSequence {
    // Given two strings A and B, find if A is a subsequence of B.
    // A = AXY
    //B = YADXCP
    static boolean checkSequence(String str1, String str2, int m, int n) {
        if (m == 0) return true;
        if (n == 0) return false;
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return checkSequence(str1, str2, m-1, n-1);
        }
        return checkSequence(str1, str2, m, n-1);
    }
    static boolean subSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        return checkSequence(str1, str2, m, n);
    }
    public static void main(String[] args) {
     String str1 = "AXY";
     String str2 = "YADXCP";
     System.out.println(subSequence(str1, str2));
    }
}
