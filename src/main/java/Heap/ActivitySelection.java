package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    /*
      You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively.
      A single person can perform only one activity at a time, meaning no two activities can overlap.
      Your task is to determine the maximum number of activities that a person can complete in a day.
     */
    static class Activity {
        int start, finish;
        Activity(int s, int f) {
            start = s;
            finish = f;
        }
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        System.out.print(activitySelection(start, finish));
    }
    private static int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }

        // Sort by finish time
        activities.sort(Comparator.comparingInt(a -> a.finish));

        int count = 1; // pick first activity
        int lastFinish = activities.get(0).finish;

        for (int i = 1; i < n; i++) {
            // strictly greater
            if (activities.get(i).start > lastFinish) {
                count++;
                lastFinish = activities.get(i).finish;
            }
        }
        return count;
    }
}
