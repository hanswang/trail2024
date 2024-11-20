package me.hansw;

import me.hansw.solver.MergerSolver;

import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        MergerSolver mergerSolver = new MergerSolver();

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println("Intervals: " + Arrays.deepToString(mergerSolver.merge(intervals)));
    }
}
