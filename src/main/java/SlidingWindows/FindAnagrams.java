package SlidingWindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String str, String p) {
        List<Integer> result = new ArrayList<>();
        if (str.length() < p.length()) return result;
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // count frequency of character in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int windowSize = p.length();
        for (int i = 0; i < str.length(); i++) {
            // Add current character to windows count
            sCount[str.charAt(i) -'a']++;
            // remove character left out the window
            if (i >= windowSize) {
                sCount[str.charAt(i - windowSize) -'a']--;
            }
            // compare both frequency array
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(str, p);
        System.out.println(result);
    }
}
