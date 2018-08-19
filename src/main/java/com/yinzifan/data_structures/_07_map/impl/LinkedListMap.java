package com.yinzifan.data_structures._07_map.impl;

import java.util.function.BiConsumer;

import com.yinzifan.data_structures._07_map.Map;

public class LinkedListMap<K, V> implements Map<K, V> {

	private Node dummyHead;
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}

	@Override
	public void add(K k, V v) {
		Node node = getNode(k);
		if(node == null) {
			dummyHead.next = new Node(k, v, dummyHead.next);
			size ++;
		} else {
			node.value = v;
		}
	}
	
	private Node getNode(K k) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.key.equals(k)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	@Override
	public V remove(K k) {
		Node pre = dummyHead;
		while(pre.next != null) {
			if(pre.next.key.equals(k)) {
				break;
			}
			pre = pre.next;
		}
		if(pre.next != null) {
			Node delNode = pre.next;
			V v = pre.next.value;
			pre.next = pre.next.next;
			delNode.next = null;
			return v;
		}
		return null;
	}

	@Override
	public boolean contains(K k) {
		return getNode(k) != null;
	}

	@Override
	public V get(K k) {
		Node node = getNode(k);
		return node == null ? null : node.value;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void forEach(BiConsumer<K, V> c) {
		Node cur = dummyHead.next;
		while(cur != null) {
			c.accept(cur.key, cur.value);
			cur = cur.next;
		}
	}
	
	private class Node {
		public K key;
		public V value;
		public Node next;
		public Node(K key, V value, Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
//		public Node(K k) { this(k, null, null); }
		
		public Node() { this(null, null, null); }
		@Override
		public String toString() {
			return key.toString() + ":" + value.toString();
		}
	}	
}
