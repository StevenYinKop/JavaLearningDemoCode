package com.yinzifan.leetcode._22;

import java.util.ArrayList;
import java.util.List;

/**
 * Example: n = 3
 * 1. 3 open parentheses + 3 close parentheses
 * 2. Only start with open parentheses
 * 3. add "(" at first
 * 4. try "(" and ")".
 */
class Solution {
    private int target;
    private List<String> answer;

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        target = n * 2;
        backtrack(new StringBuilder(), 0, 0);
        return answer;
    }

    private void backtrack(StringBuilder current, int left, int right) {
        if (current.length() == target) {
            answer.add(current.toString());
            return;
        }
        if (left < target / 2) {
            current.append("(");
            backtrack(current, left + 1, right);
            current.deleteCharAt(current.length() - 1);
        }
        if (left > right) {
            current.append(")");
            backtrack(current, left, right + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
