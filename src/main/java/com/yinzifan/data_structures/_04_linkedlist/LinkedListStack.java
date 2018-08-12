package com.yinzifan.data_structures._04_linkedlist;

import com.yinzifan.data_structures._02_stack.Stack;

public class LinkedListStack<T> implements Stack<T> {

	private LinkedList<T> linkedList;
	
	public LinkedListStack() {
		super();
		linkedList = new LinkedList<>();
	}

	@Override
	public void push(T t) {
		linkedList.addFirst(t);
	}

	@Override
	public T pop() {
		return linkedList.removeFirst();
	}

	@Override
	public T peek() {
		return linkedList.getFirst();
	}

	@Override
	public int getSize() {
		return linkedList.getSize();
	}

	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: TOP [ ");
		for (int i = 0; i < linkedList.getSize(); i++) {
			sb.append(linkedList.get(i));
			sb.append(" -> ");
		}
		sb.append("NULL ] ");
		return sb.toString();
		
	}
}
