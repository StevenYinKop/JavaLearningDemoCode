package com.yinzifan.leetcode._20;

import java.util.LinkedList;
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
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid2("()")); // true
		System.out.println(s.isValid2("[()]")); // true
		System.out.println(s.isValid2("{{()]")); // false
		System.out.println(s.isValid2("[{}()]")); // true
		System.out.println(s.isValid2("[{]}")); // false
	}

    public boolean checkOnlyBracket (char c) {
		return c == '(' || c == ')'
    			|| c == '[' || c == ']'
    			|| c == '{' || c == '}';
    }
    public boolean isClosedBrace(char left, char right) {
    	return left == '(' && right == ')'
    			|| left == '[' && right == ']'
    			|| left == '{' && right == '}';
    }

    public boolean checkRightBrace(char c) {
		return
    			c == ')'
    			|| c == ']'
    			|| c == '}';
    }

	public boolean isValid2(String s) {
		// ()[]{}
		// ({[]})
		LinkedList<Character> stack = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c == '[' || c == '(' || c == '{') {
				stack.add(c);
			} else {
				if (stack.isEmpty()) return false;
				char removedC = stack.removeLast();
				if (!(removedC == '[' && c == ']'
						|| removedC == '{' && c == '}'
						|| removedC == '(' && c == ')'))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
