package General;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalProblem {
    public static class Interval {
        int startTime, endTime;
        Interval(int startTime, int endTime) {
            super();
            this.startTime = startTime;
            this.endTime = endTime;
        }
    };
    static boolean isIntersect(Interval arr[], int n) {
      Arrays.sort(arr, Comparator.comparingInt(i -> i.startTime));

      for (int i = 1; i < n; i++) {
          if (arr[i-1].endTime > arr[i].startTime) {
              return true;
          }
      }
      return false;
    }
    public static void main(String[] args) {
        Interval arr1[] = { new Interval(1, 3),
                new Interval(7, 9),
                new Interval(4, 6),
                new Interval(10, 13) };
        int n1 = arr1.length;

        if (isIntersect(arr1, n1))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");

        Interval arr2[] = { new Interval(6, 8),
                new Interval(1, 3),
                new Interval(2, 4),
                new Interval(4, 7) };
        int n2 = arr2.length;

        if (isIntersect(arr2, n2))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");
    }
}
