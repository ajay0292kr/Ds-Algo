package Amazon;
import java.util.*;
public class Main {
    public static int[] getSumPair(int arr[], int x) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!countMap.containsKey(x - arr[i])) {
                countMap.put(arr[i], arr[i]);
            }else {
                return new int[]{countMap.get(x-arr[i]), arr[i]};
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 9, 11};
        int x = 9;
        int res[] = getSumPair(arr, x);
        System.out.print("Pair sum: "+ res[0] + " and " +res[1]);
    }
}
