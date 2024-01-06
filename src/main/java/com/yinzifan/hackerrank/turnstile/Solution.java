package com.yinzifan.hackerrank.turnstile;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

class Result {

    private static final Integer ENTER = 0;
    private static final Integer EXIT = 0;

    /*
     * Complete the 'getTimes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY time
     *  2. INTEGER_ARRAY direction
     */

    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        //        [0,0,0] time
        //        [0,1,1] direction
        //        [2,0,1] result
        // used as entrance -> enter one goes first
        Queue<Student> enterQ = new LinkedList<>();
        Queue<Student> exitQ = new LinkedList<>();

        Integer[] records = new Integer[time.size()];
        // assemble queue for two directions
        // 0 -> enter
        for (int i = 0; i < time.size(); i++) {
            Student student = new Student(i, time.get(i), direction.get(i));
            if (student.getDirection() == 0) {
                enterQ.offer(student);
            } else {
                exitQ.offer(student);
            }
        }
        Student lastStudent = null;
        Integer clock = time.get(0);
        while (!enterQ.isEmpty() && !exitQ.isEmpty()) {
            Student stuEnter = enterQ.peek();
            Student stuExit = exitQ.peek();
            stuEnter.setTime(Math.max(stuEnter.getTime(), clock));
            stuExit.setTime(Math.max(stuExit.getTime(), clock));
            if (clock < stuExit.getTime() && clock < stuEnter.getTime()) {
                clock++;
                continue;
            }
            if (stuEnter.getTime() < stuExit.getTime()) {
                // enter
                lastStudent = enterQ.poll();
            } else if (stuEnter.getTime() > stuExit.getTime()) {
                // exit
                lastStudent = exitQ.poll();
            } else {
                if (prevSecUsedAsAnEntrance(clock, lastStudent)) {
                    lastStudent = enterQ.poll();
                } else {
                    lastStudent = exitQ.poll();
                }
            }
            lastStudent.setTime(clock);
            records[lastStudent.getIndex()] = lastStudent.getTime();
            clock++;
        }
        for (Student student : enterQ) {
            student.setTime(Math.max(student.getTime(), clock++));
            records[student.getIndex()] = student.getTime();
        }
        for (Student student : exitQ) {
            student.setTime(Math.max(student.getTime(), clock++));
            records[student.getIndex()] = student.getTime();
        }
        return Arrays.asList(records);
    }

    private static boolean prevSecUsedAsAnEntrance(Integer clock, Student student) {
        //        return student == null || !Objects.equals(student.getDirection(), ENTER) || clock != student.getTime() + 1;
        return student != null && Objects.equals(student.getDirection(), ENTER) && clock == student.getTime() + 1;
    }
}

class Student {
    private Integer index;
    private Integer time;
    private Integer direction;
    public Student(Integer index, Integer time, Integer direction) {
        this.index = index;
        this.time = time;
        this.direction = direction;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Integer getDirection() {
        return this.direction;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int timeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> time = IntStream.range(0, timeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int directionCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> direction = IntStream.range(0, directionCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        List<Integer> result = Result.getTimes(time, direction);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
