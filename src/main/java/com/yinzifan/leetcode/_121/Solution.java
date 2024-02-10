package com.yinzifan.leetcode._121;

class Solution {
    public int maxProfit(int[] prices) {
        // buy low, sell high
        int buy = 0, sell = 1;
        int maxProfit = 0;
        while (sell < prices.length) {
            if (prices[buy] < prices[sell])
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            else
                buy = sell;
            sell++;
        }
        return maxProfit;
    }
}
