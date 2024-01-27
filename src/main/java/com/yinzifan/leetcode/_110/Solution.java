package com.yinzifan.leetcode._110;

import com.yinzifan.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/description/">...</a>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return calculateTreeHeight(root).bool;
    }

    public Result calculateTreeHeight(TreeNode node) {
        if (node == null) return new Result(true, 0);
        Result leftResult = calculateTreeHeight(node.left);
        Result rightResult = calculateTreeHeight(node.right);

        return new Result(
                leftResult.bool && rightResult.bool && Math.abs(leftResult.height - rightResult.height) <= 1,
                Math.max(leftResult.height, rightResult.height) + 1
        );
    }

    public static class Result {
        Boolean bool;
        int height;

        Result(Boolean bool, int height) {
            this.bool = bool;
            this.height = height;
        }
    }
}
