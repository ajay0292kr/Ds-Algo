package Backtracking;

import java.util.HashMap;
import java.util.Map;

public class MinimizeUniqueCharInTwoString {
    void minCountUtil(String A, String B, Map<Character, Integer> map, int ans, int index) {
        // If entire string is traversed, then
        // compare current number of distinct
        // characters in A with overall minimum.
        char C[] = A.toCharArray();
        char D[] = B.toCharArray();
        if (index == A.length()) {
            ans = Math.min(ans, map.size());
            return;
        }
        // swap A[i] with B[i], increase count of
        // corresponding character in map and call
        // recursively for next index.
        //swap(C[index], D[index]);
        map.put(A.charAt(index), map.get(A.charAt(index))+1);
        minCountUtil(A, B, map, ans, index + 1);

        // Backtrack (Undo the changes done)
        map.put(A.charAt(index), map.get(A.charAt(index))-1);

        if (map.get(A.charAt(index)) == 0)
            map.remove(A.charAt(index));
    }
    int minCount(String A, String B) {
     int ans = A.length();
     Map<Character, Integer> map = new HashMap<>();
        minCountUtil(A, B, map, ans, 0);
        return ans;
    }
    public static void main(String[] args) {
        String A = "abaaa";
        String B = "bbabb";
        MinimizeUniqueCharInTwoString obj = new MinimizeUniqueCharInTwoString();
        System.out.print(obj.minCount(A, B));
        //return 0;
    }
}
