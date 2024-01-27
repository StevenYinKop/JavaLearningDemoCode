package com.yinzifan.leetcode._257;

import com.yinzifan.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-paths/description/">...</a>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> res = new LinkedList<>();
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
        }
        if (root.left != null) {
            List<String> paths = binaryTreePaths(root.left);
            paths.forEach(path -> res.add(root.val + "->" + path));
        }
        if (root.right != null) {
            List<String> paths = binaryTreePaths(root.right);
            paths.forEach(path -> res.add(root.val + "->" + path));
        }
        return res;
    }

//    class Solution {
//        List<String> list = new ArrayList<>();
//        public List<String> binaryTreePaths(TreeNode root) {
//            dfs(root,"");
//            return list;
//        }
//        public void dfs(TreeNode root, String cur){
//            if(root == null){
//                return;
//            }
//            if(root.left == null && root.right == null){
//                list.add(cur+root.val);
//            }
//            dfs(root.left,cur+root.val+"->");
//            dfs(root.right,cur+root.val+"->");
//        }
//    }
}
