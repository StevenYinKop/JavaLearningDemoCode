package com.yinzifan.data_structures._04_linkedlist;

import com.yinzifan.data_structures._02_stack.ArrayStack;
import com.yinzifan.data_structures._02_stack.Stack;

public class LinkedDemo {

	private static final int CNT = 200000;
	public static void main(String[] args) {
		
//		LinkedListStack<Integer> stack = new LinkedListStack<>();
//		for (int i = 0; i < 5; i++) {
//			stack.push(i);
//			System.out.println(stack.toString());
//		}
//		stack.pop();
//		System.out.println(stack.toString());
		System.out.println("spend: " + test(new ArrayStack<>(), CNT) + "s");
		System.out.println("spend: " + test(new LinkedListStack<>(), CNT) + "s");
	}
	private static double test(Stack<Integer> stack, int cnt) {
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < cnt; i++) {
			stack.push(i);
		}
		for (int i = 0; i < cnt; i++) {
			stack.pop();
		}
		long endTime1 = System.currentTimeMillis();
		return (endTime1 - startTime1)/1000.0;
	}
}
