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
		if(node.k.compareTo(k) > 0) {
			return add(node.left, k, v);
		} else if(node.k.compareTo(k) < 0) {
			return add(node.right, k, v);
		} else {
			node.v = v;
		}
		return node;
	}

	@Override
	public boolean contains(K k) {
		return getNode(root, k) != null;
	}
	
	private BSTMap<K, V>.Node getNode(BSTMap<K, V>.Node node, K k) {
		if(node == null) {
			return null;
		}
		if (node.k.compareTo(k) > 0) {
			return getNode(node.left, k);
		}else if (node.k.compareTo(k) < 0) {
			return getNode(node.right, k);
		}else {
			return node;
		}
	}
	
//	private boolean contains(K k, BSTMap<K, V>.Node node) {
//		if (node == null) {
//			return false;
//		}
//		if (k.equals(node.k)) {
//			return true;
//		}
//		if (node.k.compareTo(k) > 0) {
//			return contains(k, node.left);
//		}
//		if (node.k.compareTo(k) < 0) {
//			return contains(k, node.right);
//		}
//		return false;
//	}

	@Override
	public V get(K k) {
		return getNode(root, k) == null ? null : getNode(root, k).v;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	

	public K getMin() {
		if(root == null) {
			return null;
		}
		return getMin(root).k;
	}
	
	private Node getMin(BSTMap<K, V>.Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
	public K getMax() {
		return getMax(root).k;
	}
	
	private Node getMax(BSTMap<K, V>.Node node) {
		if(node.right == null) {
			return node;
		}
		return getMax(node.right);
	}
	
	public K removeMin() {
		K ret = getMin();
		root = removeMin(root);
		return ret;
	}

	private Node removeMin(BSTMap<K, V>.Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	public K removeMax() {
		K ret = getMax();
		root = removeMax(root);
		return ret;
	}
	
	private Node removeMax(BSTMap<K, V>.Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	@Override
	public V remove(K k) {
		Node node = getNode(root, k);
		if(node == null) {
			return null;
		} 
		root = remove(root, k);
		return node.v;
	}

	private Node remove(Node node, K k) {
		if(node == null) {
			return null;
		}
		if(node.k.compareTo(k) < 0) {
			node.left = remove(node.left, k);
			return node;
		}else if(node.k.compareTo(k) > 0) {
			node.right = remove(node.right, k);
			return node;
		}
		else {
			// node.left == null时
			// 得到node的right
			// 将node.right置null
			// size --
			// 将 rightnode 作为根节点返回
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			
			// node.right == null时
			// 得到node的left
			// 将node.left置null
			// size --
			// 将 leftnode 作为根节点返回
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			// 待删除节点左右子树均不为空
			// 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node successor = getMin(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;
			return successor;			
		}
	}
	

	private class Node {
		private K k;
		private V v;
		private Node left;
		private Node right;

//		public Node() {
//		}

		public Node(K k, V v) {
			this.k = k;
			this.v = v;
		}

//		public Node(K k, V v, Node left, Node right) {
//			this.k = k;
//			this.v = v;
//			this.left = left;
//			this.right = right;
//		}

		@Override
		public String toString() {
			return "k=" + k + ", v=" + v + "";
		}
	}
}
