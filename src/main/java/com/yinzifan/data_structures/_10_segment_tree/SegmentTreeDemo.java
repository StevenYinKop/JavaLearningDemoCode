package com.yinzifan.data_structures._10_segment_tree;

import java.util.Random;

public class SegmentTreeDemo {
	public static void main(String[] args) {
		Integer[] arr = new Integer[5];
		Random ran = new Random();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int r = ran.nextInt(100);
			max = max < r ? r : max;
			arr[i] = r; 
		}
		SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merger<Integer>() {
			@Override
			public Integer merge(Integer t1, Integer t2) {
				return t1 < t2 ? t2 : t1;
			}
		});
//		if(segmentTree.get(0) == max) {
//			System.out.println("???????????");
//		}
//		System.out.println("segmentTree.get(0) = " + segmentTree.get(0));
//		System.out.println("max = " + max);
	}
}
