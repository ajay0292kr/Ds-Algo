package Lexicographic;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DistinctSubsequences {
    static void generate(Set<String> st, String str) {
        if(str.length() == 0) return;
        if(!st.contains(str)) {
            st.add(str);
            for (int i = 0; i < str.length(); i++) {
                String t = str;
                t = t.substring(0, i) + t.substring(i+1);
                generate(st, t);
            }
        }
    }
    public static void main(String[] args) {
        String str = "xyz";
        TreeSet<String> st = new TreeSet<>();
        generate(st, str);
        for(String t: st) {
            System.out.println(t);
        }
    }
}
