package me.hansw.fy25;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T1366TeamRank {
    static String rank(String[] votes) {
        List<List<String>> ballots = Arrays.stream(votes).map(v -> List.of(v.split(""))).toList();
        Map<String, List<Integer>> counting = new HashMap<>();

        // empty initialisation
        List<Integer> initialised = IntStream.range(0, votes[0].length()).map(v -> 0).boxed().toList();
        for (int i = 0; i < ballots.get(0).size(); i++) {
            counting.put(ballots.get(0).get(i), new ArrayList<>(initialised));
        }

        // loop through votes
        for (int i = 0; i < ballots.get(0).size(); i++) {
            for (int j = 0; j < votes.length; j++) {
                List<Integer> values = counting.get(ballots.get(j).get(i));
                Integer currentValue = values.get(i);
                values.set(i, currentValue + 1);
                counting.put(ballots.get(j).get(i), values);
            }
        }

        // compare
        return counting.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, List<Integer>> o1, Map.Entry<String, List<Integer>> o2) {
                List<Integer> o1Vals = o1.getValue();
                List<Integer> o2Vals = o2.getValue();

                for (int i = 0; i < o1Vals.size(); i++) {
                    if (!o1Vals.get(i).equals(o2Vals.get(i))) {
                        return o2Vals.get(i) - o1Vals.get(i);
                    }
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        }).map(Map.Entry::getKey).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        System.out.println(Arrays.toString(votes) + ", rank: " + rank(votes));
    }
}
