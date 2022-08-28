package Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    // There is a dictionary already implemented.
    // Write a method, which takes input String without space,
    // to prints all subsets of the input string which is present in dictionary.
    // Example: Dictionary – a*
    // Input- aaabaa
    //  Output- a,a,a,aa,aa,aaa,a,a,aa

    // Time complexity = O(N*N)
    // Space complexity = O(N)
    public static void getCombination(String str, Set<String> dict) {
        for(int i = 0; i<str.length(); i++) {
            for(int j = i; j<=str.length(); j++) {
                if(dict.contains(str.substring(i, j))) {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("a", "aa", "aaa"));
        String input = "aaabaa";
        getCombination(input, dict);
    }
}
