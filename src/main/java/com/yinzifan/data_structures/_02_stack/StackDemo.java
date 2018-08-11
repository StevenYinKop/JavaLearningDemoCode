package com.yinzifan.data_structures._02_stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> arr = new ArrayStack<>();
		for (int i = 0; i < 10; i++) {
			arr.push(i);
		}
		System.out.println(arr.toString());
		arr.pop();
		System.out.println(arr.toString());
	}
}
