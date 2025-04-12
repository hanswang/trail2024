package me.hansw.fy24;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    private final Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());

        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeValues = store.get(key);

        if (timeValues != null) {
            if (timeValues.containsKey(timestamp)) {
                return timeValues.get(timestamp);
            }
            Integer closestTs = timeValues.floorKey(timestamp);
            if (closestTs != null) {
                return timeValues.get(closestTs);
            }
        }

        return "";
    }
}

public class TimeMapStore {
    public static void main(String[] args) {

        System.out.println("Initialising ...");

        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.

        String expected;
        expected = timeMap.get("foo", 1);         // return "bar"
        System.out.println("expected = " + expected);

        expected = timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println("expected = " + expected);

        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        expected = timeMap.get("foo", 4);         // return "bar2"
        System.out.println("expected = " + expected);
        expected = timeMap.get("foo", 5);         // return "bar2"
        System.out.println("expected = " + expected);

        System.out.println("Result: " + "expected");
    }
}
