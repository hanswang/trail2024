package me.hansw;

import java.util.*;
import java.util.stream.Collectors;

class Ballot {
    String voter;
    String candidate;
}

public class VoteCount {

    static List<String> count(List<String[]> ballots) {
        // [ [x, A], [y, B] ]
        Map<String, Integer> counting = new HashMap<>();

        Map<String, Integer> votingPower = new HashMap<>();
        for (int i = 0; i < ballots.size(); i++) {
            votingPower.put(ballots.get(i)[0], 3);
        }

        for (int i = 0; i < ballots.size(); i++) {
            counting.putIfAbsent(ballots.get(i)[1], 0);

            int power = votingPower.get(ballots.get(i)[0]);
            counting.compute(ballots.get(i)[1], (k, v) -> v + power);

            votingPower.compute(ballots.get(i)[0], (k, v) -> v > 0 ? v - 1 : 0);
        }

        List<String> acs = counting.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue() ).map(
                e -> e.getKey()
        ).collect(Collectors.toList());

        return acs;
    }

    public static void main(String[] args) {
        System.out.println("initialising = " );

        String[] ballot1 = {"A", "X"};
        String[] ballot2 = {"A", "Y"};
        String[] ballot3 = {"B", "Y"};
        String[] ballot4 = {"A", "Z"};
        List<String[]> ballots = List.of(ballot1, ballot2, ballot3, ballot4);

        System.out.println("output = " + count(ballots));
    }
}
