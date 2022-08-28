package String;

public class PalPartionMemorization {
    static String str = "ababbbabbababa";
    static int n = str.length();
    int t[][] = new int [n][n];
    static boolean isPalindrome(String str, int i, int j) {
        while (i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return  true;
    }
    int solve(char s[], int i, int j) {
        if (i >=j || isPalindrome(String.valueOf(s), i, j)) {
            return 0;
        }
       if(s[i] !=-1) {

       }
       return 0;
    }
    public static void main(String[] args) {
        char [] ch = str.toCharArray();
        PalPartionMemorization p = new PalPartionMemorization();
        p.solve(ch, 0, n-1);
    }
}
