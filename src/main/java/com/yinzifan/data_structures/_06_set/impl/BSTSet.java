package com.yinzifan.data_structures._06_set.impl;

import com.yinzifan.data_structures._05_binary_search_tree.BinarySearchTree;
import com.yinzifan.data_structures._06_set.Set;

public class BSTSet<T extends Comparable<T>> implements Set<T> {
	
	private BinarySearchTree<T> bst;

	public BSTSet() {
		bst = new BinarySearchTree<>();
	}
	
	@Override
	public void add(T t) {
		bst.add(t);
	}

	@Override
	public void remove(T t) {
		bst.remove(t);
	}


	@Override
	public boolean contains(T t) {
		return bst.contains(t);
	}

	@Override
	public int getSize() {
		return bst.getSize();
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

}
