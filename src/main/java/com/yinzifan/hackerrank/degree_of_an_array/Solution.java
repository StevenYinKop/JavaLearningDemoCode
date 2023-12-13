package com.yinzifan.hackerrank.degree_of_an_array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'degreeOfArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int degreeOfArray(List<Integer> arr) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        IntStream.range(0, arr.size()).forEach(idx -> {
            List<Integer> degreeList = memo.getOrDefault(arr.get(idx), new ArrayList<>());
            degreeList.add(idx);
            memo.put(arr.get(idx), degreeList);
        });
        List<Integer> maxDegreeNumbers = findMaxDegreeArray(memo);
        return maxDegreeNumbers.stream().map(n -> calculateLength(memo.get(n))).min(Integer::compare).get();
    }

    private static Integer calculateLength(List<Integer> arrayList) {
        int size = arrayList.size();
        return arrayList.get(size - 1) - arrayList.get(0) + 1;
    }

    private static List<Integer> findMaxDegreeArray(final Map<Integer, List<Integer>> memo) {
        Integer max = memo.values().stream().max(Comparator.comparingInt(List::size)).get().size();
        return memo.entrySet().stream().filter(i -> max.equals(i.getValue().size())).map(Map.Entry::getKey)
                .collect(toList());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/test.txt"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        int result = Result.degreeOfArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
