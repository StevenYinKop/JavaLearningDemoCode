package com.yinzifan.data_structures._14_redblack_tree;

import java.util.function.BiConsumer;

import com.yinzifan.data_structures._03_queue.Queue;
import com.yinzifan.data_structures._04_linkedlist.LinkedListQueue;

public class RBTree<K extends Comparable<K>, V> {
	
	private Node root;
	private int size;
	public RBTree() {
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
	
	private boolean isRed(Node node) {
		if(node == null) {
			return BLACK;
		}
		return node.color;
	}

	private Node leftRotate(Node node) {
		Node x= node.right;
		node.right = x.left;
		x.left = node;
		
		x.color = node.color;
		node.color = RED;
		return x;
	}
	
	private void flipColor(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}
	
	public void add(K k, V v) {
		this.root = add(this.root, k, v);
		this.root.color = BLACK;
	}
	
	private Node add(Node root, K k, V v) {
		if(root == null) {
			size ++;
			return new Node(k, v);
		} 
		if(k.compareTo(root.k) < 0) {
			root.left = add(root.left, k, v);
		} else if (k.compareTo(root.k) > 0) {
			root.right = add(root.right, k, v);
		}
		return root;
	}
	
	public boolean contains(K k) {
		return contains(root, k);
	}
	
	
	private boolean contains(RBTree<K, V>.Node node, K k) {
		if(node == null) {
			return false;
		}
		if(k.equals(node.k)) {
			return true;
		} else if(k.compareTo(node.k) > 0) {
			return contains(node.right, k);
		} else {
			return contains(node.left, k);
		}
	}
	/**
	 * @param consumer
	 */
	public void preOrder(BiConsumer<K, V> consumer) {
		preOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void preOrder(RBTree<K, V>.Node node, BiConsumer<K, V> consumer) {
		if(node == null) {
			return;
		}
		consumer.accept(node.k, node.v);
		preOrder(node.left, consumer);
		preOrder(node.right, consumer);
	}
	/**
	 * @param consumer
	 */
	public void inOrder(BiConsumer<K, V> consumer) {
		inOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void inOrder(RBTree<K, V>.Node node, BiConsumer<K, V> consumer) {
		if(node == null) {
			return;
		}
		inOrder(node.left, consumer);
		consumer.accept(node.k, node.v);
		inOrder(node.right, consumer);
	}
	/**
	 * @param consumer
	 */
	public void postOrder(BiConsumer<K, V> consumer) {
		postOrder(root, consumer);
	}
	/**
	 * @param node
	 * @param consumer
	 */
	private void postOrder(RBTree<K, V>.Node node, BiConsumer<K, V> consumer) {
		if(node == null) {
			return;
		}
		postOrder(node.left, consumer);
		postOrder(node.right, consumer);
		consumer.accept(node.k, node.v);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BST: \n");
		return toString(root, 0, sb);
	}


	private String toString(RBTree<K, V>.Node node, int dept, StringBuilder sb) {
		for(int i = 0; i < dept; i ++) {
			sb.append("--");
		}
		if(node == null) {
			sb.append("NULL\n");
			return sb.toString();
		}
		sb.append(node.k.toString() + "\n");
		toString(node.left, dept + 1, sb);
		toString(node.right, dept + 1, sb);
		return sb.toString();
	}

	public void levelOrder(BiConsumer<K, V> consumer) {
		Queue<Node> q = new LinkedListQueue<>();
		q.enqueue(root);
		while(!q.isEmpty()) {
			Node cur = q.dequeue();
			consumer.accept(cur.k, cur.v);
			if(cur.left!=null) {
				q.enqueue(cur.left);
			}
			if(cur.right!=null) {
				q.enqueue(cur.right);
			}
		}
	}
	
	public V getMin() {
		if(root == null) {
			return null;
		}
		return getMin(root).v;
	}
	
	private Node getMin(RBTree<K, V>.Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
	public V getMax() {
		return getMax(root).v;
	}
	
	private Node getMax(RBTree<K, V>.Node node) {
		if(node.right == null) {
			return node;
		}
		return getMax(node.right);
	}
	
	public V removeMin() {
		V ret = getMin();
		root = removeMin(root);
		return ret;
	}

	private Node removeMin(RBTree<K, V>.Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	public V removeMax() {
		V ret = getMax();
		root = removeMax(root);
		return ret;
	}
	
	private Node removeMax(RBTree<K, V>.Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	public void remove(K k) {
		root = remove(root, k);
	}
	
	public Node remove(Node node, K k) {
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


	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		private K k;
		private V v;
		private Node left;
		private Node right;
		
		private boolean color;
		public Node(K k, V v) {
			this.k = k;
			this.v = v;
			left = null;
			right = null;
			color = RED;
		}
	}
}
