package com.yinzifan.leetcode._98;

import com.yinzifan.leetcode.TreeNode;

/**
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(
            TreeNode node,
            TreeNode max,
            TreeNode min
    ) {
        if (node == null) return true;
        if (max != null && max.val <= node.val) return false;
        if (min != null && min.val >= node.val) return false;
        return isValidBST(node.left, node, min)
                && isValidBST(node.right, max, node);
    }
}
