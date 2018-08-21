package com.yinzifan.data_structures._09_Heap;

import com.yinzifan.data_structures._01_array.Array;

public class MinHeap<T extends Comparable<T>>{
	private Array<T> data;

	public MinHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MinHeap() {
		data = new Array<>();
	}
	
	public MinHeap(T[] arr) {
	}
	
	public int getSize() {
		return data.getSize();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	private int getParentIndex(int index) {
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

	public T findMin() {
		return data.get(0);
	}
	
	public T extractMin() {
		T ret = findMin();
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);
		return ret;
	}

	private void siftDown(int i) {
		int leftIndex = getLeftChildIndex(i);
		int rightIndex = getRightChildIndex(i);
		int next = 0;
		if(rightIndex <= data.getSize() - 1) {
			if(data.get(leftIndex).compareTo(data.get(rightIndex)) > 0) {
				if(data.get(i).compareTo(data.get(rightIndex)) > 0) {
					next = rightIndex;
					data.swap(i, rightIndex);
				}
			}else {
				if(data.get(i).compareTo(data.get(leftIndex)) > 0) {
					next = leftIndex;
					data.swap(i, leftIndex);
				}
			}
		} else if(leftIndex == data.getSize() - 1 ) {
			if(data.get(i).compareTo(data.get(leftIndex)) > 0) {
				next = leftIndex;
				data.swap(i, leftIndex);
			}
		} else {
			return;
		}
		if(next != 0) {
			siftDown(next);
		}
	}
	
	private void siftUp(int i) {
		if(i == 0) {
			return;
		}
		int parentIndex = getParentIndex(i);
		T parentT = data.get(parentIndex);
		T t = data.get(i);
		if(parentT.compareTo(t) > 0) {
			data.swap(parentIndex, i);
			siftUp(parentIndex);
		}
	}
	
//	public T replace(T t) {
//	}
	
}
