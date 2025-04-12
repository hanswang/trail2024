package me.hansw.fy25;

import java.util.*;

class BallotV2 {
    String name;
    String vote;

    public BallotV2(String name, String vote) {
        this.name = name;
        this.vote = vote;
    }
}

class Candidate {
    String name;
    Integer count;

    public Candidate(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return name + ": " + count;
    }
}

class CountingSystem {
    public boolean validate(BallotV2[] votes) {
        // rule out self-voter
        for (BallotV2 vote : votes) {
            if (vote.name == vote.vote) {
                return false;
            }
        }

        // rule out invalid ballot by casting more than 3 votes
        Map<String, Integer> limit = new HashMap<>();
        for (BallotV2 vote : votes) {
            if (limit.get(vote.name) == null) {
                limit.put(vote.name, 1);
            } else {
                Integer votedTimes = limit.get(vote.name);
                if (votedTimes >= 3) {
                    return false;
                }
                limit.put(vote.name, votedTimes+1);
            }
        }
        return true;
    }

    public List<Candidate> sort(BallotV2[] votes) {
        Map<String, Integer> count = new HashMap<>();
        for (BallotV2 v : votes) {
            if (count.get(v.vote) == null) {
                count.put(v.vote, 1);
            } else {
                Integer currentCount = count.get(v.vote);
                count.put(v.vote, currentCount+1);
            }
        }

        List<Candidate> rankedVotes = count.entrySet().stream().sorted(
                Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey)
        ).map(e -> new Candidate(e.getKey(), e.getValue())).toList();

        List<Map.Entry<String, Integer>> t = count.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).toList();

        System.out.println("rankedVotes = " + rankedVotes);

        return rankedVotes;
    }
}


public class T02VoterCount {
    public static void main(String[] args) {
        BallotV2[] votes = {
                new BallotV2("A", "X"),
                new BallotV2("A", "X"),
                new BallotV2("B", "Y"),
                new BallotV2("C", "Y"),
                new BallotV2("D", "Y"),
                new BallotV2("A", "Z"),
        };

        CountingSystem countingSystem = new CountingSystem();
        System.out.println("voterCount.validate(votes) = " + countingSystem.validate(votes));

        System.out.println("voterCount.sort(votes) = " + countingSystem.sort(votes));

        int[] testVars = {3, 4, 5};

        Arrays.stream(testVars).forEach(v -> System.out.println("v = " + v));
    }
}
