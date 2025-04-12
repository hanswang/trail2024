package me.hansw.fy25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

class DuplicateDetector {
    public boolean check(int[] series) {
        Set<Integer> knownNumber = new HashSet<>();
        for (int i = 0; i < series.length; i++) {
            if (knownNumber.contains(series[i])) {
                return false;
            }
            knownNumber.add(series[i]);
        }
        return true;
    }
}

public class T217DetectDup {
    public static void main(String[] args) {
        Random random = new Random();

        int[] t1 = {1, 2, 3, 1};
        int[] t2 = {1, 2, 3, 4};
        int[] t3 = {1, 2, 3, 5};

        int[] t4 = IntStream.range(1, 6).toArray();

        int[] t5 = IntStream.generate(() -> 3).limit(10).toArray();

        int[] t6 = IntStream.generate(() -> random.nextInt(100)).limit(5).toArray();
        int[] t7 = IntStream.generate(() -> random.nextInt(100)).limit(5).toArray();
        int[] t8 = IntStream.generate(() -> random.nextInt(100)).limit(5).toArray();
        int[] t9 = IntStream.generate(() -> random.nextInt(100)).limit(5).toArray();

        DuplicateDetector duplicateDetector = new DuplicateDetector();

        System.out.println("duplicateDetector.check(t1) = " + duplicateDetector.check(t1));

        System.out.println("duplicateDetector.check(t2) = " + duplicateDetector.check(t2));

        System.out.println("duplicateDetector.check(t3) = " + duplicateDetector.check(t3));

        System.out.println("duplicateDetector.check(t4) = " + duplicateDetector.check(t4));

        System.out.println("Arrays.toString(t5) = " + Arrays.toString(t5));
        System.out.println("duplicateDetector.check(t5) = " + duplicateDetector.check(t5));

        System.out.println("Arrays.toString(t6) = " + Arrays.toString(t6));
        System.out.println("duplicateDetector.check(t6) = " + duplicateDetector.check(t6));

        System.out.println("Arrays.toString(t7) = " + Arrays.toString(t7));
        System.out.println("duplicateDetector.check(t7) = " + duplicateDetector.check(t7));

        System.out.println("Arrays.toString(t8) = " + Arrays.toString(t8));
        System.out.println("duplicateDetector.check(t8) = " + duplicateDetector.check(t8));

        System.out.println("Arrays.toString(t9) = " + Arrays.toString(t9));
        System.out.println("duplicateDetector.check(t9) = " + duplicateDetector.check(t9));

    }
}
