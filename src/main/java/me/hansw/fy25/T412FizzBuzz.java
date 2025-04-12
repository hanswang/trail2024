package me.hansw.fy25;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class T412FizzBuzz {
    static List<String> generate(int i) {
        return IntStream.range(1, i + 1).boxed().map(s -> {
            if (s % 15 == 0) {
                return "FizzBuzz";
            } else if (s % 3 == 0) {
                return "Fizz";
            } else if (s % 5 == 0) {
                return "Buzz";
            } else {
                return "" + s;
            }
        }).toList();
    }

    public static void main(String[] args) {
        System.out.println("generate(1) = " + generate(1));
        System.out.println("generate(1) = " + generate(3));
        System.out.println("generate(1) = " + generate(5));
        System.out.println("generate(1) = " + generate(15));
    }
}
