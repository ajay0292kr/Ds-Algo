package General;

public class ClosestNumber {
    public static int findClosest(int arr[], int n, int target) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (Math.abs(arr[l] - target) <= Math.abs(arr[r] - target)) {
                r--;
            }else {
                l++;
            }
        }
        return arr[l];
    }
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 8, 9 };
        int n = arr.length;
        int target = 4;
        System.out.println(findClosest(arr, n, target));
    }
}
