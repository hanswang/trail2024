package me.hansw.fy25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

class Price {
    TreeMap<Integer, Set<Integer>> ordered;
    HashMap<Integer, Integer> series;

    public Price () {
        ordered = new TreeMap<>();
        series = new HashMap<>();
    }

    public void update(Integer timestamp, Integer price) {
        // get outdated price if any
        Integer outdatedPrice = series.get(timestamp);
        if (outdatedPrice != null) {
            Set<Integer> oldTsSet = ordered.get(outdatedPrice);
            if (oldTsSet.size() > 1) {
                oldTsSet.remove(timestamp);
                ordered.put(outdatedPrice, oldTsSet);
            } else {
                ordered.remove(outdatedPrice);
            }
        }

        Set<Integer> timestampSet = ordered.getOrDefault(price, new HashSet<>());
        timestampSet.add(timestamp);
        ordered.put(price, timestampSet);
        series.putIfAbsent(timestamp, price);
    }

    public Integer max() {
        return ordered.lastKey();
    }
}

public class T01TimestampPrice {

    public static void main(String[] args) {
        Price price = new Price();

        price.update(1, 10);
        price.update(2, 5);

        System.out.println("price.max() = " + price.max());

        price.update(1, 3);
        System.out.println("price.max() = " + price.max());
        price.update(4, 2);
        System.out.println("price.max() = " + price.max());
    }
}
