package Amazon;

import java.util.ArrayList;

public class MaximumSumMatrix {
    static int N;
    // Find row with maximum sum in a Matrix
    static ArrayList<Integer> colMaxSum(int mat[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int idx = -1;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i< N; i++) {
            int sum = 0;
            for (int j = 0; j< N; j++) {
                sum += mat[i][j];

                if (maxSum < sum) {
                    maxSum = sum;

                    idx = i;
                }
            }
        }
        ans.add(idx);
        ans.add(maxSum);
        return ans;
    }
    public static void main(String[] args) {
        N = 5;
        int[][] mat = {
                { 1, 2, 3, 4, 5 },
                { 5, 3, 1, 4, 2 },
                { 5, 6, 7, 8, 9 },
                { 0, 6, 3, 4, 12 },
                { 9, 7, 12, 4, 3 },
        };
        ArrayList<Integer> ans = colMaxSum(mat);
        System.out.println("Row "+ (ans.get(0)+1)+ " has max sum "
                + ans.get(1));
    }
}
