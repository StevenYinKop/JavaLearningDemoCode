package com.yinzifan.data_structures._12_unionfind.impl;

import com.yinzifan.data_structures._12_unionfind.UnionFind;

public class UnionFindImpl implements UnionFind {

	private int[] id;

	public UnionFindImpl(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}

	private int find(int p) {
		if (p < 0 || p >= id.length)
			throw new IllegalArgumentException(p + " is out of bound.");
		return id[p];
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {

		int pId = find(p);
		int qId = find(q);

		if (pId == qId) {
			return;
		}

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
	}
}
