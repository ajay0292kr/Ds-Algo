package SlidingWindows;

import java.util.Arrays;

public class CountAccurrenceOfAnagrams {
    static boolean araAnagram(String str1, String str2) {
        char[] ch = str1.toCharArray();
        char[] ch1 = str2.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        return Arrays.equals(ch, ch1);
    }
    static int countAnagrams(String text, String word) {
        int N = text.length();
        int M = word.length();
        int res = 0;
        for (int i = 0; i <= N - M; i++) {

            String s = text.substring(i, i + M);

            // Check if the word and substring are
            // anagram of each other.
            if (araAnagram(word, s))
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(text, word));
    }
}
