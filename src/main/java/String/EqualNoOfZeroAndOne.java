package String;

import java.util.HashMap;

public class EqualNoOfZeroAndOne {
    // Length of the longest substring with equal 1s and 0s
    //Method - 1
   /* static boolean isValid(String s) {
        int zero = 0, one = 0;
        for (int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                zero++;
            }else {
                one++;
            }
        }
        if(zero == one) return true;

        return false;
    }
    static int longestSub(String str) {
        int max_len = 0;
        for (int i = 0; i<str.length(); i++) {
            for (int j = i; j<str.length(); j++) {
                if(isValid(str.substring(i, j+1)) && max_len < j - i + 1) {
                    max_len = j - i + 1;
                }
            }
        }
        return max_len;
    }*/
   // Method-2
    static int longestSub(String str) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0, -1);
        int res = 0;
        int count_0 = 0, count_1 = 0;
        for (int i = 0; i<str.length(); i++) {
            if(str.charAt(i)=='0')
                count_0++;
            else
                count_1++;
            if(map.containsKey(count_1-count_0))
                res = Math.max(res, (i - map.get(count_1-count_0)));
            else
                map.put(count_1-count_0,i);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "101001000";

        // Function call
        System.out.println(longestSub(s));
    }
}
