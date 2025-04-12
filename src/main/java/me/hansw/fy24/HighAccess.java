package me.hansw.fy24;

import java.util.*;

import static java.lang.Integer.parseInt;

public class HighAccess {
    static boolean withinHour(String start, String end) {
        int s_hour = parseInt(start.substring(0, 2));
        int s_min = parseInt(start.substring(2));
        int e_hour = parseInt(end.substring(0, 2));
        int e_min = parseInt(end.substring(2));

        return (s_hour == e_hour) || (s_hour == e_hour -1) && (s_min > e_min);
    }

    static List<String> findHighAccess(List<List<String>> access_times) {
        HashMap<String, List<String>> grouped = new HashMap<>();
        for (List<String> entry : access_times) {
            String name = entry.get(0);
            String time = entry.get(1);

            grouped.putIfAbsent(name, new ArrayList<>());
            grouped.get(name).add(time);
        }

        List<String> highAccess = new ArrayList<>();
        for (String name : grouped.keySet()) {
            List<String> log = grouped.get(name);
            Collections.sort(log);

            for (int i = 0; i < log.size(); i++) {
                String time = log.get(i);
                int logCount = 0;
                for (int j = i+1; j < log.size(); j++) {
                    String nextLog = log.get(j);
                    if (withinHour(time, nextLog)) {
                        logCount +=1;
                    } else {
                        break;
                    }
                }

                if (logCount > 1) {
                    highAccess.add(name);
                    break;
                }
            }

        }

        return highAccess;
    }

    public static void main(String[] args) {
        System.out.println("Initialising ...");

        List<List<String>> access = List.of(
                List.of("a", "0549"),
                List.of("a", "0532"),
                List.of("a", "0621"),
                List.of("b", "0542"),
                List.of("c", "0549")
        );

        System.out.println("Result: " + findHighAccess(access));
    }
}
