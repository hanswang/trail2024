package me.hansw.fy25;

import java.util.Arrays;

public class T657RobotMove {
    static boolean checkPosition(String move) {
        String[] steps = move.split("");
        long leftMoves = Arrays.stream(steps).filter("L"::equals).count();
        long rightMoves = Arrays.stream(steps).filter("R"::equals).count();
        long upMoves = Arrays.stream(steps).filter("U"::equals).count();
        long downMoves = Arrays.stream(steps).filter("D"::equals).count();

        return leftMoves == rightMoves && upMoves == downMoves;
    }

    public static void main(String[] args) {
        String[] moves = {
                "UD",
                "LL"
        };

        Arrays.stream(moves).forEach(m -> System.out.println(m + ": checkPosition(m) = " + checkPosition(m)));
    }
}
