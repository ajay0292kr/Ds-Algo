package Array;

import java.util.ArrayList;
import java.util.Stack;

public class LeadersElement {
    // Leaders element in an array
    // Last element should always add in result
    static ArrayList<Integer> findLeaders(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int max = arr[n-1];
        st.add(max);
        for(int i = n-2; i>=0; i--) {
            if(arr[i] >= max) {
                st.add(arr[i]);
                max = arr[i];
            }
        }
        while(!st.isEmpty()) {
            result.add(st.pop());
        }
        return result;
    }
    public static void main(String[] args) {
      int[] arr = {16, 17, 4, 3, 5, 2};
      int n = arr.length;
      ArrayList<Integer> list = findLeaders(arr, n);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
