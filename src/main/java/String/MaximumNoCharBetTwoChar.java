package String;

public class MaximumNoCharBetTwoChar {
    static int MAX_CHAR = 256;
    public static int maxDistBetweenChar(String str) {
        int cnt[] = new int[MAX_CHAR];
        int len = str.length();
        int res = -1;
        for (int i = 0; i<MAX_CHAR; i++) {
            cnt[i] = -1;
        }
        for (int i = 0; i<len; i++) {
            int firstIdx = cnt[str.charAt(i)];
            if(firstIdx == -1) {
                cnt[str.charAt(i)] = i;
            }else {
                res = Math.max(res, Math.abs(i-firstIdx-1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "baaabcddc";
        System.out.println(maxDistBetweenChar(str));
    }
}
