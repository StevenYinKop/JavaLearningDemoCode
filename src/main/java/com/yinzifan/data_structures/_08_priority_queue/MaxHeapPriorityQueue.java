package com.yinzifan.data_structures._08_priority_queue;

import com.yinzifan.data_structures._03_queue.Queue;
import com.yinzifan.data_structures._09_Heap.MaxHeap;

public class MaxHeapPriorityQueue<T extends Comparable<T>> implements Queue<T>{

	private MaxHeap<T> heap;
	
	@Override
	public void enqueue(T t) {
		heap.add(t);
	}

	@Override
	public T dequeue() {
		return heap.extractMax();
	}

	@Override
	public T getFront() {
		return heap.findMax();
	}

	@Override
	public int getSize() {
		return heap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

}
