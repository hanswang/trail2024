package me.hansw.fy25;

import java.util.Arrays;
import java.util.List;

public class T122MaxProfit {
    static int maxProfit(int[] values) {
        int profit = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[i-1]) {
                profit += values[i] - values[i-1];
            }

        }

        return profit;
    }

    public static void main(String[] args) {
        int[] t1 = {7,1,5,3,6,4};
        System.out.println("maxProfit(t1) = " + maxProfit(t1));

        int[] t2 = {1,2,3,4,5};
        System.out.println("maxProfit(t2) = " + maxProfit(t2));
    }
}
