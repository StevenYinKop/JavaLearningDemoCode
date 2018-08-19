package com.yinzifan.data_structures._07_map.impl;

import com.yinzifan.data_structures._07_map.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
	private Node root;
	private int size;

	public BSTMap() {
		root = null;
		size = 0;
	}

	@Override
	public void add(K k, V v) {
		root = add(root, k, v);
	}

	private BSTMap<K, V>.Node add(BSTMap<K, V>.Node node, K k, V v) {
		if(node == null) {
			size++;
			return new Node(k, v);
		}
		if(k.compareTo(node.k) > 0) {
			return add(node.left, k, v);
		} else if(k.compareTo(node.k) < 0) {
			return add(node.right, k, v);
		}
		return node;
	}

	@Override
	public V remove(K k) {
		return null;
	}

	@Override
	public boolean contains(K k) {
		return contains(k, root);
	}

	private boolean contains(K k, BSTMap<K, V>.Node node) {
		if (node == null) {
			return false;
		}
		if (k.equals(node.k)) {
			return true;
		}
		if (node.k.compareTo(k) > 0) {
			return contains(k, node.left);
		}
		if (node.k.compareTo(k) < 0) {
			return contains(k, node.right);
		}
		return false;
	}

	@Override
	public V get(K k) {

		return null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private class Node {
		private K k;
		private V v;
		private Node left;
		private Node right;

		public Node() {
		}

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
		}

		public Node(K k, V v, Node left, Node right) {
			this.k = k;
			this.v = v;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "k=" + k + ", v=" + v + "";
		}
	}
}
