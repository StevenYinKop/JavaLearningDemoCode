package com.yinzifan.leetcode._128;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Map<Integer, Integer> countCache = new LinkedHashMap<>();
        Set<Integer> cache = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (cache.contains(num - 1) || countCache.containsKey(num)) {
                continue;
            }
            int max = 1;
            int i = num + 1;
            while (cache.contains(i)) {
                if (countCache.containsKey(i)) {
                    max += countCache.get(i);
                    break;
                } else {
                    max++;
                    i++;
                }
            }
            countCache.put(num, max);
            result = Math.max(result, max);
        }
        return result;
    }
}
