package Array;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int j = 0;
        int curr_sum = 0, result = 0;
        int min_index = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (curr_sum < target) {
                curr_sum+= arr[i];
            }
            if (curr_sum == target) {
                result = curr_sum;
                min_index = j+1;
                p = i;
                break;
            }else if (curr_sum > target) {
                while(curr_sum > target) {
                    curr_sum = curr_sum - arr[j++];
                }
            }
        }
        res.add(min_index);
        res.add(p);
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,7,5}, target = 12;
        ArrayList<Integer> res = subarraySum(arr, target);
        for(Integer a: res) {
            System.out.print(a+" ");
        }
    }
}
