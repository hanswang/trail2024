package me.hansw;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class StockFluctor {
    TreeMap<Integer, Integer> series;
    TreeMap<Integer, Set<Integer>> ordered;

    public StockFluctor() {
        series = new TreeMap<>();
        ordered = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        ordered.putIfAbsent(price, new HashSet<>());

        // set min & max
        if (series.containsKey(timestamp) && series.get(timestamp) != price) {
            Set<Integer> replacedTsSet = ordered.get(series.get(timestamp));
            if (replacedTsSet.size() == 1) {
                ordered.remove((series.get(timestamp)));
            } else {
                replacedTsSet.remove(timestamp);
            }
        }

        ordered.get(price).add(timestamp);
        series.put(timestamp, price);
    }

    public int current() {
        return series.lastEntry().getValue();
    }

    public int maximum() {
        return ordered.lastKey();
    }

    public int minimum() {
        return ordered.firstKey();
    }
}

public class StockFluct {
    public static void main(String[] args) {
        System.out.println("Initialising ...");

        StockFluctor stockFluctor = new StockFluctor();
        stockFluctor.update(1, 10);
        stockFluctor.update(2, 5);

        System.out.println("maxKey = " + stockFluctor.current());
        System.out.println("minKey = " + stockFluctor.maximum());

        stockFluctor.update(1, 3);
        System.out.println("minKey = " + stockFluctor.maximum());

        stockFluctor.update(2, 4);
        System.out.println("minKey = " + stockFluctor.minimum());

        System.out.println("Result: " + "expectation");
    }
}
