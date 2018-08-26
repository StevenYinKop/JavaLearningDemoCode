package com.yinzifan.data_structures._07_map.impl;

import com.yinzifan.data_structures._07_map.Map;
import com.yinzifan.data_structures._13_avl_tree.AVLTree;

public class AVLMap <K extends Comparable<K>, V> implements Map<K, V>{
	private AVLTree<K, V> tree;
	
	
	public AVLMap() {
		tree = new AVLTree<>();
	}

	@Override
	public void add(K k, V v) {
		tree.add(k, v);
	}

	@Override
	public V remove(K k) {
		return tree.remove(k);
	}

	@Override
	public boolean contains(K k) {
		return tree.contains(k);
	}

	@Override
	public V get(K k) {
		return tree.get(k);
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
