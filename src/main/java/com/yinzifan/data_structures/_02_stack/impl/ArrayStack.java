package com.yinzifan.data_structures._02_stack.impl;

import com.yinzifan.data_structures._01_array.Array;
import com.yinzifan.data_structures._02_stack.Stack;

public class ArrayStack<T> implements Stack<T> {

	Array<T> array;
	
	
	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}
	
	public ArrayStack() {
		array = new Array<>();
	}

	@Override
	public void push(T t) {
		array.addLast(t);
	}

	@Override
	public T pop() {
		return array.removeLast();
	}

	@Override
	public T peek() {
		return array.getLast();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: [ ");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ] TOP");
		return sb.toString();
	}

}
