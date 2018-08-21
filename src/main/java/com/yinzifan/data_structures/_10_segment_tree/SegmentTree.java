package com.yinzifan.data_structures._10_segment_tree;

public class SegmentTree<T> {
	
	private T[] data;
	private T[] tree;
	
	@SuppressWarnings("unchecked")
	public SegmentTree(T[] arr) {
		data = (T[]) new Object[arr.length];
		for(int i = 0; i<arr.length; i ++) {
			data[i] = arr[i];
		}
		tree = (T[]) new Object[4 * data.length];
	}
	
	public int getSize() {
		return data.length;
	}
	
	public T get(int index) {
		if(index < 0 || index >= data.length) {
			throw new IllegalArgumentException("illegal index: " + index);
		}
		return data[index];
	}

	// 返回完全二叉树的数组中, 一个索引所表示的元素的左孩子的节点的索引
	private int leftChild(int index) {
		return 2 * index + 1;
	}
	// 返回完全二叉树的数组中, 一个索引所表示的元素的右孩子的节点的索引
	private int rightChild(int index) {
		return 2 * index + 2;
	}
}
