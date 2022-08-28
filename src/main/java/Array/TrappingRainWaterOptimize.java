package Array;

public class TrappingRainWaterOptimize {
    static void trappingRainWater(int[] arr, int n) {
     int res = 0;
     int[] lmax = new int [n];
     lmax[0] = arr[0];
     int[] rmax = new int [n];
     for(int i = 0; i < n; i++) {
         lmax[i] = Math.max(arr[i], lmax[i-1]);
     }
     rmax[n-1] = arr[n-1];
     for(int i = n-2; i>=0; i--) {
         rmax[i] = Math.max(arr[i], rmax[i+1]);
     }
     for(int i=1; i<n-1; i++) {
         res  = res + (Math.min(lmax[i], rmax[i]) - arr[i]);
     }
     System.out.print(res);
    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        int n = arr.length;
        trappingRainWater(arr, n);
    }
}
