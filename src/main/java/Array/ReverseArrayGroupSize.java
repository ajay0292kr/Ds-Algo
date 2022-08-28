package Array;


public class ReverseArrayGroupSize {
    // Reverse an array of group of size
    static void reverse(int arr[], int n, int k) {
        for(int i = 0; i<n-1; i+=k) {
            int l = i;
            int r = i+k-1;
            // to handle case when k is not multiple
            if(n%k != 0) {
                r = Math.min(i+k-1, n-1);
            }
            while(l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        for(int i = 0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int k = 3;
        reverse(arr, n, k);
    }
}
