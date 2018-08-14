package com.yinzifan.data_structures._04_linkedlist;

import com.yinzifan.data_structures._03_queue.Queue;

public class LinkedListQueue<T> implements Queue<T>{
	private Node head;
	private Node tail;
	private int size;
	public LinkedListQueue() {
		head = null;
		tail = null;
	}
	@Override
	public void enqueue(T t) {
		if(tail == null) {
			tail = new Node(t);
			head = tail;
		} else {
			tail.next = new Node(t);
			tail = tail.next;
		}
		size ++;
	}
	@Override
	public T dequeue() {
		if(head == null) {
			return null;
		}
		Node retNode = head;
		head = head.next;
		retNode.next = null;
		if(head == null) {
			tail = null;
		}
		size --;
		return retNode.t;
	}
	@Override
	public T getFront() {
		if(head == null) {
			return null;
		}
		return head.t;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Queue: front: ");
		
		Node cur = head;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL tail");
		return res.toString();
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
//		public Node() { this(null,null); }
		@Override
		public String toString() {
			return t.toString();
		}
	}
}
