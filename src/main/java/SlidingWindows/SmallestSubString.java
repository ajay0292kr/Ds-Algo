package SlidingWindows;

public class SmallestSubString {
    public static int smallestSubstring(String str) {
        boolean zero = false, one  = false, two = false;
        int min_length = Integer.MAX_VALUE;
        int zeroIndex = 0, oneIndex = 0, twoIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zero = true;
                zeroIndex = i;
            }else if (str.charAt(i) == '1') {
                one = true;
                oneIndex = i;
            }else if (str.charAt(i) == '2') {
                two = true;
                twoIndex = i;
            }
            if (zero && one && two)
                min_length = Math.min( min_length,
                        Math.max(zeroIndex,Math.max(oneIndex, twoIndex))
                                - Math.min( zeroIndex,Math.min(oneIndex, twoIndex)));
        }
        // In case if there is no substring that contains 0,1 and 2
        if (min_length == Integer.MAX_VALUE)
            return -1;
        return min_length + 1;
    }
    public static void main(String[] args) {
        String S = "01212";
        // Function call
        System.out.print(smallestSubstring(S));
    }
}
