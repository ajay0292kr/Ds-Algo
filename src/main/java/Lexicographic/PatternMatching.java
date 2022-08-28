package Lexicographic;

public class PatternMatching {
    static void search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i<=N-M; i++) {
            int j = 0;
            boolean f = true;
            for (j = 0; j<M; j++) {
                if(txt.charAt(i+j) != pat.charAt(j)) {
                    f = false;
                    break;
                }
            }
            if(f) {
                System.out.println("Match at index = "+i);
            }
        }
    }
    public static void main(String[] args) {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(txt, pat);
    }
}
