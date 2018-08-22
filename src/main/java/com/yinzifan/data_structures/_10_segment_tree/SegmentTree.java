package com.yinzifan.data_structures._10_segment_tree;

public class SegmentTree<T> {
	
	private T[] data;
	private T[] tree;
	private Merger<T> merger;
	@SuppressWarnings("unchecked")
	public SegmentTree(T[] arr, Merger<T> merger) {
		data = (T[]) new Object[arr.length];
		for(int i = 0; i<arr.length; i ++) {
			data[i] = arr[i];
		}
		tree = (T[]) new Object[4 * data.length];
		this.merger = merger;
		buildSegmentTree(0, 0, data.length-1);
	}
	
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if(l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		int mid = l + (r - l) / 2;
		buildSegmentTree(leftTreeIndex, l, mid);
		buildSegmentTree(rightTreeIndex, mid + 1, r);
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i< tree.length; i ++) {
			T t = tree[i];
			if(t != null) {
				sb.append(t);
			}
			if(i != tree.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
