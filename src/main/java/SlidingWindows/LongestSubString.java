package SlidingWindows;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                maxLen = Math.max(maxLen, set.size());
            }else {
                set.remove(str.charAt(j++));
            }

        }
        return maxLen;
    }
    //  Find the longest substring without repeating characters
    public static void main(String[] args) {

        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring: " + result);
    }
}
