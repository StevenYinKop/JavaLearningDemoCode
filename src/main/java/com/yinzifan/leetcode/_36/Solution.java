package com.yinzifan.leetcode._36;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> cache = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                String rowCache = String.format("row_%s_%s", i, c);
                String colCache = String.format("col_%s_%s", j, c);
                String boxCache = String.format("box_%s_%s_%s", i / 3, j / 3, c);
                if (!cache.add(rowCache) || !cache.add(colCache) || !cache.add(boxCache))
                    return false;
            }
        }
        return true;
    }
}
