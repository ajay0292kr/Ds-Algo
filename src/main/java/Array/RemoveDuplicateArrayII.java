package Array;

// Remove in-place sort using two pointer
public class RemoveDuplicateArrayII {
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] !=arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newLength = removeDuplicates(arr);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
