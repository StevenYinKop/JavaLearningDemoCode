package com.yinzifan.data_structures._06_set.impl;

import com.yinzifan.data_structures._06_set.Set;
import com.yinzifan.data_structures._13_avl_tree.AVLTree;

public class AVLSet<T extends Comparable<T>> implements Set<T>{

	private AVLTree<T, Object> tree;
	
	public AVLSet() {
		tree = new AVLTree<>();
	}

	@Override
	public void add(T t) {
		tree.add(t, null);
	}

	@Override
	public void remove(T t) {
		tree.remove(t);
	}

	@Override
	public boolean contains(T t) {
		return tree.contains(t);
	}

	@Override
	public int getSize() {
		return tree.getSize();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}
}
