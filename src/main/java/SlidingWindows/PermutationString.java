package SlidingWindows;

public class PermutationString {
    /*
      Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
      In other words, return true if one of s1's permutations is the substring of s2.
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int s1Map[] = new int [26];
        int s2Map[] = new int [26];

        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) -'a']++;
            s2Map[s2.charAt(i) -'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) matches++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches == 26) return true;

            int right = s2.charAt(i + s1.length()) - 'a';
            int left = s2.charAt(i) - 'a';

            s2Map[right]++;
            if (s2Map[right] == s1Map[right]) {
                matches++;
            } else if (s2Map[right] - 1 == s1Map[right]) {
                matches--;
            }
            s2Map[left]--;
            if (s2Map[left] == s1Map[left]) {
                matches++;
            } else if (s2Map[left] + 1 == s1Map[left]) {
                matches--;
            }

        }
        return matches == 26;
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.print(checkInclusion(s1, s2));
    }
}
