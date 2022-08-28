package String;

public class SubStringFreq {
    static int countFreq(String str, String patt) {
        int M = str.length();
        int N = patt.length();
        int count = 0;
        for (int i = 0; i<= M-N; i++) {
            int j;
            for (j = 0; j< N; j++) {
                if (str.charAt(i+j) != patt.charAt(j)) {
                    break;
                }
            }
            if(j == N) {
                ++count;
                j = 0;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // String
        String str = "dhimanman";
        // Pattern
        String patt = "manman";
        System.out.println(countFreq(str, patt));
    }
}
