package me.hansw.fy24;

import java.util.*;


class AllOneSolver {
    private HashMap<String, Integer> store;
    private TreeMap<Integer, Set<String>> count;

    public AllOneSolver() {
        store = new HashMap<>();
        count = new TreeMap<>();
    }

    public void inc(String key) {
        store.putIfAbsent(key, 0);
        store.compute(key, (k, c) -> c + 1);

        // setup min & max
        int newV = store.get(key);
        if (newV > 1) {
            Set<String> oldSet = count.get(newV-1);
            oldSet.remove(key);
            count.compute(newV-1, (k, v) -> oldSet.isEmpty() ? null : oldSet);
        }
        Set<String> countSet = count.getOrDefault(newV, new HashSet<>());
        countSet.add(key);
        count.put(newV, countSet);

    }

    public void dec(String key) {
        int existingV = store.get(key);
        if (existingV == 1) {
            store.remove(key);
        } else {
            store.put(key, existingV -1);
        }

        // setup min & max
        Set<String> countSet = count.get(existingV);
        countSet.remove(key);
        count.compute(existingV, (k, v) -> countSet.isEmpty() ? null : countSet);
        if (existingV > 1) {
            Set<String> newSet = count.getOrDefault(existingV -1, new HashSet<>());
            newSet.add(key);
            count.put(existingV - 1, newSet);
        }
    }

    public String getMaxKey() {
        return count.isEmpty() ? "" : count.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return count.isEmpty() ? "" : count.firstEntry().getValue().iterator().next();
    }
}

public class AllOne {
    public static void main(String[] args) {

        System.out.println("Initialising ...");

        String key1 = "hello";
        AllOneSolver allOneSolver = new AllOneSolver();
        allOneSolver.inc(key1);
        allOneSolver.inc(key1);

        System.out.println("maxKey = " + allOneSolver.getMaxKey());
        System.out.println("minKey = " + allOneSolver.getMinKey());

        String key2 = "leet";
        allOneSolver.inc(key2);
        System.out.println("maxKey = " + allOneSolver.getMaxKey());
        System.out.println("minKey = " + allOneSolver.getMinKey());

        System.out.println("Result: " + "expectation");
    }
}
