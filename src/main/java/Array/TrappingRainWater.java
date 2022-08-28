package Array;

public class TrappingRainWater {
    // Input: arr[]   = {3, 0, 2, 0, 4}
    // Output: 7
    // Time Complexity = O(n*n)
    static void trappingRainWater(int[] arr, int n) {
        int result = 0;
        // We can't hold water on first and last index
        for(int i = 1; i<n-1; i++) {
            int lmax = arr[i];
            for(int j = 0; j<i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rmax = arr[i];
            for(int j = i+1; j<n; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            result = result + Math.min(lmax, rmax) - arr[i];
        }
        System.out.print(result);
    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        int n = arr.length;
        trappingRainWater(arr, n);
    }
}
