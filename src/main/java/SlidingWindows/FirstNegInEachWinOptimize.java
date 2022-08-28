package SlidingWindows;

import java.util.LinkedList;

public class FirstNegInEachWinOptimize {
    static void printFirstNegativeInteger(int arr[], int n, int k) {
        LinkedList<Integer> di = new LinkedList<>();
        int i;
        for (i = 0; i<k; i++) {
            if (arr[i] < 0) di.add(i);
        }
        for (; i<n; i++) {
            if(!di.isEmpty()) {
                System.out.print(arr[di.peek()]+" ");
            }else {
                System.out.print("0"+ " ");
            }
            while(!di.isEmpty() && di.peek() < (i-k+1)) {
                di.remove();
            }
            if (arr[i] < 0)
                di.add(i);
        }

        if(!di.isEmpty()) {
            System.out.print(arr[di.peek()]+" ");
        }else {
            System.out.print("0"+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
    }
}
