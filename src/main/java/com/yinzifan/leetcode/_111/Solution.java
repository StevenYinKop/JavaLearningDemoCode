package com.yinzifan.leetcode._111;


/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">...</a>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        return calculateDepth(root, 1);
    }

    public int calculateDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth - 1;
        }
        if (node.left == null && node.right == null)
            return depth;
        else if (node.left == null)
            return calculateDepth(node.right, depth + 1);
        else if (node.right == null)
            return calculateDepth(node.left, depth + 1);
        else
            return Math.min(calculateDepth(node.left, depth + 1),
                    calculateDepth(node.right, depth + 1)
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
