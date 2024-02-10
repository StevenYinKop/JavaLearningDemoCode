package com.yinzifan.leetcode._15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (i != 0 && first == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = -first;
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(List.of(first, nums[left], nums[right]));
                    left++;
                    right--;
                    while (nums[left - 1] == nums[left] && left < right) left++;
                    while (nums[right + 1] == nums[right] && left < right) right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
