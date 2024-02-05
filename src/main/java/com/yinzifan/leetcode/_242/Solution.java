package com.yinzifan.leetcode._242;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> dict = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer num = dict.getOrDefault(c, 0);
            dict.put(c, num + 1);
        }
        for (char c : t.toCharArray()) {
            Integer num = dict.getOrDefault(c, 0);
            if (num == 0) return false;
            else dict.put(c, num - 1);
        }
        return true;
    }
}
