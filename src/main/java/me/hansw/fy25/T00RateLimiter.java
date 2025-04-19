package me.hansw.fy25;

import java.util.*;
import java.util.stream.Collectors;

class RequestRecord {
    public List<Integer> timestamps;

    public RequestRecord(int timestamp) {
        this.timestamps = new ArrayList<>(List.of(timestamp));
    }

    public void addTimestamp(int timestamp) {
        this.timestamps.add(timestamp);
    }

    @Override
    public String toString() {
        return timestamps.toString();
    }
}

class RateLimiter {
    private final int USER_THRESHOLD = 3;
    private final int COOLDOWN = 10;
    private final int RESOURCE_CAP = 5;

    Map<String, RequestRecord> userRate;
    Map<String, RequestRecord> resourceLimit;

    public RateLimiter() {
        this.userRate = new HashMap<>();
        this.resourceLimit = new HashMap<>();
    }

    private boolean checkResource(String user_id, int timestamp, String resource, boolean initial) {
        if (this.resourceLimit.get(resource) == null) {
            this.resourceLimit.put(resource, new RequestRecord(timestamp));
        } else {
            RequestRecord resourceRecord = this.resourceLimit.get(resource);
            resourceRecord.timestamps = resourceRecord.timestamps.stream().filter(r -> r + COOLDOWN > timestamp).collect(Collectors.toCollection(ArrayList::new));
            if (resourceRecord.timestamps.size() >= RESOURCE_CAP) {
                if (initial) {
                    this.userRate.put(user_id, null);
                } else {
                    this.userRate.get(user_id).timestamps.removeLast();
                }
                return false;
            }
            resourceRecord.addTimestamp(timestamp);
        }
        return true;
    }

    public boolean checkLimit(String user_id, int timestamp, String resource) {
        if (this.userRate.get(user_id) == null) {
            this.userRate.put(user_id, new RequestRecord(timestamp));
            return checkResource(user_id, timestamp, resource, true);
        } else {
            RequestRecord requestRecord = this.userRate.get(user_id);
            requestRecord.timestamps = requestRecord.timestamps.stream().filter(t -> t + COOLDOWN > timestamp).collect(Collectors.toCollection(ArrayList::new));
            if (requestRecord.timestamps.size() >= USER_THRESHOLD) {
                return false;
            } else {
                requestRecord.addTimestamp(timestamp);
                return checkResource(user_id, timestamp, resource, false);
            }
        }
    }
}

public class T00RateLimiter {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();

        System.out.println("rateLimiter.checkLimit(\"user1\", 1, \"G-apple\") = " + rateLimiter.checkLimit("user1", 1, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user1\", 2, \"G-apple\") = " + rateLimiter.checkLimit("user1", 2, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user1\", 3, \"G-apple\") = " + rateLimiter.checkLimit("user1", 3, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user1\", 4, \"G-apple\") = " + rateLimiter.checkLimit("user1", 4, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user2\", 3, \"G-apple\") = " + rateLimiter.checkLimit("user2", 3, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user2\", 4, \"G-apple\") = " + rateLimiter.checkLimit("user2", 4, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user2\", 5, \"G-apple\") = " + rateLimiter.checkLimit("user2", 5, "G-apple"));
        System.out.println("rateLimiter.checkLimit(\"user1\", 11, \"G-apple\") = " + rateLimiter.checkLimit("user1", 11, "G-apple"));

    }
}
