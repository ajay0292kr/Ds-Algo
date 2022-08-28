package Array;

public class MissingNumber {
    // Time Complexity: O(N)
    // Auxiliary Space: O(1)
    static void printMissingNumber(int[] arr, int n) {
        // Calculate the sum of number from 1 to N
        int sum = 0;
        for(int i = 1; i <= n+1; i++) {
            sum+=i;
        }
        for(int i = 0; i<n; i++) {
            sum -= arr[i];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        int N = 7;
        printMissingNumber(arr, N);
    }
}
