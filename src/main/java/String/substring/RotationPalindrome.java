package String.substring;

public class RotationPalindrome {
    public static boolean isPalindrome(String str) {
        return str.contentEquals(new StringBuilder(str).reverse());
    }
    public static boolean isRotationOfPalindrome(String str) {
        if(isPalindrome(str)) {
          return true;
        }
        for(int i = 0; i < str.length() -1; i++) {
                String str1 = str.substring(i);
                String str2 = str.substring(0, i);
                if(isPalindrome(str1+str2)) {
                    return true;
                }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println((isRotationOfPalindrome("aab")) ? 1 : 0);
        System.out.println((isRotationOfPalindrome("abcde")) ? 1 : 0);
        System.out.println((isRotationOfPalindrome("aaaad")) ? 1 : 0);
    }
}
