package me.hansw.fy25;

import java.util.Arrays;
import java.util.List;

public class T495Attack {
    static int attack(int[] time_series, int duration) {
        List<Integer> endTimes = Arrays.stream(time_series).boxed().map(t -> t + duration).toList();

        int accumulated = duration;
        for (int i = 1; i < time_series.length; i++) {
            if (time_series[i] < endTimes.get(i - 1)) {
                accumulated += endTimes.get(i) - endTimes.get(i - 1);
            } else {
                accumulated += duration;
            }
        }
        return accumulated;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 4};
        int d1 = 2;
        System.out.println("attack(t1, d1) = " + attack(t1, d1));

        int[] t2 = {1, 2};
        int d2 = 2;
        System.out.println("attack(t2, d2) = " + attack(t2, d2));
    }
}
