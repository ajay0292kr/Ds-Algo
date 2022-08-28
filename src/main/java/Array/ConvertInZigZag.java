package Array;

import java.util.Arrays;

public class ConvertInZigZag {
    // Time complexity: O(n)
    // Auxiliary Space: O(1)
    static void convertZig(int[] arr) {
        Arrays.sort(arr);

        for(int i = 1; i<arr.length-1; i++) {
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        convertZig(arr);
    }
}
