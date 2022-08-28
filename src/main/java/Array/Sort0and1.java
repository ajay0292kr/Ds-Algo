package Array;

import java.util.ArrayList;
import java.util.List;

public class Sort0and1 {
    // increase the index and shift the current elements
    static int[] inputArray = {0, 1, 1, 0, 1, 2, 1, 2, 1, 2, 0, 0, 1};
    static List<Integer> outputArray = new ArrayList<>();
    static int indexOfOne = 0;
    static void print() {
        for(int item: inputArray) {
            if(item == 2) {
                outputArray.add(item);
            }
            else if(item == 1) {
                outputArray.add(indexOfOne, item);
                indexOfOne+=1;
            }
            else if(item == 0) {
                outputArray.add(0, item);
                indexOfOne+=1;
            }
        }
    }
    public static void main(String[] args) {
        print();
        for (int item : outputArray)
            System.out.print(item+", ");
    }
}
