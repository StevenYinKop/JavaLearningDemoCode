package com.yinzifan.data_structures._03_queue;

public interface Queue<T> {
	
	void enqueue(T t);
	
	T dequeue();
	
	T getFront();
	
	int getSize();
	
	boolean isEmpty();

}
