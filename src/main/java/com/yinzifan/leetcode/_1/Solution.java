package com.yinzifan.leetcode._1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    Set<Integer> indexCache = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == k || j == k) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(String.format("%d_%d_%d", nums[i], nums[j], nums[k]));
                        indexCache.add(i);
                        indexCache.add(j);
                        indexCache.add(k);
                    }
                }
            }
        }
        return result.stream()
                .map(item -> Arrays.stream(item.split("_"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
