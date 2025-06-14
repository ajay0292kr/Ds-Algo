package String;

import java.util.HashMap;
import java.util.Map;

public class MaxWindowsLengthSubString {
    public static int longestKUniqueSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int maxLength = -1;
        int left = 0;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0)+1);

            // Shrink the windows till be have exactly k characters
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(rightChar, charCount.get(leftChar) -1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // Check if we have exactly K unique characters
            
        }
        return maxLength;

    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Longest substring with " + k + " unique characters: " + longestKUniqueSubstr(s, k));
        // Expected output: "cbebebe" or "bacbebebe" (both of length 7)
    }
}
