package com.yinzifan.data_structures._05_binary_search_tree;

import java.util.function.Consumer;

import com.yinzifan.data_structures._03_queue.Queue;
import com.yinzifan.data_structures._04_linkedlist.LinkedListQueue;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node root;
	private int size;
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	public void clear() {
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
		this.root = add(this.root, t);
	}
	
	private Node add(Node root, T t) {
		if(root == null) {
			size ++;
			return new Node(t);
		}
		if(t.compareTo(root.t) < 0) {
			root.left = add(root.left, t);
		} else if (t.compareTo(root.t) > 0) {
			root.right = add(root.right, t);
		}
		return root;
	}
	
	public boolean contains(T t) {
		return contains(root, t);
	}
	
	
	private boolean contains(BinarySearchTree<T>.Node node, T t) {
		if(node == null) {
			return false;
		}
		if(t.equals(node.t)) {
			return true;
		} else if(t.compareTo(node.t) > 0) {
			return contains(node.right, t);
		} else {
			return contains(node.left, t);
		}
	}
	/**
	 * @param consumer
	 */
	public void preOrder(Consumer<T> consumer) {
		preOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void preOrder(BinarySearchTree<T>.Node node, Consumer<T> consumer) {
		if(node == null) {
			return;
		}
		consumer.accept(node.t);
		preOrder(node.left, consumer);
		preOrder(node.right, consumer);
	}
	/**
	 * @param consumer
	 */
	public void inOrder(Consumer<T> consumer) {
		inOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void inOrder(BinarySearchTree<T>.Node node, Consumer<T> consumer) {
		if(node == null) {
			return;
		}
		inOrder(node.left, consumer);
		consumer.accept(node.t);
		inOrder(node.right, consumer);
	}
	/**
	 * @param consumer
	 */
	public void postOrder(Consumer<T> consumer) {
		postOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void postOrder(BinarySearchTree<T>.Node node, Consumer<T> consumer) {
		if(node == null) {
			return;
		}
		postOrder(node.left, consumer);
		postOrder(node.right, consumer);
		consumer.accept(node.t);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BST: \n");
		return toString(root, 0, sb);
	}


	private String toString(BinarySearchTree<T>.Node node, int dept, StringBuilder sb) {
		for(int i = 0; i < dept; i ++) {
			sb.append("--");
		}
		if(node == null) {
			sb.append("NULL\n");
			return sb.toString();
		}
		sb.append(node.t.toString() + "\n");
		toString(node.left, dept + 1, sb);
		toString(node.right, dept + 1, sb);
		return sb.toString();
	}

	public void levelOrder(Consumer<T> consumer) {
		Queue<Node> q = new LinkedListQueue<>();
		q.enqueue(root);
		while(!q.isEmpty()) {
			Node cur = q.dequeue();
			consumer.accept(cur.t);
			if(cur.left!=null) {
				q.enqueue(cur.left);
			}
			if(cur.right!=null) {
				q.enqueue(cur.right);
			}
		}
	}
	
	public T getMin() {
		if(root == null) {
			return null;
		}
		return getMin(root).t;
	}
	
	private Node getMin(BinarySearchTree<T>.Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
	public T getMax() {
		return getMax(root).t;
	}
	
	private Node getMax(BinarySearchTree<T>.Node node) {
		if(node.right == null) {
			return node;
		}
		return getMax(node.right);
	}
	
	public T removeMin() {
		T ret = getMin();
		root = removeMin(root);
		return ret;
	}

	private Node removeMin(BinarySearchTree<T>.Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	public T removeMax() {
		T ret = getMax();
		root = removeMax(root);
		return ret;
	}
	
	private Node removeMax(BinarySearchTree<T>.Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	public void remove(T t) {
		root = remove(root, t);
	}
	
	public Node remove(Node node, T t) {
		if(node == null) {
			return null;
		}
		if(node.t.compareTo(t) < 0) {
			node.left = remove(node.left, t);
			return node;
		}else if(node.t.compareTo(t) > 0) {
			node.right = remove(node.right, t);
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
