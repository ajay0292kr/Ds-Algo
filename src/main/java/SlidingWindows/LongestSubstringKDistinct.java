package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        //  Return the longest substring with at most k distinct characters.
        if (k == 0 || s == null || s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            // Shrink window if more then k distinct character
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring length: " + lengthOfLongestSubstringKDistinct(s, k));
        // Output: 3 -> "ece"
    }
}
