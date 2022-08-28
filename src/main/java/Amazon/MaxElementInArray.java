package Amazon;

public class MaxElementInArray {
    // Find the maximum element in an array which is first increasing and then decreasing
    //Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
    //Output: 500
    static int findMaximum(int arr[]) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i<n; i++) {
            if (arr[i] > max) {
                max  = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1, 30, 40, 50, 60, 70, 23, 20};
        int n = arr.length;
        System.out.println("The maximum element is "+
                findMaximum(arr));
    }
}
