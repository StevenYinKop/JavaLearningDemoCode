package com.yinzifan.leetcode._200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author Steven.Yin
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * @param grid map
     * @param i    x axis
     * @param j    y axis
     */
    private void bfs(char[][] grid, int i, int j) {
        Queue<Coordination> queue = new LinkedList<>();
        queue.offer(new Coordination(i, j));
        while (!queue.isEmpty()) {
            Coordination coordination = queue.poll();
            grid[coordination.i][coordination.j] = '0';
            if (coordination.i - 1 >= 0 && grid[coordination.i - 1][coordination.j] == '1') {
                queue.offer(new Coordination(coordination.i - 1, coordination.j));
            }
            if (coordination.i + 1 < grid.length && grid[coordination.i + 1][coordination.j] == '1') {
                queue.offer(new Coordination(coordination.i + 1, coordination.j));
            }
            if (coordination.j - 1 >= 0 && grid[coordination.i][coordination.j - 1] == '1') {
                queue.offer(new Coordination(coordination.i, coordination.j - 1));
            }
            if (coordination.j + 1 < grid[coordination.i].length && grid[coordination.i][coordination.j + 1] == '1') {
                queue.offer(new Coordination(coordination.i, coordination.j + 1));
            }
        }
    }

    static class Coordination {
        int i;
        int j;

        public Coordination(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
