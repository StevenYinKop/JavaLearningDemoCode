package com.yinzifan.hackerrank.log_analysis;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'getStaleServerCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY log_data
     *  3. INTEGER_ARRAY query
     *  4. INTEGER X
     */

    public static List<Integer> getStaleServerCount(int n, List<List<Integer>> log_data, List<Integer> query, int X) {
        // server indexed 1 ~ n

        // log_data: server_id, time
        // 1, 3
        // 2, 6
        // 1, 5

        // x: 5
        // q: 10 - 5 = 5 ~ 10
        // q: 11 - 5 = 6 ~ 11

        // generate Time Interval List
        List<List<Integer>> queryTimeInterval = query.stream().map(q -> {
            List<Integer> timeWindow = new ArrayList<>();
            timeWindow.add(q - X);
            timeWindow.add(q);
            return timeWindow;
        }).collect(Collectors.toList());

        Map<Integer, List<Integer>> busyServerMap = generateBusyServerMap(n, log_data);

        List<Integer> result = new ArrayList<>();

        queryTimeInterval.stream().forEach(ti -> {
            int leftEdge = ti.get(0);
            int rightEdge = ti.get(1);
            List<Integer> subResult = new ArrayList<>();
            busyServerMap.entrySet().forEach(e -> {
                List<Integer> timePointList = e.getValue();
                Boolean noOverlap =
                        timePointList.stream().noneMatch(timePoint -> timePoint >= leftEdge && timePoint <= rightEdge);
                if (noOverlap) {
                    subResult.add(e.getKey());
                }
            });
            result.add(subResult.size());
        });
        return result;
    }

    // 1, [1,2,3]
    // 2, [2,3,4]
    // 3, [5,6]

    private static Map<Integer, List<Integer>> generateBusyServerMap(int n, List<List<Integer>> log_data) {
        Map<Integer, List<Integer>> busyServerMap = new HashMap<>();
        log_data.forEach(ld -> {
            Integer serverId = ld.get(0);
            Integer timePoint = ld.get(1);
            List<Integer> timePointList = busyServerMap.getOrDefault(serverId, new ArrayList<>());
            timePointList.add(timePoint);
            busyServerMap.put(serverId, timePointList);
        });
        IntStream.range(1, n + 1).forEach(idx -> busyServerMap.putIfAbsent(idx, new ArrayList<>()));
        return busyServerMap;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int log_dataRows = Integer.parseInt(bufferedReader.readLine().trim());
        int log_dataColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> log_data = new ArrayList<>();

        IntStream.range(0, log_dataRows).forEach(i -> {
            try {
                log_data.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> query = IntStream.range(0, queryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.getStaleServerCount(n, log_data, query, X);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
