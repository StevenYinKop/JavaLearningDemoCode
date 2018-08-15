package com.yinzifan.data_structures._03_queue.impl;

import com.yinzifan.data_structures._01_array.Array;
import com.yinzifan.data_structures._03_queue.Queue;

public class ArrayQueue<T> implements Queue<T> {

	private Array<T> array;
	
	
	
	public ArrayQueue(int capacity) {
		array = new Array<>(capacity);
	}

	
	public ArrayQueue() {
		array = new Array<>();
	}


	@Override
	public void enqueue(T t) {
		array.addLast(t);
	}

	@Override
	public T dequeue() {
		return array.removeFirst();
	}

	@Override
	public T getFront() {
		return array.getFirst();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity() {
		return array.getCapacity();
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue: [ ");
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
