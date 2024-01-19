package com.yinzifan.hackerrank.delivery_management_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;


class Result {
    private static final Integer INITIAL_DEGREE = 0;
    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH city
     *  2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        Map<Integer, Set<Integer>> citiesWithTheirNearestCities = new HashMap<>();
        for (int i = 0; i < cityFrom.size(); i++) {
            cacheRoutes(cityFrom, cityTo, i, citiesWithTheirNearestCities);
            cacheRoutes(cityTo, cityFrom, i, citiesWithTheirNearestCities);
        }
        Set<Integer> visitedCities = new HashSet<>();
        Queue<City> orders = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        orders.offer(new City(company, INITIAL_DEGREE)); // [1]
        // [1 1 2 3 1]
        // [2 3 4 5 5]
        // 1
        int currentDegree = INITIAL_DEGREE;
        while (!orders.isEmpty()) {
            City city = orders.peek();
            if (currentDegree != city.getDegree()) {
                currentDegree = city.getDegree();
                orders = orders
                        .stream()
                        .sorted(Comparator.comparingInt(City::getId))
                        .collect(Collectors.toCollection(LinkedList::new));
            }
            city = orders.poll();
            if (visitedCities.contains(city.getId())) {
                continue;
            }
            visitedCities.add(city.getId());
            if (city.getDegree() != 0) {
                result.add(city.getId());
            }
            Set<Integer> nearestCities = citiesWithTheirNearestCities.get(city.getId());
            if (nearestCities != null) {
                for (Integer nearestCity : nearestCities) {
                    if (!visitedCities.contains(nearestCity)) {
                        orders.offer(new City(nearestCity, city.getDegree() + 1));
                    }
                }
            }
        }
        return result;
    }

    private static void cacheRoutes(List<Integer> cityFrom, List<Integer> cityTo, int i, Map<Integer, Set<Integer>> citiesWithTheirNearestCities) {
        int startPoint = cityFrom.get(i);
        Set<Integer> destinations = citiesWithTheirNearestCities.getOrDefault(startPoint, new TreeSet<>());
        destinations.add(cityTo.get(i));
        citiesWithTheirNearestCities.put(startPoint, destinations);
    }
}

class City {
    private int id;
    private int degree;
    City(int id, int degree) {
        this.id = id;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public int getDegree() {
        return degree;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        String[] cityNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int cityNodes = Integer.parseInt(cityNodesEdges[0]);
        int cityEdges = Integer.parseInt(cityNodesEdges[1]);

        List<Integer> cityFrom = new ArrayList<>();
        List<Integer> cityTo = new ArrayList<>();

        IntStream.range(0, cityEdges).forEach(i -> {
            try {
                String[] cityFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                cityFrom.add(Integer.parseInt(cityFromTo[0]));
                cityTo.add(Integer.parseInt(cityFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int company = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.order(cityNodes, cityFrom, cityTo, company);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
