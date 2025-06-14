package Array;

public class RemoveDuplicateArray {
    // Remove duplicate array elements in-place
    public static int removeDuplicates(int[] arr, int n) {
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i-1]) {
                arr[j++] = arr[i];
            }
        }
        return j;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;
        int newLength = removeDuplicates(arr, n);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
