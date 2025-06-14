package Array;

import java.util.Arrays;

public class MinimumPlatNeeded {
    public static int minPlatNeeded(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i  = 1, j = 0, result = 1;
        int plat_needed = 1;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
        }
        if (plat_needed > result) {
            result = plat_needed;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatNeeded(arr, dep));
    }
}
