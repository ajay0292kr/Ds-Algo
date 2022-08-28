package String;

import java.util.HashSet;

public class CommonSubString {
    static boolean twoStrings(String str1, String str2) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i<str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        for(int j = 0; j<str2.length(); j++) {
            if (set.contains(str2.charAt(j))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        if (twoStrings(str1, str2))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
