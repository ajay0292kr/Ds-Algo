package Sorting;

public class InsertionSort {
    static void arrayInsertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int key = a[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        printArray(a);
    }
    static void printArray(int[] a) {
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {2, 3, -1, 0, 4, 7, 5};
        arrayInsertionSort(arr);
    }
}
