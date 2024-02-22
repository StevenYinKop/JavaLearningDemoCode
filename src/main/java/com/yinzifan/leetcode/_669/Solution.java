package com.yinzifan.leetcode._669;

import com.yinzifan.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/trim-a-binary-search-tree/description/">https://leetcode.com/problems/trim-a-binary-search-tree/description/</a>
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (low > root.val) return trimBST(root.right, low, high);
        if (high < root.val) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
