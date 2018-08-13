package com.yinzifan.data_structures._04_linkedlist;

import com.yinzifan.data_structures._03_queue.Queue;

public class LinkedListQueue<T> implements Queue<T>{
	private class Node {
		public T t;
		public Node next;
		public Node(T t, Node next) {
			super();
			this.t = t;
			this.next = next;
		}
//		public Node(T t) { this(t, null); }
		public Node() { this(null,null); }
		@Override
		public String toString() {
			return t.toString();
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public void enqueue(T t) {
		
	}
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
