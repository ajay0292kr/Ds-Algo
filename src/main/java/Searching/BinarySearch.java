package Searching;

public class BinarySearch {
    // Time Complexity: O(log n)
    // Auxiliary Space: O(1)
    public static int binarySearchElement(int[] arr, int l, int r, int x) {
        // Recursive approach
      /*  if(l == r) return 0;
        if(l > r) return -1;
        if(r >=l) {
            int mid = l+ (r-l)/2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) return binarySearchElement(arr, l, mid - 1, x);
            return binarySearchElement(arr, mid + 1, r, x);
        }
        return -1; */

        // Iterative approach
        while (r >= l) {
            int mid = l+(r-l)/2;
            if(arr[mid] == x) return mid;
            if(arr[mid] < x)
                l = mid+1;
            else
                r = mid-1;

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int x = 110;
        System.out.print(binarySearchElement(arr, 0, arr.length, x));
    }
}
