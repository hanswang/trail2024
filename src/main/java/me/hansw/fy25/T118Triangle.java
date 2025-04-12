package me.hansw.fy25;

import java.util.ArrayList;
import java.util.List;

public class T118Triangle {
    static List<List<Integer>> triangle(int level) {
        if (level == 1) {
            return new ArrayList<>(List.of(List.of(1)));
        }

        List<List<Integer>> lowerTriangle = triangle(level - 1);
        List<Integer> lastRow = lowerTriangle.get(lowerTriangle.size() - 1);
        List<Integer> row = new ArrayList<>(lastRow);

        row.add(1);
        for (int i = 1; i < lastRow.size(); i++) {
            row.remove(i);
            row.add(i, lastRow.get(i-1) + lastRow.get(i));
        }

        lowerTriangle.add(row);
        return lowerTriangle;
    }

    public static void main(String[] args) {

        System.out.println("triangle(level) = " + triangle(1));

        System.out.println("triangle(level) = " + triangle(2));

        System.out.println("triangle(level) = " + triangle(3));

        System.out.println("triangle(level) = " + triangle(4));
        System.out.println("triangle(level) = " + triangle(5));
        System.out.println("triangle(level) = " + triangle(6));
    }
}
