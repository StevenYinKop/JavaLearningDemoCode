package com.yinzifan.leetcode._238;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">https://leetcode.com/problems/product-of-array-except-self/</a>
 * | 1 | 2 | 3 | 4 |
 * prefix   | 1 | 2 |   |   |
 * postfix  |   |   |   |   |
 * output   |   |   |   |   |
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = postfix[i + 1];
            } else if (i == nums.length - 1) {
                nums[i] = prefix[i - 1];
            } else {
                nums[i] = prefix[i - 1] * postfix[i + 1];
            }
        }
        return nums;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
//    public static void main(String[] args) {
//        new Solution().productExceptSelf(new int[] {1,2,3,4});
//    }
}
