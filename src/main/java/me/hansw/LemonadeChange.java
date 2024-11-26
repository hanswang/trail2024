package me.hansw;

import java.util.*;

public class LemonadeChange {

    static boolean isPayable(int bill, Map<Integer, Integer> changes) {
        if (bill == 5) {
            return true;
        }
        List<Integer> notes = new ArrayList<>(changes.keySet());
        notes.sort(Comparator.reverseOrder());

        for (int note : notes) {
            int count = Math.floorDiv(bill-5, note);
            int existing = changes.get(note);
            if (count >= existing) {
                changes.remove(note);
                bill -= note * existing;
            } else if (count > 0) {
                changes.put(note, existing - count);
                bill -= note * count;
            }
            if (bill == 5) {
                return true;
            }
        }
        return false;
    }

    static boolean change(int[] bills) {
        Map<Integer, Integer> changes = new HashMap<>();

        for (int bill : bills) {
            if (isPayable(bill, changes)) {
                changes.putIfAbsent(bill, 0);
                changes.compute(bill, (k, v) -> v + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("Initialising ...");

        int[] bills = {5,5,5,10,20};

        System.out.println("Result: " + change(bills));
    }
}
