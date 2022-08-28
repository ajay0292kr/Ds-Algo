package Sorting;

public class BubbleSort {
    static void arrayBubbleSort(int[] a) {
        for(int i = 0; i<a.length; i++) {
            for(int j = 0; j<a.length-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
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
        arrayBubbleSort(arr);
    }
}
