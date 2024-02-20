package com.yinzifan.leetcode._107;

import com.yinzifan.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;

        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                subResult.add(node.val);
            }
            result.addFirst(subResult);
        }
        return result;
    }
}
