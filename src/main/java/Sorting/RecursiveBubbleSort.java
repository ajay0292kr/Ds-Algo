package Sorting;

public class RecursiveBubbleSort {
    static void arrayBubbleSort(int[] a, int n) {
        if (n == 1)
            return;
        for(int i = 0; i<n-1; i++) {
            if(a[i] > a[i+1]) {
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
            }
        }
        arrayBubbleSort(a, n-1);
    }
    public static void main(String[] args) {
        int [] arr = {2, 3, -1, 0, 4, 7, 5};
        int n = arr.length;
        arrayBubbleSort(arr, n);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}