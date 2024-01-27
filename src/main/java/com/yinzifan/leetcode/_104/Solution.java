package com.yinzifan.leetcode._104;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1157920923/">...</a>
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
public class Solution {

    public int maxDepth(TreeNode root) {
        return calculateDepth(root, 0);
    }

    public int calculateDepth(TreeNode node, int length) {
        if (node == null) {
            return length;
        }
        return Math.max(
                calculateDepth(node.left, length + 1),
                calculateDepth(node.right, length + 1)
        );
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
