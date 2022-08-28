package String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {
    static boolean isPalindrome(String p) {
        int l = 0;
        int r = p.length()-1;
        while (l<r) {
            if(p.charAt(l) != p.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    map.put(s.substring(i, j + 1), s.substring(i, j + 1).length());
                }
            }
        }
        int max = 0;
        String str = "";
        // System.out.println(map);
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                max = m.getValue();
                str = m.getKey();
            }
        }
        return str;
    }
    public static void main(String[] args) {
     String str = "babad";
     System.out.print(longestPalindrome(str));
    }
}
