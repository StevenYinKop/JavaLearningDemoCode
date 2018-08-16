package com.yinzifan.data_structures._07_map.impl;

import com.yinzifan.data_structures._07_map.Map;

public class LinkedListMap<K, V> implements Map<K, V> {

	@Override
	public void add(K k, V v) {
		
	}

	@Override
	public V remove(K k) {
		return null;
	}

	@Override
	public boolean contains(K k) {
		return false;
	}

	@Override
	public V get(K k) {
		return null;
	}

	@Override
	public void set(K k, V v) {
		
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
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
		public Node(K k) { this(k, null, null); }
		
		public Node() { this(null, null, null); }
		@Override
		public String toString() {
			return key.toString() + ":" + value.toString();
		}
	}	
}
