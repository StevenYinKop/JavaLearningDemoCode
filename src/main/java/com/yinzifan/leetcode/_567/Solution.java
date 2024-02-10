package com.yinzifan.leetcode._567;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        new Solution().checkInclusion("adc", "dcda");
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        s1 = sortString(s1);
        char[] a2 = s2.toCharArray();
        int left = 0, right = s1.length();
        while (right <= s2.length()) {
            String subString = sortString(s2.substring(left, right));
            if (s1.equals(subString)) return true;
            left++;
            right++;
        }
        return false;
    }

    private String sortString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
