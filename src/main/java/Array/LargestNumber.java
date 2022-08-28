package Array;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumber {
    //Input: nums = [3,30,34,5,9]
    // Output: "9534330"
    static String findLargestNumber(int[] arr) {
        Vector<String> result = new Vector<>();
        for (int j : arr) {
            result.add(String.valueOf(j));
        }
        result.sort((x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return xy.compareTo(yx) > 0 ? -1 : 1;
        });
        Iterator<String> itr = result.iterator();
        StringBuilder res = new StringBuilder();
        while (itr.hasNext()) {
            res.append(itr.next());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        int[] nums = {1, 34, 3, 98, 9, 76, 45, 4};
        System.out.println(findLargestNumber(nums));
    }
}
