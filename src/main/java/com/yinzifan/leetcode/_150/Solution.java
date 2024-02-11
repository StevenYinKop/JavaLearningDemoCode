package com.yinzifan.leetcode._150;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/description/">https://leetcode.com/problems/evaluate-reverse-polish-notation/description/</a>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * 1. The valid operators are '+', '-', '*', and '/'.
 * 2. Each operand may be an integer or another expression.
 * 3. The division between two integers always truncates toward zero.
 * 4. There will not be any division by zero.
 * 5. The input represents a valid arithmetic expression in a reverse polish notation.
 * 6. The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                String result = calculate(stack.pop(), stack.pop(), token);
                stack.push(result);
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private String calculate(String str1, String str2, String operator) {
        int result = switch (operator) {
            case "+" -> Integer.parseInt(str2) + Integer.parseInt(str1);
            case "-" -> Integer.parseInt(str2) - Integer.parseInt(str1);
            case "*" -> Integer.parseInt(str2) * Integer.parseInt(str1);
            default -> Integer.parseInt(str2) / Integer.parseInt(str1);
        };
        return result + "";
    }
}
