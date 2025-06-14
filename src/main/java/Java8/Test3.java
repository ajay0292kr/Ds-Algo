package Java8;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m1 = arr[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for(int j = 0; j < m1; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                }
            }
            if(cnt > 0) {
                map.put(i, cnt);
            }

        }
        int res = -1;
        int max = 0;
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            if(max !=m.getValue() && max < m.getValue()) {
                max = m.getValue();
                res = m.getKey();
            }
        }
        return res;
    }
    public static void main(String[] args) {
     int mat[][] = {
                     {0,0},
                     {0,1},{1,1},{0,0},{0,0},{1,1},{0,0},{1,1},{0,1},{1,1},{0,1},{0,0},{0,1},{0,1},{0,0},{0,1},{1,1},{0,0}};
     System.out.print(rowWithMax1s(mat));
    }
}
