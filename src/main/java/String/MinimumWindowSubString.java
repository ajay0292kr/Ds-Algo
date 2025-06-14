package String;

public class MinimumWindowSubString {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())  {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        String minSubstring = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j =  i+1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                // Check if current substring contains all characters of t
                if (containsAllCharacters(str, t)) {
                    // Update minSubstring if this one is smaller
                    if (str.length() < minLength) {
                        minLength = str.length();
                        minSubstring = str;
                    }
                }
            }
        }
        return minSubstring;
    }
    // Helper function to check if str contains all characters of t
    private static boolean containsAllCharacters(String str, String t) {
        int count[] = new int[128];
        for(char c: t.toCharArray()) {
            count[c]++;
        }
        //int strCount[] = new int[128];
        for (char c: str.toCharArray()) {
            count[c]--;
        }
        for(int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }
}
