package Array;

import java.util.Arrays;

public class RearrangeArrayAlternately {
    // Input: A[] = {1, 2, 3, 4, 5, 6, 7}
    //Output: {7, 1, 6, 2, 5, 3, 4}
    // Time complexity = O(nlogn)
    // Space complexity = O(1)
    static void reArrangeArray(int []arr, int n) {
        Arrays.sort(arr);
        int l = 0;
        int r = n-1;
        while(l<r) {
            System.out.print(arr[r--]+" ");
            System.out.print(arr[l++]+" ");
        }
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int n = A.length;
        reArrangeArray(A, n);
    }
}
