package LeetCode150;

public class MinimumSubString {
    public static String minimumWindowSubstring(String s, String t) {
        if (s == null || t == null || s.length() < t.length() ) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i= 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isSubString(sub, t)) {
                    if (sub.length() < min) {
                        min = sub.length();
                        res = sub;
                    }
                }
            }
        }
        return res;
    }
    private static boolean isSubString(String sub, String t) {
        int[] count = new int[128];
        for (char ch: t.toCharArray()) {
            count[ch]++;
        }
        for (char ch: sub.toCharArray()) {
            count[ch]--;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*
           Input: s = "ADOBECODEBANC", t = "ABC"
           Output: "BANC"
         */
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }
}
