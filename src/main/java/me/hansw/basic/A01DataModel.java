package me.hansw.basic;

import java.util.*;
import java.util.stream.Collectors;

public class A01DataModel {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeReview = new TreeMap<>();

        treeReview.put(1, 100);
        treeReview.put(2, 200);
        treeReview.put(3, 150);

        System.out.println("treeMap values = " + Arrays.toString(treeReview.values().toArray()));

        System.out.println("treeMap last key = " + treeReview.lastKey());

        System.out.println("treeMap keys = " + treeReview.keySet());


        Map<Integer, Integer> mapReview = new HashMap<>();

        mapReview.put(1, 100);
        mapReview.put(2, 200);
        mapReview.put(4, 300);
        System.out.println("mapReview = " + mapReview);

        List<Integer> sortedValues = mapReview.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortedValues = " + sortedValues);
    }
}


