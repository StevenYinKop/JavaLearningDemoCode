package com.yinzifan.leetcode._125;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/description/">https://leetcode.com/problems/valid-palindrome/description/</a>
 */
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!inRange(ci)) {
                i++;
                continue;
            }
            if (!inRange(cj)) {
                j--;
                continue;
            }
            if (ci != cj) return false;
            i++;
            j--;
        }
        // a-z: 97 - 122.
        // 0-9: 48 – 57.
        return true;
    }

    private boolean inRange(char c) {
        return c >= 97 && c <= 122 || c >= 48 && c <= 57;
    }
}
