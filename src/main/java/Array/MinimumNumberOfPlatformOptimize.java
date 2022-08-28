package Array;

import java.util.Arrays;

public class MinimumNumberOfPlatformOptimize {
    // Time    EventType    Total platform needed at a time
    // 9:00    Arrival                 1
    // 9:10    Departure               0
    // 9:40    Arrival                 1
    // 9:50    Arrival                 2
    // 11:00   Arrival                 3
    // 11:20   Departure               2
    // 11:30   Departure               1

    // Finally we have to find the maximum total platform which is minimum plat needed
    public static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1;
        int i = 0, j = 0;
        int result = 1;
        while(i < n && j < n) {
            if(arr[i] <=dep[j]) {
                plat_needed++;
                i++;
            }else {
                plat_needed--;
                j++;
            }
            if(plat_needed > result) {
                result = plat_needed;
            }
        }
        return plat_needed;
    }
    public static void main(String[] args) {
        int[] arr = {900,  940, 950,  1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }
}
