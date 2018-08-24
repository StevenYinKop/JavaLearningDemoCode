package com.yinzifan.data_structures._12_unionfind.impl;

import com.yinzifan.data_structures._12_unionfind.UnionFind;

/**
 * @author Cin 在UnionFind2Impl基础上进行深度rank的优化 同时对路径进行递归压缩
 */
public class UnionFind6Impl implements UnionFind {

	private int[] parent;
	private int[] rank;

	public UnionFind6Impl(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 1;
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
		if (p != parent[p]) {
			parent[p] = find(parent[p]);
		}
		return parent[p];
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

		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		} else if (rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		} else {
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}
	}

}
