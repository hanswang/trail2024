package me.hansw.fy24;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombination {
    static List<String> letterCombine(String digits) {
        Map<String, List<String>> pads = Map.of(
                "2", List.of("a", "b", "c"),
                "3", List.of("d", "e", "f"),
                "4", List.of("g", "h", "i"),
                "5", List.of("j", "k", "l"),
                "6", List.of("m", "n", "o"),
                "7", List.of("p", "q", "r", "s"),
                "8", List.of("t", "u", "v"),
                "9", List.of("w", "x", "y", "z")
        );

        String[] digitInput = digits.split("");
        List<String> combined = new ArrayList<>();
        for (String d : digitInput) {
            List<String> letters = pads.get(d);
            if (combined.isEmpty()) {
                combined = letters;
            } else {
                combined = combined.stream().map(c -> letters.stream().map(l -> c + l).collect(Collectors.toList())).flatMap(List::stream).collect(Collectors.toList());
            }
        }

        return combined == null ? List.of() : combined;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        String digits = "";

        System.out.println("Result: " + letterCombine(digits));
    }
}
