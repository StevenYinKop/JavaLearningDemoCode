package com.yinzifan.data_structures._05_binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	private int size;
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T t) {
		if(root == null) {
			root = new Node(t);
			size ++;
		} else {
			this.root = add(this.root, t);
		}
	}
	
	private Node add(Node root, T t) {
		if(root == null) {
			return new Node(t);
		}
		if(t.compareTo(root.t) < 0) {
			root.left = add(root.left, t);
		} else if (t.compareTo(root.t) > 0) {
			root.right = add(root.right, t);
		}
		return root;
	}
	
	private class Node{
		private T t;
		private Node left;
		private Node right;
		
		public Node(T t) {
			this.t = t;
			left = null;
			right = null;
		}
	}
}
