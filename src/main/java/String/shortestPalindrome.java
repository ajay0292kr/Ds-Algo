package String;

public class shortestPalindrome {
    public static String shortestPalindromeString(String str) {
        int lptr = 0;
        int rptr = str.length()-1;
        StringBuilder sb = new StringBuilder(str);
        while (lptr < rptr) {
            if (sb.charAt(lptr) == sb.charAt(rptr)) {
                lptr++;
                rptr--;
            }else {
               char ch[] = {sb.charAt(rptr)};
               sb.insert(lptr, ch, 0, 1);
               lptr++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    String str = "abcd";
    System.out.print(shortestPalindromeString(str));
    }
}
