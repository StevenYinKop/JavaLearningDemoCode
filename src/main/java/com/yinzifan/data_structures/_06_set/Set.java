package com.yinzifan.data_structures._06_set;

public interface Set<T> {

	void add(T t);
	
	void remove(T t);
	
	boolean contains(T t);
	
	int getSize();

	boolean isEmpty();
}
