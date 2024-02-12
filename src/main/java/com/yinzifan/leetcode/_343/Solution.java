package com.yinzifan.leetcode._343;

/**
 * 213, 337, 309
 */
class Solution {
    public static void main(String[] args) {
        new Solution().integerBreak(10);
    }

    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(memo[i], Math.max((i - j) * j, j * memo[i - j]));
            }
        }
        return memo[n];
    }
}