package me.hansw.fy25;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Student {
    int start;
    int end;

    public Student (int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "[" + this.start + ": " + this.end + "]";
    }
}

public class T1450BusyStudent {

    static int checkStudentNumber(int[] startTime, int[] endTime, int query) {
        List<Student> students = IntStream.range(0, startTime.length).boxed().map(i -> new Student(startTime[i], endTime[i])).toList();

        return (int)students.stream().filter(s -> s.start <= query && s.end >= query).map(s -> {
            System.out.println("s = " + s);
            return s;
        }).count();
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int query = 4;

        System.out.println("checkStudentNumber(startTime, endTime, query) = " + checkStudentNumber(startTime, endTime, query));
    }
}
