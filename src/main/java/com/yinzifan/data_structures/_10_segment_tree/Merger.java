package com.yinzifan.data_structures._10_segment_tree;

@FunctionalInterface
public interface Merger <T>{
	T merge(T t1, T t2);
}
