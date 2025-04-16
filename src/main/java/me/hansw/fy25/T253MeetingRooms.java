package me.hansw.fy25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Meeting {
    int start;
    int end;

    public Meeting(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "s: " + this.start + ", e: " + this.end;
    }
}

public class T253MeetingRooms {
    static int checkRooms(int[][] intervals) {
        List<Meeting> bookings = Arrays.stream(intervals).map(i -> new Meeting(i[0], i[1])).sorted(Comparator.comparingInt(m -> m.start)).toList();
        List<Meeting> merged = new ArrayList<>();

        bookings.forEach(b -> {
            if (merged.isEmpty()) {
                merged.add(b);
            } else {
                Meeting lastBooking = merged.getLast();
                if (b.start < lastBooking.end) {
                    merged.add(b);
                } else {
                    lastBooking.end = b.end;
                }
            }
            System.out.println("merged = " + merged);
        });
        return merged.size();
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("checkRooms(intervals1) = " + checkRooms(intervals1));

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("checkRooms(intervals2) = " + checkRooms(intervals2));
    }
}
