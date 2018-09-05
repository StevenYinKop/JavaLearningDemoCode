package com.yinzifan.data_structures._15_hashcode;

import java.util.Set;
import java.util.TreeMap;

import com.yinzifan.data_structures._07_map.Map;

@SuppressWarnings("unchecked")
public class HashTable <K, V> implements Map<K, V>{
	private int size;
	private TreeMap<K, V>[] arr;
	
	private final static int upperTolerance = 10;
	private final static int lowerTolerance = 2;
	private final static int initCapacity = 7;
	
	private int M;
	
	public HashTable() {
		this(initCapacity);
	}
	public HashTable(int M) {
		this.M = M;
		size = 0;
		arr = new TreeMap[M];
		for(int i = 0; i < M; i ++) {
			arr[i] = new TreeMap<>();
		}
	}
	
	private int hash(K k) {
		return (k.hashCode() & 0x7fffffff) % M; // 消除符号后取模
	}
	
	@Override
	public void add(K k, V v) {
		TreeMap<K, V> tree = arr[hash(k)];
		if(tree.containsKey(k)) {
			tree.put(k, v);
			size++;
		} else {
			tree.put(k, v);
			if(size >= upperTolerance * M) {
				resize(2 * M);
			}
		}
	}
	@Override
	public V remove(K k) {
		TreeMap<K, V> tree = arr[hash(k)];
		V ret = null;
		if(tree.containsKey(k)) {
			ret = tree.remove(k);
			size --;
		}
		if(size <= (lowerTolerance * M) && M / 2 >= initCapacity) {
			resize(M / 2);
		}
		return ret;
	}
	@Override
	public boolean contains(K k) {
		return arr[hash(k)].containsKey(k);
	}
	@Override
	public V get(K k) {
		return arr[hash(k)].get(k);
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	private void resize(int newM) {
		TreeMap<K, V>[] newTree = new TreeMap[newM];
		for(int i = 0; i < newM; i ++) {
			newTree[i] = new TreeMap<>();
		}
		int oldM = M;
		this.M = newM;
		for(int i = 0; i < oldM; i ++) {
			TreeMap<K, V> treeMap = arr[i];
			Set<K> keySet = treeMap.keySet();
			for (K k : keySet) {
				newTree[hash(k)].put(k, treeMap.get(k));
			}
		}
		this.arr = newTree;
	}
}
