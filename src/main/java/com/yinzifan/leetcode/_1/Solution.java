package com.yinzifan.leetcode._1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = cache.getOrDefault(nums[i], new LinkedList<>());
            list.add(i);
            cache.put(nums[i], list);
        }
        for (int key : cache.keySet()) {
            if (cache.containsKey(target - key)) {

                return cache.get(key) == cache.get(target - key)
                        ? new int[]{cache.get(key).get(0), cache.get(key).get(1)}
                        : new int[]{cache.get(key).get(0), cache.get(target - key).get(0)};
            }
        }
        return null;
    }
}
