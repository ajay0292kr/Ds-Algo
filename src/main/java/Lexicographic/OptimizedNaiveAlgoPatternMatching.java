package Lexicographic;

public class OptimizedNaiveAlgoPatternMatching {
    static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i = 0;
        while (i <=N-M) {
            int j;
            for (j = 0; j<M; j++) {
                if(txt.charAt(i+j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            {
                System.out.println("Pattern found at index "+i);
                i = i + M;
            }
            else if (j == 0)
                i = i + 1;
            else  // slide the pattern by j
                i = i + j;
        }
    }
    public static void main(String[] args) {
        String txt = "ABCEABCDABCEABCD";
        String pat = "ABCD";
        search(pat, txt);
    }
}
