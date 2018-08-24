package com.yinzifan.data_structures._12_unionfind;

import java.util.Random;

import com.yinzifan.data_structures._12_unionfind.impl.UnionFind2Impl;
import com.yinzifan.data_structures._12_unionfind.impl.UnionFind3Impl;
import com.yinzifan.data_structures._12_unionfind.impl.UnionFind4Impl;
import com.yinzifan.data_structures._12_unionfind.impl.UnionFind5Impl;
import com.yinzifan.data_structures._12_unionfind.impl.UnionFind6Impl;
import com.yinzifan.data_structures._12_unionfind.impl.UnionFindImpl;

public class UFDemo {

	private static double testUF(UnionFind uf, int m) {
		int size = uf.getSize();
		Random ran = new Random();
		long startTime = System.nanoTime();
		for(int i = 0; i < m; i ++) {
			int a = ran.nextInt(size);
			int b = ran.nextInt(size);
			uf.unionElements(a, b);
		}
		for(int i = 0; i < m; i ++) {
			int a = ran.nextInt(size);
			int b = ran.nextInt(size);
			uf.isConnected(a, b);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1_000_000_000.0;
	}
	
	public static void main(String[] args) {
		int size = 10_000_000;
		int m = 10_000_000;
//		System.out.println("UnionFind1 : " + testUF(new UnionFindImpl(size), m) + " s.");
//		System.out.println("UnionFind2 : " + testUF(new UnionFind2Impl(size), m) + " s.");
		System.out.println("UnionFind3 : " + testUF(new UnionFind3Impl(size), m) + " s.");
		System.out.println("UnionFind4 : " + testUF(new UnionFind4Impl(size), m) + " s.");
		System.out.println("UnionFind5 : " + testUF(new UnionFind5Impl(size), m) + " s.");
		System.out.println("UnionFind6 : " + testUF(new UnionFind6Impl(size), m) + " s.");
	}
	
}
