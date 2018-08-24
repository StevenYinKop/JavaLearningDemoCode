package com.yinzifan.data_structures._12_unionfind.impl;

import com.yinzifan.data_structures._12_unionfind.UnionFind;

public class UnionFind2Impl implements UnionFind {

	private int[] parent;

	public UnionFind2Impl(int size) {
		parent = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException(p + "is out of bound.");
		}
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	/**
	 * 查看元素p和元素q是否所属一个集合 O(h)复杂度, h为树的高度
	 */
	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		parent[pRoot] = qRoot;
	}

}
