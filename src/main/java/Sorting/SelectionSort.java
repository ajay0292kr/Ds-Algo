package Sorting;

public class SelectionSort {
    // In selection sort we are constantly finding the min element
    static void arraySelectionSort(int[] a) {
        for(int i = 0; i<a.length-1; i++) {
            int index = i;
            for(int j = i+1; j<a.length; j++) {
                if(a[j] < a[index]) {
                    index = j;
                }
            }
            int tmp = a[index];
            a[index] = a[i];
            a[i] = tmp;
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
        arraySelectionSort(arr);
    }
}
