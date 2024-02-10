package com.yinzifan.leetcode._3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">https://leetcode.com/problems/longest-substring-without-repeating-characters/description/</a>
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring2("pwwkew");
    }

    public int lengthOfLongestSubstring(String str) {
        LinkedList<Character> subStringList = new LinkedList<>();
        Set<Character> cache = new HashSet<>();
        int result = 0;
        for (char c : str.toCharArray()) {
            if (cache.contains(c)) {
                char removedC = subStringList.removeFirst();
                while (removedC != c) {
                    cache.remove(removedC);
                    removedC = subStringList.removeFirst();
                }
                subStringList.add(removedC);
                result = Math.max(result, subStringList.size());
            } else {
                cache.add(c);
                subStringList.add(c);
                result = Math.max(result, subStringList.size());
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int max = 0;
        int[] arr = new int[128];
        int r = 0;
        int l = 0;
        for (r = 0; r < n; r++) {
            int c = s.charAt(r);
            l = Math.max(arr[c], l);
            max = Math.max(max, r - l + 1);
            arr[c] = r + 1;
        }
        return max;

    }
}
