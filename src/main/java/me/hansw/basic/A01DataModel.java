package me.hansw.basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A01DataModel {

    static void treeMapReview() {
        TreeMap<Integer, Integer> treeReview = new TreeMap<>();

        treeReview.put(1, 100);
        treeReview.put(2, 200);
        treeReview.put(3, 150);

        System.out.println("treeMap values = " + Arrays.toString(treeReview.values().toArray()));

        System.out.println("treeMap last key = " + treeReview.lastKey());

        System.out.println("treeMap keys = " + treeReview.keySet());
    }

    static void hashMapReview() {

        Map<Integer, Integer> mapReview = new HashMap<>();

        mapReview.put(1, 100);
        mapReview.put(2, 200);
        mapReview.put(4, 300);
        System.out.println("mapReview = " + mapReview);

        List<Integer> sortedValues = mapReview.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortedValues = " + sortedValues);
    }

    static void arrayReview() {
        Random random = new Random();

        /**
         * Arrays in Java are a fundamental data structure used to store collections of elements,
         * typically of the same type. They are objects in Java, which means they are created on
         * the heap, and can hold primitives (like int, char) or objects (like String, Integer).
         *
         * Pros:
         * 1. Fixed size
         * 2. performance
         * 3. Homogeneity
         *
         * Cons:
         * 1. Inflexibility in Size Adjustment
         * 2. Lack of High-Level Operations like searching, sorting, or adding.
         * While Java provides utility classes like Arrays in java.util for common operations,
         * these are not as extensive or integrated as those available for ArrayLists.
         */
        int[] t1 = IntStream.generate(() -> 5).limit(10).toArray();
        System.out.println("Arrays.toString(t1) = " + Arrays.toString(t1));

        int[] t2 = IntStream.generate(() -> random.nextInt(10)).limit(10).toArray();
        System.out.println("Arrays.toString(t2) = " + Arrays.toString(t2));

        // boxed on primitive stream - convert int to Integer -
        List<Integer> t3 = IntStream.generate(() -> random.nextInt(10)).limit(10).boxed().toList();
        System.out.println("t3 = " + t3);

        List<Integer> t4 = Arrays.asList(5, 5, 5, 5, 5);
        System.out.println("t4 = " + t4);

        /**
         * ArrayLists in Java are part of the java.util package and are a dynamic array implementation of
         * the List interface. Unlike standard arrays, ArrayLists can dynamically resize themselves,
         * providing more flexibility in handling collections of objects
         *
         *
         * ArrayLists are generally faster for storing and accessing data,
         * while LinkedLists are faster in manipulating data, such as inserting and deleting elements in the middle of the list
         */
        List<Integer> t5 = new ArrayList<>();
        t5.add(8);
        t5.add(7);
        t5.add(6);
        t5.add(5);
        t5.add(4);
        t5.add(3, 10);
        t5.addFirst(11);
        t5.addLast(15);
        t5.addLast(16);
        t5.addLast(17);
        t5.remove(t5.size() - 2);

        System.out.println("t5 = " + t5);

        // predicate - lambda
        System.out.println("t5 filtered = " + t5.stream().filter(v -> v > 5).toList());
    }

    public static void main(String[] args) {
        /**
         * treemap review - sort on KEY
         *
         * O(log n)
         */
        treeMapReview();

        /**
         * hashmap review
         */
        hashMapReview();

        /**
         * Array review & List
         */

        arrayReview();
    }

}


