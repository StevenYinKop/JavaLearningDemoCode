package com.yinzifan.leetcode._17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">...</a>
 */
class Solution {
    private final Map<String, String[]> MAPPING = new HashMap<>() {{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        return findCombinations(digits, 0, "");
    }

    public List<String> findCombinations(String digits, int index, String letter) {
        String[] letters = MAPPING.get(digits.charAt(index) + "");
        if (index == digits.length() - 1) {
            return Arrays.stream(letters).map(l -> letter + l).collect(Collectors.toList());
        }
        return Arrays.stream(letters)
                .flatMap(l -> findCombinations(digits, index + 1, letter + l).stream())
                .collect(Collectors.toList());
    }
}
