package com.yinzifan.leetcode._155;

import java.util.Stack;

class MinStack {
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(
                new Node(
                        val,
                        stack.isEmpty() ? val : Math.min(val, stack.peek().minValue)
                )
        );
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;

    }

    public int getMin() {
        return stack.peek().minValue;
    }

    private static class Node {
        Integer value;
        Integer minValue;

        public Node(Integer value, Integer minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
