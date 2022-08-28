package String;

public class NonRepeative {
    static boolean nonReptiveChar(String S) {
        int x = S.length();
        for(int i = 0; i<x; i++) {
            for(int j = x-1; j>i; j--) {
                if(S.charAt(i) == S.charAt(j)) {
                    for(int k = i; k<=j; k++) {
                        if(S.charAt(k) != S.charAt(i)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
      String str = "AABBCCCCC";
      System.out.println(nonReptiveChar(str));
    }
}
