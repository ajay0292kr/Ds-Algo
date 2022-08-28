package Lexicographic;

import java.util.Arrays;

public class PowerSet {
    // Input : abc
    // Output : a ab abc ac b bc c
    public static void permuteRec(String str, int n,
                               int index, String curr) {
        if(index == n) {
            return;
        }
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {

            curr += str.charAt(i);
            permuteRec(str, n, i, curr);

            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
    }
    static void powerSet(String str)
    {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        permuteRec(new String(arr), str.length(), -1, "");
    }
    public static void main(String[] args) {
        String str = "cab";
        powerSet(str);
    }
}
