package Lexicographic;

import java.util.ArrayList;

public class LexicographicalMaximum {
    // Brute Force
   /* static String LexicographicalMaxString(String str) {
        String mx = "";
        for (int i = 0; i<str.length(); i++) {
            if (mx.compareTo(str.substring(i)) <= 0) {
                mx = str.substring(i);
            }
        }
        return mx;*/
    // Optimization
    static String LexicographicalMaxString(String str) {
        char maxchar = 'a';
        ArrayList<Integer> index = new ArrayList<Integer>();

        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) >= maxchar)
            {
                maxchar = str.charAt(i);
                index.add(i);
            }
        }
        String maxstring = "";
        // We form a substring from that maximum
        // character index till end and check if
        // its greater that maxstring
        for (int i = 0; i < index.size(); i++)
        {
            if (str.substring(index.get(i),
                    str.length()).compareTo( maxstring) > 0)
            {
                maxstring = str.substring(index.get(i),
                        str.length());
            }
        }
        return maxstring;
    }
    public static void main(String[] args) {
        String str = "ababaa";
        System.out.println(LexicographicalMaxString(str));
    }
}
