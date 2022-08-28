package Sorting;

public class ProductOfMinMax {
    // Product of first array max element and second array min element
    // Time complexity = O(n*n)
    public static int productMinMax(int[] arr1, int[] arr2) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int j : arr1) {
            if (j > max) {
                max = j;
            }
        }
        for (int j : arr2) {
            if (j < min) {
                min = j;
            }
        }
        return min*max;
    }
    public static void main(String[] args) {
        int[] arr1 = {5, 7, 9, 3, 6, 2};
        int[] arr2 = {1, 2, 6, -1, 0, 9};
        int result = productMinMax(arr1, arr2);
        System.out.print(result);
    }
}
