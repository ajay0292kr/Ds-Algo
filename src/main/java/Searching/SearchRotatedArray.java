package Searching;

public class SearchRotatedArray {
    public static int searchSortedRotated(int[] arr, int key) {
        int l = 0, r = arr.length -1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] == key) return mid;

            if (arr[l] <= arr[mid]) {
                if (arr[l] <= key && arr[mid] > key) {
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                if (key > arr[mid] && key <= arr[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {50, 10, 20, 30, 40};
        int key = 10;
        System.out.print(searchSortedRotated(arr, key));
    }
}
