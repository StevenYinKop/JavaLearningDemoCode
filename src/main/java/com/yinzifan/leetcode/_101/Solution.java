package com.yinzifan.leetcode._101;

import com.yinzifan.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);


    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right == null || left == null && right != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
