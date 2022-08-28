package String;

import java.util.HashMap;

public class LargestSubArrayEqualOneZero {
    // Largest subarray with equal number of 0s and 1s
    // Level Hard
    static int longestSub(int []arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int count_1 = 0, count_0 = 0;
        for (int i= 0; i<arr.length; i++) {
            if (arr[i] == 0) {
                count_0++;
            }else {
                count_1++;
            }
            if (map.containsKey(count_1 - count_0)) {
                res = Math.max(res, i - map.get(count_1 - count_0));
            }else {
                map.put(count_1 - count_0, i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(longestSub(arr));
    }
}
