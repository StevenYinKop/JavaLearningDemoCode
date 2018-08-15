package com.yinzifan.data_structures._03_queue.impl;

import com.yinzifan.data_structures._03_queue.Queue;

public class LoopQueue <T> implements Queue<T>{

	private T[] data;
	private int front, tail;
	private int size;
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		data = (T[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	public LoopQueue() {
		this(10);
	}
	@Override
	public void enqueue(T t) {
		if((tail + 1) % data.length == front) {
			resize(getCapacity() * 2);
		}
		data[tail] = t;
		tail = (tail + 1) % data.length ;
		size ++;
	}

	@Override
	public T dequeue() {
		if(front == tail) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T res = data[front];
		data[front] = null;
		front = (front + 1) % data.length ;
		size --;
		if(data.length / 4 > size && getCapacity() / 2 != 0) {
			resize(getCapacity() / 2);
		}
		
		return res;
	}
	@Override
	public T getFront() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[front];
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return front == tail;
	}
	public int getCapacity() {
		return data.length - 1;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		T[] newData = (T[]) new Object[newCapacity + 1];
		for (int i = 0; i < size; i++) {
			int cnt = (front + i) % data.length;
			newData[i] = data[cnt];
		}
		data = newData;
		front = 0;
		tail = size;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("LoopQueue: [ ");
		for(int i = front; i != tail; i = (i + 1) % data.length) {
			sb.append(data[i] + " ");
		}
		sb.append(" ] TAIL  CAPACITY: " + data.length);
		return sb.toString();
	}
	
}
