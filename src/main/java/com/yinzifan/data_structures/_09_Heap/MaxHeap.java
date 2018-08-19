package com.yinzifan.data_structures._09_Heap;

import com.yinzifan.data_structures._01_array.Array;

public class MaxHeap<T extends Comparable<T>> {
	
	private Array<T> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		data = new Array<>();
	}
	
	
	
	public int getSize() {
		return data.getSize();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	private int getParentIndex(int index) {
		if(index == 0) {
			throw new IllegalArgumentException("index = "+index+" doesn`t have parent.");
		}
		return (index - 1) / 2;
	}
	private int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}
	private int getRightChildIndex(int index) {
		return index * 2 + 2;
	}
	
	public void add(T t) {
		data.addLast(t);
		siftUp(data.getSize() - 1);
	}

	public T findMax() {
		if(isEmpty()) {
			throw new IllegalArgumentException("heap is empty.");
		}
		return data.get(0);
	}
	
	public T extractMax() {
		T ret = findMax();
		data.swap(0, getSize() - 1);
		data.removeLast();
		siftDown(0);
		return ret;
	}

	private void siftDown(int i) {
		int leftChild = getLeftChildIndex(i);
		int rightChild = getRightChildIndex(i);
		if(leftChild < getSize()) {
			if(rightChild < getSize()) {
				if(data.get(rightChild).compareTo(data.get(leftChild)) > 0) {
					siftDown(rightChild);
				}
			} else {
				siftDown(leftChild);
			}
		}
	}
	
	private void siftUp(int i) {
//		if(i == 0 || data.get(getParentIndex(i)).compareTo(data.get(i)) > 0) {
//			return;
//		}
		if(i > 0 && data.get(getParentIndex(i)).compareTo(data.get(i)) < 0){
			data.swap(i, getParentIndex(i));
			siftUp(getParentIndex(i));
		}
	}
	
}
