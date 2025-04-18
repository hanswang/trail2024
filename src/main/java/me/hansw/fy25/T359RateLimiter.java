package me.hansw.fy25;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Logger {
    Map<String, Integer> track;

    public Logger() {
        this.track = new HashMap<>();
    }

    public boolean shouldLog(int time, String message) {
        if (this.track.get(message) == null) {
            this.track.put(message, time);
            return true;
        } else {
            Integer lastRecordTime = this.track.get(message);
            if (time >= lastRecordTime + 10) {
                this.track.put(message, time);
            }

            // old message cleanup
            Map<String, Integer> ttlTrack = this.track.entrySet().stream()
                    .filter(l -> l.getValue() + 10 >= time)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            this.track = ttlTrack;

            return time >= lastRecordTime + 10;
        }
    }
}

public class T359RateLimiter {
    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println("logger.shouldLog(1, \"foo\") = " + logger.shouldLog(1, "foo"));
        System.out.println("logger.shouldLog(2, \"bar\") = " + logger.shouldLog(2, "bar"));
        System.out.println("logger.shouldLog(3, \"foo\") = " + logger.shouldLog(3, "foo"));
        System.out.println("logger.shouldLog(8, \"bar\") = " + logger.shouldLog(8, "bar"));
        System.out.println("logger.shouldLog(10, \"foo\") = " + logger.shouldLog(10, "foo"));
        System.out.println("logger.shouldLog(11, \"foo\") = " + logger.shouldLog(11, "foo"));
    }
}
