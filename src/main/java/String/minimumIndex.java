package String;

import java.util.HashSet;
import java.util.Set;

public class minimumIndex {
    // Find the character in first string that is present at minimum index in second string
    // Input: str = “geeksforgeeks”, patt = “set”
    static char minimumIndexChar(String str, String patt) {
        char ch = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<patt.length(); i++) {
            set.add(patt.charAt(i));
        }
        for(int i = 0; i<str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                ch = str.charAt(i);
                break;
            }
        }
        return ch;
    }
    public static void main(String[] args) {
    String str = "adcffaet";
    String patt = "onkl";
    System.out.println(minimumIndexChar(str, patt));
    }
}
