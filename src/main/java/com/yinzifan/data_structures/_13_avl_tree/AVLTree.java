package com.yinzifan.data_structures._13_avl_tree;

import java.util.ArrayList;

import com.yinzifan.data_structures._07_map.Map;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V>{
	private Node root;
	private int size;
	private int height;
	
	public int getHeight() {
		return height;
	}

	public AVLTree() {
		root = null;
		size = 0;
		height = 1;
	}

	/**
	 * 判断当前的树是否是一个二分搜索树(BST)
	 * @return
	 */
	
	public boolean isBST() {
		ArrayList<K> keys = new ArrayList<>();
		inOrder(root, (k ,v) -> keys.add(k));
		for(int i = 1; i< keys.size(); i ++) {
			if(keys.get(i - 1).compareTo(keys.get(i)) > 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 对进行中序遍历
	 * @param node
	 * @param action
	 */
	
	public void inOrder(AVLTree<K, V>.Node node, InOrderAction<K, V> action) {
		
		if(node == null) {
			return;
		}
		inOrder(node.left, action);
		action.doing(node.k, node.v);
		inOrder(node.right, action);
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	private boolean isBalanced(AVLTree<K, V>.Node node) {
		if(node == null) {
			return true;
		}
		if(Math.abs(getBalanceFactor(node)) >= 2) {
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}

	public void add(K k, V v) {
		root = add(root, k, v);
	}
	
	private int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	private int getBalanceFactor(Node node) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)          z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
	private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
	}
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)          y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;
		
		// 向右旋转过程
		x.left = y;
		y.right = T2;
		
		// 更新height
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		
		return x;
	}
	
	private Node add(AVLTree<K, V>.Node node, K k, V v) {
		if(node == null) {
			size++;
			return new Node(k, v);
		}
		if(node.k.compareTo(k) < 0) {
			node.right = add(node.right, k, v);
		} else if(node.k.compareTo(k) > 0){
			node.left = add(node.left, k, v);
		} else {
			node.v = v;
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balanceFactor = getBalanceFactor(node);
		// LL
		if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
			return rightRotate(node);
		// RR
		} else if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
			return leftRotate(node);
		}
		// LR
		if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// RL
		if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	private AVLTree<K, V>.Node getNode(AVLTree<K, V>.Node node, K k) {
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

	public boolean contains(K k) {
		return getNode(root, k) != null;
	}
	public K getMin() {
		if(root == null) {
			return null;
		}
		return getMin(root).k;
	}
	
	private Node getMin(AVLTree<K, V>.Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
	public K getMax() {
		return getMax(root).k;
	}
	
	private Node getMax(AVLTree<K, V>.Node node) {
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

	private Node removeMin(AVLTree<K, V>.Node node) {
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
	
	private Node removeMax(AVLTree<K, V>.Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}

    /**
     * 从二分搜索树中删除键为key的节点
     * @param k
     * @return
     */
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
		Node retNode;
		if(node.k.compareTo(k) < 0) {
			node.left = remove(node.left, k);
			retNode =  node;
		}else if(node.k.compareTo(k) > 0) {
			node.right = remove(node.right, k);
			retNode = node;
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
				retNode = rightNode;
			}
			
			// node.right == null时
			// 得到node的left
			// 将node.left置null
			// size --
			// 将 leftnode 作为根节点返回
			else if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				retNode = leftNode;
			}
			// 待删除节点左右子树均不为空
			// 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			else {
				Node successor = getMin(node.right);
				successor.right = remove(node.right, successor.k);
				successor.left = node.left;
				node.left = node.right = null;
				retNode = successor;
			}
		}
		if(retNode == null) {
			return null;
		}
		retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
		int balanceFactor = getBalanceFactor(retNode);
		// LL
		if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
			return rightRotate(retNode);
		// RR
		} else if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
			return leftRotate(retNode);
		}
		// LR
		if(balanceFactor > 1 && getBalanceFactor(retNode.right) < 0) {
			retNode.left = leftRotate(retNode.left);
			return rightRotate(retNode);
		}
		// RL
		if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
			retNode.right = rightRotate(retNode.right);
			return leftRotate(retNode);
		}
		return retNode;
	}
	public V get(K k) {
		Node node = getNode(root, k);
		return node == null ? null : node.v; 
	}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	private class Node {
		K k;
		V v;
		Node left;
		Node right;
		int height;
		
		public Node(K k, V v) {
			this.k = k;
			this.v = v;
			left = null;
			right = null;
			height = 1;
		}
	}
}
