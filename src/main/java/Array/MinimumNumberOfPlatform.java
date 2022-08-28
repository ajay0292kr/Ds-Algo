package Array;

public class MinimumNumberOfPlatform {
    public static int findPlatform(int[] arr, int[] dep, int n) {
        int i, j;
        int plat_needed = 1, result = 1;
        for(i = 0; i<n; i++) {
            plat_needed = 1;
            for(j = i+1; j<n; j++) {
                if(Math.max(arr[j], arr[j]) <= Math.min(dep[i], dep[j])) {
                    plat_needed++;
                }
            }
            result = Math.max(result, plat_needed);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        System.out.println(findPlatform(arr, dep, n));
    }
}
