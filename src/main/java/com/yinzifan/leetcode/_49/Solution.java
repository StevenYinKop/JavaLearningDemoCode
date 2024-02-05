package com.yinzifan.leetcode._49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) {
                cnt[c - 'a']++;
            }
            String key = joinCount(cnt);
            List<String> subResult = resultMap.getOrDefault(key, new ArrayList<>());
            subResult.add(str);
            resultMap.put(key, subResult);
        }
        return new ArrayList<>(resultMap.values());
    }

    private String joinCount(int[] cnt) {
        return Arrays.stream(cnt)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("_"));
    }
}
