package com.yinzifan.data_structures._09_Heap;

import java.util.Random;

public class MaxHeapDemo {

	
	private static double testHeapConstructor(Integer[] testData, boolean isHeapify) {
		long startTime = System.nanoTime();
		MaxHeap<Integer> maxHeap;
		if(isHeapify) {
			maxHeap = new MaxHeap<>(testData);
		} else {
			maxHeap = new MaxHeap<>();
			for (Integer i : testData) {
				maxHeap.add(i);
			}
		}
		int size = testData.length;
		int [] arr = new int[size];
		for(int i = 0; i < size; i ++) {
			arr[i] = maxHeap.extractMax();
		}
		for(int i = 1; i < size; i ++) {
			if(arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1_000_000_000.0;
	}
	
	private static void testSiftDown(MaxHeap<Integer> maxHeap, int n) {
		int [] arr = new int[n];
		for(int i = 0; i < n; i ++) {
			arr[i] = maxHeap.extractMax();
		}
		for(int i = 1; i < n; i ++) {
			if(arr[i - 1] < arr[i]) {
				throw new IllegalArgumentException("Error");
			}
		}
		System.out.println(" Test MaxHeap completed!");
	}
	
	public static void main(String[] args) {
		int n = 1_000_000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Integer [] arr = new Integer[n];
		Random ran = new Random();
		for(int i = 0; i < n; i ++) {
			arr[i] = ran.nextInt(Integer.MAX_VALUE);
		}
		for(int i = 0; i < n; i ++) {
			maxHeap.add(ran.nextInt(Integer.MAX_VALUE));
		}
		testSiftDown(maxHeap, n);
		System.out.println("with Heapify: " + testHeapConstructor(arr, true) + "s");
		System.out.println("without Heapify: " + testHeapConstructor(arr, false) + "s");
	}
}
