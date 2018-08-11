package com.yinzifan.data_structures._04_linkedlist;

public class LinkedList<T> {
	private Node dummyHead;
	private int size;
	public LinkedList() {
		super();
		this.dummyHead = new Node();
		size = 0;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * @param t
	 * @param index
	 */
	public void add(T t, int index) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
//		if(index == 0) {
//			addFirst(t);
//		}
		Node pre = dummyHead;
		for(int i = 0; i < index ; i ++) {
				pre = pre.next;
		}
//		Node node = new Node(t);
//		node.next = pre.next;
//		pre.next = node;
		pre.next = new Node(t, pre.next);
		size++;
	}
	
	/**
	 * @param t
	 */
	public void addFirst(T t) {
//		head = new Node(t, head);
//		size ++;
		add(t, 0);
	}
	
	/**
	 * @param t
	 */
	public void addLast(T t) {
		add(t, size);
	}

	/**
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node cur = dummyHead.next;
		for(int i = 0; i < index ; i ++) {
			cur = cur.next;
		}
		return cur.t;
	}
	 
	/**
	 * @return
	 */
	public T getFirst() {
		return get(0);
	}
	
	/**
	 * @return
	 */
	public T getLast() {
		return get(size - 1);
	}
	
	/**
	 * @param index
	 * @param t
	 */
	public void set(int index, T t) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node cur = dummyHead.next;
		for(int i = 0; i < index ; i ++) {
			cur = cur.next;
		}
		cur.t = t;
	}
	
	/**
	 * @param t
	 * @return
	 */
	public boolean contains(T t) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.t.equals(t)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	public void remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	private class Node {
		public T t;
		public Node next;
		public Node(T t, Node next) {
			super();
			this.t = t;
			this.next = next;
		}
		public Node(T t) { this(t, null); }
		public Node() { this(null,null); }
		@Override
		public String toString() {
			return t.toString();
		}
	}
}
