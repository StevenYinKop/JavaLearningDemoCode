package com.yinzifan.data_structures._07_map;

import java.util.Random;

import com.yinzifan.data_structures._01_array.Array;
import com.yinzifan.data_structures._07_map.impl.BSTMap;
import com.yinzifan.data_structures._13_avl_tree.AVLTree;
import com.yinzifan.data_structures._14_redblack_tree.RBTree;

/**
 * 对于完全随机的数据, 普通的二分搜索树已经很好用了;
 * 但是如果数据不够随机, 在极端的情况下可能退化成链表(或者高度不平衡)
 * 对于查询较多的使用情况, AVL树很好用;
 * 红黑树牺牲了平衡性(2logn的高度);
 * 红黑树统计性能更优(综合增删改查所有的操作)
 * @author Cin
 *
 */
public class TestAdd {

	public static void main(String[] args) {
		
		int n = 20_000_000;
		Array<Integer> arr = new Array<>();
		Random random = new Random();
		for(int i = 0; i<n; i ++) {
			arr.addLast(random.nextInt(n));
		}
		double time1 = addTest(arr, new RBTree<>());
		double time2 = addTest(arr, new AVLTree<>());
		double time3 = addTest(arr, new BSTMap<>());
		
		System.out.println("RBTree: " + time1 + "s");
		System.out.println("AVLTree: " + time2 + "s");
		System.out.println("BST: " + time3 + "s");
	}

	private static double addTest(Array<Integer> arr, Map<Integer, Integer> rbTree) {
		long startTime = System.nanoTime();
		for(int i = 0; i< arr.getSize(); i ++) {
			rbTree.add(arr.get(i), null);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1_000_000_000.0;
	}
}
