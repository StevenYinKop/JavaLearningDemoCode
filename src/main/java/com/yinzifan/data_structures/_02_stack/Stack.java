package com.yinzifan.data_structures._02_stack;

public interface Stack<T> {
	void push(T t);
	T pop();
	T peek();
	int getSize();
	boolean isEmpty();
}
