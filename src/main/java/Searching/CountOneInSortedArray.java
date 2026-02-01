package Searching;

public class CountOneInSortedArray {
    // Count 1's in a sorted binary array
    public static int countOnes(int arr[], int n) {
        int l = 0, r = n-1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if ( arr[mid] == 0) {
                r = mid - 1;
            }else if (mid == n-1 || arr[mid+1] != 1) {
                return mid + 1;
            }else {
                l = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 0, 0};
        int n = arr.length;
        System.out.println(countOnes(arr, n));
    }
}
