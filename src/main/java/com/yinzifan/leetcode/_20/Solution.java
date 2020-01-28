package com.yinzifan.leetcode._20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for (int i = 0; i < s.length(); i ++) {
    		char c = s.charAt(i);
    		if (!checkOnlyBracket(c)) {
    			return false;
    		}
    		if (checkRightBrace(c)) {
    			if (stack.isEmpty()) {
    				return false;
    			}
    			while(!isClosedBrace(stack.pop(), c)) {
    				return false;
    			}
    		} else {
    			stack.push(c);
    		}
    	}
    	return stack.isEmpty();
    }
    public boolean checkOnlyBracket (char c) {
    	return c == '(' || c == ')' 
    			|| c == '[' || c == ']'
    			|| c == '{' || c == '}';
    }
    public boolean checkRightBrace(char c) {
    	return 
    			c == ')'
    			|| c == ']'
    			|| c == '}';
    }
    public boolean isClosedBrace(char left, char right) {
    	return left == '(' && right == ')'
    			|| left == '[' && right == ']'
    			|| left == '{' && right == '}';
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("()")); // true
		System.out.println(s.isValid("[()]")); // true
		System.out.println(s.isValid("{{()]")); // false
		System.out.println(s.isValid("[{}()]")); // true
		System.out.println(s.isValid("[{]}")); // false
	}
}
