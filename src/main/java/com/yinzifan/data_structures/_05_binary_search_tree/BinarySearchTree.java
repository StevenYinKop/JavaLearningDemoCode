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
			add(root, t);
		}
	}
	
	private void add(Node root, T t) {
		if(t.equals(root.t)) {
			return;
		} else if(t.compareTo(root.t) < 0) {
			if(root.left == null) {
				root.left = new Node(t);
				size ++;
				return;
			}
			add(root.left, t);
		} else if(t.compareTo(root.t) > 0) {
			if( root.right == null) {
				root.right = new Node(t);
				size ++;
				return;
			}
			add(root.right, t);
		}
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
