package com.yinzifan.leetcode._42;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">https://leetcode.com/problems/trapping-rain-water/description/</a>
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * Example 1:
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */

/**
 * 1. 积水的高度由两侧较短的那一条边决定
 * 2. 如果有一端有更高的柱子（右端），积水的高度则依赖于当前方向的高度（从左到右）。
 * 3. 如果发现另一侧（右侧）的柱子不是最高的（左侧出现了比右侧更高的柱子），我们则从反方向开始遍历（从右向左）。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 1, 2, 3, 3, 2, 2, 1, 0}));
    }

    public int trap(int[] height) {
        int result = 0;
        int pl = 0, pr = height.length - 1;
        int leftMax = height[pl], rightMax = height[pr];
        while (pl <= pr) {
            if (height[pl] > leftMax) {
                leftMax = height[pl];
            } else {
                result += leftMax - height[pl];
            }
            if (height[pr] > rightMax) {
                rightMax = height[pr];
            } else {
                result += rightMax - height[pr];
            }
            if (leftMax <= rightMax) pl++;
            else pr--;
        }
        return result;
    }


}
