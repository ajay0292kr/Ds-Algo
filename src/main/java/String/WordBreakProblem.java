package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem {
    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = prepareSet(wordDict);
        boolean res[] = new boolean[s.length()+1];
        res[s.length()] = true;
        for (int pos = s.length()-1; pos>=0; pos--) {
            for (int i = pos; i<s.length() && !res[pos]; i++) {
                res[pos] = res[i+1];
            }
        }
        return res[0];
    }
    public static Set<String> prepareSet(List<String> wordDict) {
        return new HashSet<>(wordDict);
    }
    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak(s, wordDict));
    }
}
