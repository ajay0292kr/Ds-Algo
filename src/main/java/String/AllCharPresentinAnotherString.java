package String;

public class AllCharPresentinAnotherString {
    static final int MAX_CHAR_SIZE = 256;
    public static boolean isPresent(String str1, String str2) {
        int[] count = new int [MAX_CHAR_SIZE];
        for (int i = 0; i<str1.length(); i++) {
            count[str1.charAt(i)]++;
        }
        for(int i = 0; i<str2.length(); i++) {
            count[str2.charAt(i)]--;
            if(count[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abctd";
        String q = "cat";

        if (isPresent(s, q))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
