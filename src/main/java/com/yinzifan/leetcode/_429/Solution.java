package com.yinzifan.leetcode._429;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> children;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val) {
 * val = _val;
 * }
 * <p>
 * public Node(int _val, List<Node> _children) {
 * val = _val;
 * children = _children;
 * }
 * };
 */

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                subList.add(node.val);
                node.children
                        .stream()
                        .filter(Objects::nonNull)
                        .forEach(queue::offer);
            }
            list.add(subList);
        }
        return list;
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
