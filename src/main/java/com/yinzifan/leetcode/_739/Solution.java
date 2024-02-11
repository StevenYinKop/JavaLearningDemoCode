package com.yinzifan.leetcode._739;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/description/">https://leetcode.com/problems/daily-temperatures/description/</a>
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
class Solution {
    public int[] dailyTemperatures(int[] ts) {
        int[] result = new int[ts.length];
        Stack<Element> stack = new Stack<>();
        for (int i = 0; i < ts.length; i++) {
            if (stack.isEmpty() || stack.peek().value >= ts[i]) {
                stack.push(new Element(i, ts[i]));
            } else {
                while (!stack.isEmpty() && stack.peek().value < ts[i]) {
                    Element e = stack.pop();
                    result[e.index] = i - e.index;
                }
                stack.push(new Element(i, ts[i]));
            }
        }
        return result;
    }

    private static class Element {
        int index;
        int value;

        Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
