package com.yinzifan.data_structures._12_unionfind.impl;

import com.yinzifan.data_structures._12_unionfind.UnionFind;

/**
 * @author Cin 在UnionFind2Impl的基础上进行size的优化.
 */
public class UnionFind3Impl implements UnionFind {

	private int[] parent;
	private int[] sz;

	public UnionFind3Impl(int size) {
		parent = new int[size];
		sz = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			sz[i] = 1;
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
		if (sz[pRoot] > sz[qRoot]) {
			parent[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		} else {
			parent[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		}
	}

}
