package com.yinzifan.leetcode._424;

import java.util.HashMap;
import java.util.Map;

/**
 * 替换以后的字串包含重复字符串的部分必须是连续的
 * 替换了k次的字符串全部都是相同的。
 * 让其他字符尽可能多地替换成为替换之前出现次数最多的字符
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {
        // 右边界先移动找到一个满足题意的可以替换K个字符以后，所有字符都变成一样的当前看来最长的字串，直到右边界纳入一个字符以后，不能满足条件时停下；
        // 考虑左边界只需要向右移动一格后，右边界就又可以向右移动了，尝试继续找到更长的目标字串。
        // 替换后的最长重复字串就产生在右边界和左边界交替向右移动的过程中。
        int left = 0, right = 0;
        int maxCount = 0;
        int result = 0;
        Map<Character, Integer> cache = new HashMap<>();

        while (right < s.length()) {
            if (right - left + 1 <= result) continue;
            char c = s.charAt(right);
            cache.put(c, 1 + cache.getOrDefault(c, 0));
            maxCount = Math.max(maxCount, cache.get(c));
            while (right - left + 1 - maxCount > k) {
                cache.put(s.charAt(left), cache.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
