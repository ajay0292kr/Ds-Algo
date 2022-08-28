package String;

public class LongestSubStringVowel {
    // Longest substring of vowels
    static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    static int longestVowel(String str) {
        int count = 0, res = 0;
        //char ch[] = str.toCharArray();
        for (int i = 0; i<str.length(); i++) {
            if(isVowel(str.charAt(i))) {
                count++;
            }else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(res, count);
    }
    public static void main(String[] args) {
        String s = "theeare";
        System.out.println(longestVowel(s));
    }
}
