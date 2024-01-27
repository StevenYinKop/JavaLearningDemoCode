package com.yinzifan.leetcode._112;


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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum
                && root.left == null
                && root.right == null) {
            return true;
        }
        int rest = targetSum - root.val;
        return hasPathSum(root.left, rest) || hasPathSum(root.right, rest);
    }
}
