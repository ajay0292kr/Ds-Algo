package String;

public class ExtraCharInString {
    public static char extraCharInTwoString(String strA, String strB) {
        int cnt[] = new int [256];
        for (int i = 0; i<strB.length(); i++) {
            cnt[strB.charAt(i)]++;
        }
        for(int j = 0; j<strA.length(); j++) {
            cnt[strA.charAt(j)]--;
        }
        for(int i = 0; i<cnt.length; i++) {
            if(cnt[i] == 1) return (char)i;
        }
        return Character.MIN_VALUE;
    }
    static char usingXor(String str1, String str2) {
        int res = 0, i;
        for(i = 0; i<str1.length(); i++) {
            res^=str1.charAt(i);
        }
        for(i = 0; i<str2.length(); i++) {
            res^=str2.charAt(i);
        }
        return (char)res;
    }
    public static void main(String[] args) {
        String strA = "abcd";
        String strB = "cbdad";
        System.out.println(extraCharInTwoString(strA, strB));
        System.out.println(usingXor(strA, strB));
    }
}
