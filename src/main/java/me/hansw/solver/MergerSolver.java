package me.hansw.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergerSolver {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            // check current range with previous recorded interval range
            if (current[0] > previous[1]) {
                merged.add(previous);
                previous = current;
            } else {
                previous[1] = Math.max(current[1], previous[1]);
            }
        }

        merged.add(previous);
        return merged.toArray(new int[merged.size()][]);
    }
}
