package String.substring;

public class Rearranged {
    public static boolean canFormPalindrome(String str) {
        int count[] = new int [256];
        if (str == null || str.length() <=1) {
            return true;
        }
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) -'a']++;
        }
        int cnt = 0;
        for(int i = 0; i < 256; i++) {
            if (count[i] > 0 && count[i]%2 != 0) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Check if characters of a given string can be rearranged to form a palindrome
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
