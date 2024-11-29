package me.hansw;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RankTeams {
    static String rank(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }

        Map<String, int[]> count = new HashMap<>();

        // filling the voting counts
        for (int i = 0; i < votes.length; i++) {
            // pick a vote
            String[] vote = votes[i].split("");

            for (int j = 0; j < vote.length; j++) {
                // count vote by sequence
                String team = vote[j];
                // count toward the team rank
                if (!count.containsKey(team)) {
                    count.put(team, new int[vote.length]);
                }
                count.get(team)[j] += 1;
            }
        }

        // sort by votes
        String ranked = count.entrySet().stream().sorted((a, b) -> {
            int[] positionedVotesA = a.getValue();
            int[] positionedVotesB = b.getValue();

            for (int i = 0; i < positionedVotesA.length; i++) {
                if (positionedVotesA[i] > positionedVotesB[i]) {
                    return -1;
                } else if (positionedVotesA[i] < positionedVotesB[i]) {
                    return 1;
                }
            }

            // tied till all the votes count, start the alphabetic order
            return a.getKey().compareTo(b.getKey());
        }).map(stringEntry -> stringEntry.getKey()).collect(Collectors.joining());

        return ranked;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};

        System.out.println("Result: " + rank(votes));
    }
}
