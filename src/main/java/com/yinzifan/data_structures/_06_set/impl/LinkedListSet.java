package com.yinzifan.data_structures._06_set.impl;

import com.yinzifan.data_structures._04_linkedlist.LinkedList;
import com.yinzifan.data_structures._06_set.Set;

public class LinkedListSet<T> implements Set<T>{

	private LinkedList<T> list;
	
	@Override
	public void add(T t) {
		if(!list.contains(t)) {
			list.addFirst(t);
		}
	}

	@Override
	public void remove(T t) {
		list.removeElement(t);
	}

	@Override
	public boolean contains(T t) {
		return list.contains(t);
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
