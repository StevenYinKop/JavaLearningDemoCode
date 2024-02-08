package com.yinzifan.leetcode._15;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    Set<Integer> indexCache = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

        }
        return result;
    }
}
