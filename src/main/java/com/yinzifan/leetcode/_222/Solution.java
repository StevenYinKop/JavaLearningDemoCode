package com.yinzifan.leetcode._222;


import com.yinzifan.leetcode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes/">...</a>
 * <p>
 * Definition for a binary tree node.
 * <p>
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

//        Answer in One Line
//        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
